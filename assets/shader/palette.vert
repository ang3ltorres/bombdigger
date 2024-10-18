#version 300 es
precision highp float;
precision mediump int;

in vec4 a_position;
in vec2 a_texCoord0;

out vec2 v_texCoords;

uniform mat4 u_projTrans;

void main() {
		v_texCoords = a_texCoord0;
		gl_Position = u_projTrans * a_position;
}
