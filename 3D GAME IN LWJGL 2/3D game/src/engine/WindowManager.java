package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class WindowManager {
	
	int WINDOW_WIDTH;
	int WINDOW_HEIGHT;
	int FPS;
	boolean FULSCREEN;
	boolean VSYNC;
	String TITLE;
	
	public WindowManager(int WINDOW_WIDTH, int WINDOW_HEIGHT, int FPS, boolean FULSCREEN, boolean VSYNC, String TITLE) {
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		this.FPS = FPS;
		this.FULSCREEN = FULSCREEN;
		this.VSYNC = VSYNC;
		this.TITLE = TITLE;
	}
	
	public void createWindow() {
		
		ContextAttribs attribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(TITLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void updateWindow() {
		if(VSYNC) {
			Display.sync(FPS);
		}
		Display.update();
	}
	
	public void destroyWindow() {
		Display.destroy();
	}
}
