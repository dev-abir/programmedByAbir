#version 400 core

in vec3 position;
in vec2 textureCoords;

//out vec3 colour;
out vec2 pass_textureCoords;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main()
{
	gl_Position = projectionMatrix * viewMatrix * transformationMatrix * vec4(position.x, position.y, position.z, 1.0);
	
	//colour = vec3(position.x + 0.5, 1.0, position.y + 0.5);
	//colour = vec3(position.x + 0.5, position.y + 0.5, position.z + 0.5);
	
	pass_textureCoords = textureCoords;
}