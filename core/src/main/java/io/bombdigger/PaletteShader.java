package io.bombdigger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class PaletteShader extends ShaderProgram {

	// Sprite color palette (CONSTANT)
	static final Color BLACK     = new Color(0.0f, 0.0f, 0.0f, 1.0f);
	static final Color WHITE     = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	static final Color RED       = new Color(1.0f, 0.0f, 0.0f, 1.0f);
	static final Color GREEN     = new Color(0.0f, 1.0f, 0.0f, 1.0f);
	static final Color BLUE      = new Color(0.0f, 0.0f, 1.0f, 1.0f);
	static final Color CYAN      = new Color(0.0f, 1.0f, 1.0f, 1.0f);
	static final Color MAGENTA   = new Color(1.0f, 0.0f, 1.0f, 1.0f);
	static final Color YELLOW    = new Color(1.0f, 1.0f, 0.0f, 1.0f);

	// Sprite color palette (VARIABLE)
	static float[] black   = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
	static float[] white   = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
	static float[] red     = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
	static float[] green   = new float[]{0.0f, 1.0f, 0.0f, 1.0f};
	static float[] blue    = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
	static float[] cyan    = new float[]{0.0f, 1.0f, 1.0f, 1.0f};
	static float[] magenta = new float[]{1.0f, 0.0f, 1.0f, 1.0f};
	static float[] yellow  = new float[]{1.0f, 1.0f, 0.0f, 1.0f};

	public PaletteShader() {

		super(
			Gdx.files.internal("shader/palette.vert"),
			Gdx.files.internal("shader/palette.frag")
		);

		bind();

		// Set uniforms for each color
		setUniform4fv("black", black, 0, 4);
		setUniform4fv("white", white, 0, 4);
		setUniform4fv("red", red, 0, 4);
		setUniform4fv("green", green, 0, 4);
		setUniform4fv("blue", blue, 0, 4);
		setUniform4fv("cyan", cyan, 0, 4);
		setUniform4fv("magenta", magenta, 0, 4);
		setUniform4fv("yellow", yellow, 0, 4);
	}

	@Override
	public void dispose() {

		super.dispose();
	}
}
