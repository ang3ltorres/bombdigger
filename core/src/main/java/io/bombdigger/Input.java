package io.bombdigger;

import com.badlogic.gdx.InputAdapter;
import static com.badlogic.gdx.Input.Keys.*;

public class Input extends InputAdapter {

	public static boolean[] up = new boolean[3];
	public static boolean[] down = new boolean[3];
	public static boolean[] left = new boolean[3];
	public static boolean[] right = new boolean[3];
	
	@Override
	public boolean keyDown(int keycode) {

		switch (keycode) {

			case W: case UP:    up[0]    = true; up[1]    = true; break;
			case A: case LEFT:  left[0]  = true; left[1]  = true; break;
			case S: case DOWN:  down[0]  = true; down[1]  = true; break;
			case D: case RIGHT: right[0] = true; right[1] = true; break;
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {

		switch (keycode) {

			case W: case UP:    up[0]    = false; up[2]    = true; break;
			case A: case LEFT:  left[0]  = false; left[2]  = true; break;
			case S: case DOWN:  down[0]  = false; down[2]  = true; break;
			case D: case RIGHT: right[0] = false; right[2] = true; break;
		}

		return true;
	}

	public static void reset() {

		up[1]    = false;
		down[1]  = false;
		left[1]  = false;
		right[1] = false;

		up[2]    = false;
		down[2]  = false;
		left[2]  = false;
		right[2] = false;
	}
}
