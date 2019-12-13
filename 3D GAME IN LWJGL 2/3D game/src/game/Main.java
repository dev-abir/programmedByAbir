package game;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Entity;
import Models.RawModel;
import Models.TexturedModel;
import Shader.StaticShader;
import engine.Loader;
import engine.Renderer;
import engine.WindowManager;
import textures.ModelTexture;
import textures.TextureManager;
import utils.OBJLoader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		WindowManager windowManager = new WindowManager(500, 500, 60, false, true, "Created by Abir Ganguly");
		
		windowManager.createWindow();
		
		Loader loader = new Loader();
		
		float FOV = 60;
		float NEAR_PLANE = 0.1f;
		float FAR_PLANE = 1000;
		
		StaticShader staticShader = new StaticShader();
		
		
		Renderer renderer = new Renderer(FOV, NEAR_PLANE, FAR_PLANE, staticShader);
		
		/*float[] vertices = {			
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,0.5f,-0.5f,		
				
				-0.5f,0.5f,0.5f,	
				-0.5f,-0.5f,0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				0.5f,0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				-0.5f,-0.5f,0.5f,	
				-0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,0.5f,
				-0.5f,0.5f,-0.5f,
				0.5f,0.5f,-0.5f,
				0.5f,0.5f,0.5f,
				
				-0.5f,-0.5f,0.5f,
				-0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,0.5f
				
		};
		
		float[] textureCoords = {
				
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0

				
		};
		
		int[] indices = {
				0,1,3,	
				3,1,2,	
				4,5,7,
				7,5,6,
				8,9,11,
				11,9,10,
				12,13,15,
				15,13,14,	
				16,17,19,
				19,17,18,
				20,21,23,
				23,21,22

		};*/
		
		RawModel rawModel = OBJLoader.loadModelToVAO("model", loader);
		TextureManager textureManager = new TextureManager();
		ModelTexture texture = new ModelTexture(textureManager.loadTexture("texture"));
		TexturedModel texturedModel = new TexturedModel(rawModel, texture);
		Entity entity = new Entity(texturedModel, new Vector3f(0, 0, -5), new Vector3f(0, 0, 0), 1);
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()) {
			//entity.increasePosition(0, 0, -0.1f);
			entity.increaseRotation(new Vector3f(1, 1, 0));
			camera.move();
			renderer.clearScreen();
			staticShader.start();
			//renderer.renderModel(rawModel);
			//renderer.renderModel(texturedModel);
			staticShader.loadViewMatrixToUniform(camera);
			renderer.renderModel(entity, staticShader);
			staticShader.stop();
			windowManager.updateWindow();
		}
		staticShader.destroy();
		loader.destroy();
		textureManager.destroy();
		windowManager.destroyWindow();
		System.exit(0);
	}
}
