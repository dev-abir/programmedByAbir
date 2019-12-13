package engine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import Models.RawModel;



public class Loader {
	
	private ArrayList<Integer> all_VAOS = new ArrayList<Integer>();
	private ArrayList<Integer> all_VBOS = new ArrayList<Integer>();
	
	public RawModel loadToVAO(float[] vertices, float[]textureCoords, int[] indices) {
		int VAOID = createVAO();
		bindIndecesBuffer(indices);
		storeDataInAtributeList(0, 3, vertices);
		storeDataInAtributeList(1, 2, textureCoords);
		unbindVertexArray();
		return new RawModel(VAOID, indices.length);
	}
	
	private int createVAO() {
		int VAOID = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(VAOID);
		all_VAOS.add(VAOID);
		return VAOID;
	}
	
	private void storeDataInAtributeList(int attributeID, int coordinateSize, float[] data) {
		int VBOID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBOID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeID, coordinateSize, GL11.GL_FLOAT, false, 0, 0);
		all_VBOS.add(VBOID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	private void bindIndecesBuffer(int[] indices) {
		int VBOID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, VBOID);
		IntBuffer buffer = storeDataInFloatBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	private void unbindVertexArray() {
		GL30.glBindVertexArray(0);
	}
	
	private IntBuffer storeDataInFloatBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	private FloatBuffer storeDataInFloatBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	public void destroy() {
		for(int eachVBO:all_VBOS) {
			GL15.glDeleteBuffers(eachVBO);
		}
		for(int eachVAO:all_VAOS) {
			GL30.glDeleteVertexArrays(eachVAO);
		}
	}
}
