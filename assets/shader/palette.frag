#version 300 es
precision highp float;
precision mediump int;

in vec2 v_texCoords;

uniform sampler2D u_texture;

uniform vec4 black;
uniform vec4 white;
uniform vec4 red;
uniform vec4 green;
uniform vec4 blue;
uniform vec4 cyan;
uniform vec4 magenta;
uniform vec4 yellow;

out vec4 fragColor;

bool almostEqual(vec4 a, vec4 b, float tolerance) {

	return (
		abs(a.r - b.r) < tolerance &&
		abs(a.g - b.g) < tolerance &&
		abs(a.b - b.b) < tolerance &&
		abs(a.a - b.a) < tolerance
	);
}

void main() {
	vec4 color = texture(u_texture, v_texCoords);
	float tolerance = 0.5;

	if (almostEqual(color, vec4(0.0, 0.0, 0.0, 1.0), tolerance))
		fragColor = black;
	else if (almostEqual(color, vec4(1.0, 1.0, 1.0, 1.0), tolerance))
		fragColor = white;
	else if (almostEqual(color, vec4(1.0, 0.0, 0.0, 1.0), tolerance))
		fragColor = red;
	else if (almostEqual(color, vec4(0.0, 1.0, 0.0, 1.0), tolerance))
		fragColor = green;
	else if (almostEqual(color, vec4(0.0, 0.0, 1.0, 1.0), tolerance))
		fragColor = blue;
	else if (almostEqual(color, vec4(0.0, 1.0, 1.0, 1.0), tolerance))
		fragColor = cyan;
	else if (almostEqual(color, vec4(1.0, 0.0, 1.0, 1.0), tolerance))
		fragColor = magenta;
	else if (almostEqual(color, vec4(1.0, 1.0, 0.0, 1.0), tolerance))
		fragColor = yellow;
}
