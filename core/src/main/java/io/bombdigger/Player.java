package io.bombdigger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Player implements Entity {

	public static Texture txr_test = new Texture(Gdx.files.internal("txr_test.png"));

	public float posX;
	public float posY;

	public Player() {

		this.posX = 0.0f;
		this.posY = 0.0f;
	}

	@Override
	public void dispose() {

		txr_test.dispose();
	}

	@Override
	public void update() {

		if (Input.right[2]) {

			posX += 1.0f;
		}
	}

	@Override
	public void draw(Batch batch) {

		batch.draw(txr_test, posX, posY);
	}
	
}
