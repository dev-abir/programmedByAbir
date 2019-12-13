package Shader;

import org.lwjgl.util.vector.Matrix4f;

import Entities.Camera;
import utils.MathUtils;

public class StaticShader extends AbstractShader {
	
	public final static String FILE_PATH = "E:\\ECLIPSE PROJECTS\\3D GAME IN LWJGL 2\\3D game\\src\\Shader\\";
	
	private final static String VERTEX_SHADER_FILE = FILE_PATH + "vertexShader.vert";
	private final static String FRAGMENT_SHADER_FILE = FILE_PATH + "fragmentShader.frag";
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;

	public StaticShader() {
		super(VERTEX_SHADER_FILE, FRAGMENT_SHADER_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttributes(0, "position");
		super.bindAttributes(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		if((location_transformationMatrix == -1) || (location_projectionMatrix == -1)) {
			System.err.print("Debug message : ");
			System.err.println("Unifor location not found!!!");
			System.exit(-1);
		}
	}
	
	public void loadProjectionMatrixToUniform(Matrix4f matrix) {
		super.loadMatrixToUniform(location_projectionMatrix, matrix);
	}
	
	public void loadTransformationMatrixToUniform(Matrix4f matrix) {
		super.loadMatrixToUniform(location_transformationMatrix, matrix);
	}
	
	public void loadViewMatrixToUniform(Camera camera) {
		Matrix4f matrix = MathUtils.createViewMatrix(camera);
		super.loadMatrixToUniform(location_viewMatrix, matrix);
	}
}
