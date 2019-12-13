package Entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position;
	private float yaw;		// How much high or low the camera is(Along Y-Axis)
	private float pitch;	// How much left or right the camera is(Along X-Axis)
	private float roll;		// How much the camera is tilted to one side(If this value is 180,
							// the camera will be upside-down)
	
	public Camera() {
		this.position = new Vector3f(0, 0, 0);
		this.yaw = 0;
		this.pitch = 0;
		this.roll = 0;
	}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			position.z = position.z - 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			System.out.println("There is no movement for \'DOWN\' key.");
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			position.x = position.x - 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			position.x = position.x + 0.02f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getYaw() {
		return yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public float getRoll() {
		return roll;
	}
}
