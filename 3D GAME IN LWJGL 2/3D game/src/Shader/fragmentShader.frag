#version 400 core

//in vec3 colour;
in vec2 pass_textureCoords;

out vec4 outColour;

uniform sampler2D textureSampler;

void main()
{
	outColour = texture(textureSampler, pass_textureCoords);
}