package textures;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureManager {

	public final static String FILE_PATH = "E:\\ECLIPSE PROJECTS\\3D GAME IN LWJGL 2\\3D game\\src\\Resources\\";
	
	private ArrayList<Integer> textures = new ArrayList<Integer>();
	
	public int loadTexture(String textureFile) {
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(FILE_PATH + textureFile + ".png"));
		} catch (IOException e) {
			System.err.println("Debug message : Cannot load texture file " + textureFile);
			e.printStackTrace();
		}
		int textureID = texture.getTextureID();
		textures.add(textureID);
		return textureID;
	}
	
	public void destroy() {
		for(int eachTexture:textures) {
			GL11.glDeleteTextures(eachTexture);
		}
	}
	
}
