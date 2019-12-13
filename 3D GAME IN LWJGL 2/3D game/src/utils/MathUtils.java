package utils;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;

public class MathUtils {
	public static Matrix4f createTransformationMatrix(Vector3f translation, Vector3f rotation, float scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		matrix.translate(translation);
		matrix.rotate((float) Math.toRadians(rotation.x), new Vector3f(1, 0, 0));
		matrix.rotate((float) Math.toRadians(rotation.y), new Vector3f(0, 1, 0));
		matrix.rotate((float) Math.toRadians(rotation.z), new Vector3f(0, 0, 1));
		matrix.scale(new Vector3f(scale, scale, scale));
		return matrix;
	}
	
	public static Matrix4f createViewMatrix(Camera camera) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		matrix.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1, 0, 0));
		matrix.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0, 1, 0));
		matrix.rotate((float) Math.toRadians(camera.getRoll()), new Vector3f(0, 0, 1));
		matrix.translate(new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z));
		return matrix;
	}
}
