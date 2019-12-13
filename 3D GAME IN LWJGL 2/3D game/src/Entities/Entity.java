package Entities;

import org.lwjgl.util.vector.Vector3f;

import Models.TexturedModel;

public class Entity {
	
	private TexturedModel texturedModel;
	private Vector3f position;
	private Vector3f rotation;
	private float scale;
	
	public Entity(TexturedModel texturedModel, Vector3f position, Vector3f rotation, float scale) {
		this.texturedModel = texturedModel;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x = this.position.x + dx;
		this.position.y = this.position.y + dy;
		this.position.z = this.position.z + dz;
	}
	
	public void increaseRotation(Vector3f dRotation) {
		this.rotation.x = this.rotation.x + dRotation.x;
		this.rotation.y = this.rotation.y + dRotation.y;
		this.rotation.z = this.rotation.z + dRotation.z;
	}

	public TexturedModel getTexturedModel() {
		return texturedModel;
	}

	public void setTexturedModel(TexturedModel texturedModel) {
		this.texturedModel = texturedModel;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
}
