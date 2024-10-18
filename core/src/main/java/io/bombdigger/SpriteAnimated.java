package io.bombdigger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class SpriteAnimated {

		public Texture texture;
		public TextureRegion region;
		Rectangle src;
		Rectangle dst;

		int currentFrame;
		int totalFrames;
		float speed;
		float time;

		public SpriteAnimated(Texture texture, Rectangle src, Rectangle dst, int totalFrames, float speed) {
			
				this.texture = texture;
				this.dst = dst;
				this.src = src;

				region = new TextureRegion(texture, (int)src.x, (int)src.y, (int)src.width, (int)src.height);
				region.flip(false, true);

				this.currentFrame = 0;
				this.totalFrames = totalFrames;
				this.speed = speed;
				this.time = 0.0f;
		}

		public void draw(Batch batch) {

			if (time >= speed) {
				
				currentFrame = (currentFrame < totalFrames-1) ? currentFrame+1 : 0;
				region.setRegion((int)(src.x + (src.width * currentFrame)), (int)src.y, (int)src.width, (int)src.height);
				region.flip(false, true);
				time = 0.0f;
			}
			
			time += Gdx.graphics.getDeltaTime();
			batch.draw(region, dst.x, dst.y, dst.width, dst.height);
		}
}
