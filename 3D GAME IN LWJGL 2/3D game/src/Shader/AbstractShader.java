package Shader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public abstract class AbstractShader {

	private int vertexShaderID;
	private int fragmentShaderID;
	private int shaderProgramID;
	
	FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(4 * 4);
	
	public AbstractShader(String vertexShaderFilePath, String fragmentShaderFilePath) {
		vertexShaderID = loadShader(vertexShaderFilePath, GL20.GL_VERTEX_SHADER);
		fragmentShaderID = loadShader(fragmentShaderFilePath, GL20.GL_FRAGMENT_SHADER);
		shaderProgramID = GL20.glCreateProgram();
		GL20.glAttachShader(shaderProgramID, vertexShaderID);
		GL20.glAttachShader(shaderProgramID, fragmentShaderID);
		bindAttributes();
		GL20.glLinkProgram(shaderProgramID);
		GL20.glValidateProgram(shaderProgramID);
		getAllUniformLocations();
	}
	
	protected abstract void getAllUniformLocations();
	
	protected int getUniformLocation(String uniformName) {
		return GL20.glGetUniformLocation(shaderProgramID, uniformName);
	}
	
	public void start() {
		GL20.glUseProgram(shaderProgramID);
	}
	
	public void stop() {
		GL20.glUseProgram(0);
	}
	
	public void destroy() {
		stop();
		GL20.glDetachShader(shaderProgramID, vertexShaderID);
		GL20.glDetachShader(shaderProgramID, fragmentShaderID);
		GL20.glDeleteShader(vertexShaderID);
		GL20.glDeleteShader(fragmentShaderID);
		GL20.glDeleteProgram(shaderProgramID);
	}
	
	protected abstract void bindAttributes();
	
	protected void bindAttributes(int attributeID, String variableName) {
		GL20.glBindAttribLocation(shaderProgramID, attributeID, variableName);
	}
	
	protected void loadFloatToUniform(int uniformLocation, float data) {
		GL20.glUniform1f(uniformLocation, data);
	}
	
	protected void loadVectorToUniform(int uniformLocation, Vector3f data) {
		GL20.glUniform3f(uniformLocation, data.x, data.y, data.z);
	}
	
	protected void loadBooleanToUniform(int uniformLocation, boolean data) {
		if(data) {
			GL20.glUniform1f(uniformLocation, 1);
		}
		else {
			GL20.glUniform1f(uniformLocation, 0);
		}
	}
	
	protected void loadMatrixToUniform(int uniformLocation, Matrix4f data) {
		data.store(matrixBuffer);
		matrixBuffer.flip();
		GL20.glUniformMatrix4(uniformLocation, false, matrixBuffer);
	}
	
	private int loadShader(String shaderFilePath, int shaderType) {
		String line = "", wholeFileString = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(shaderFilePath));
			while((line = br.readLine()) != null) {
				wholeFileString = wholeFileString + "\n" + line;
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Debug message : Could no read the file " + shaderFilePath);
			e.printStackTrace();
			System.exit(-1);
		}
		int shaderID = GL20.glCreateShader(shaderType);
		GL20.glShaderSource(shaderID, wholeFileString);
		GL20.glCompileShader(shaderID);
		if(GL20.glGetShaderi(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.print("Debug message : Could not compile shader.");
			System.err.println(GL20.glGetShaderInfoLog(shaderID, 1024));
			System.exit(-1);
		}
		return shaderID;
	}
}
