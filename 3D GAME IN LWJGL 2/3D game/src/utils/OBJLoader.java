package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import Models.RawModel;
import engine.Loader;

public class OBJLoader {
	
	
	public final static String FILE_PATH = "E:\\ECLIPSE PROJECTS\\3D GAME IN LWJGL 2\\3D game\\src\\Resources\\";
	
	
	public static RawModel loadModelToVAO(String OBJ_FILE, Loader loader) throws IOException {
		FileReader fr = new FileReader(FILE_PATH + OBJ_FILE + ".obj");
		BufferedReader br = new BufferedReader(fr);
		String currentLine = "";
		ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
		ArrayList<Vector2f> textureCoords = new ArrayList<Vector2f>();
		ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
		float[] normalsArray;
		float[] texturesArray;
		float[] verticesArray;
		while((currentLine = br.readLine()) != null) {
			String[] splittedLine = currentLine.split(" ");
			if(currentLine.startsWith("v ")) {
				vertices.add(new Vector3f(Float.valueOf(splittedLine[1]), Float.valueOf(splittedLine[2]), Float.valueOf(splittedLine[3])));
			}
			else if(currentLine.startsWith("vt ")) {
				textureCoords.add(new Vector2f(Float.valueOf(splittedLine[1]), Float.valueOf(splittedLine[2])));
			}
			else if(currentLine.startsWith("vn ")) {
				normals.add(new Vector3f(Float.valueOf(splittedLine[1]), Float.valueOf(splittedLine[2]), Float.valueOf(splittedLine[3])));
			}
			else if(currentLine.startsWith("f ")) {
				break;
			}
		}
		
		normalsArray = new float[normals.size() * 3];
		texturesArray = new float[textureCoords.size() * 2];
		verticesArray = new float[vertices.size() * 3];
		
		int i = 0;
		int j = 0;
		
		do {
			String[] splittedLine = currentLine.split(" ");
			if(currentLine.startsWith("f ")) {
				String[] againSplit1 = splittedLine[1].split("/");
				String[] againSplit2 = splittedLine[2].split("/");
				String[] againSplit3 = splittedLine[3].split("/");
				
				texturesArray[i] = textureCoords.get(Integer.valueOf(againSplit1[1]) - 1).x;
				texturesArray[i + 1] = textureCoords.get(Integer.valueOf(againSplit1[1]) - 1).y;
				
				texturesArray[i] = textureCoords.get(Integer.valueOf(againSplit2[1]) - 1).x;
				texturesArray[i + 1] = textureCoords.get(Integer.valueOf(againSplit2[1]) - 1).y;
				
				texturesArray[i] = textureCoords.get(Integer.valueOf(againSplit3[1]) - 1).x;
				texturesArray[i + 1] = textureCoords.get(Integer.valueOf(againSplit3[1]) - 1).y;
				
				normalsArray[j] = normals.get(Integer.valueOf(againSplit1[2]) - 1).x;
				normalsArray[j + 1] = normals.get(Integer.valueOf(againSplit1[2]) - 1).y;
				normalsArray[j + 2] = normals.get(Integer.valueOf(againSplit1[2]) - 1).z;
				
				normalsArray[j] = normals.get(Integer.valueOf(againSplit2[2]) - 1).x;
				normalsArray[j + 1] = normals.get(Integer.valueOf(againSplit2[2]) - 1).y;
				normalsArray[j + 2] = normals.get(Integer.valueOf(againSplit2[2]) - 1).z;
				
				normalsArray[j] = normals.get(Integer.valueOf(againSplit3[2]) - 1).x;
				normalsArray[j + 1] = normals.get(Integer.valueOf(againSplit3[2]) - 1).y;
				normalsArray[j + 2] = normals.get(Integer.valueOf(againSplit3[2]) - 1).z;
				
				i = i + 2;
				j = j + 3;
			}
		}
		while((currentLine = br.readLine()) != null);
		
		j = 0;
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * No use of indices...(See the below code carefully) :(
		 * 
		 * 
		 * 
		 */
		
		int[] indicesArray = new int[verticesArray.length];
		
		for(i = 0; i < verticesArray.length; i = i + 3) {
			verticesArray[i] = vertices.get(j).x;
			verticesArray[i + 1] = vertices.get(j).y;
			verticesArray[i + 2] = vertices.get(j).z;
			indicesArray[j] = j;
			j = j + 1;
		}
		br.close();
		fr.close();
		return new Loader().loadToVAO(verticesArray, texturesArray, indicesArray);
	}
}
