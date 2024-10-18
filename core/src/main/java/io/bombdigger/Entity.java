package io.bombdigger;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public interface Entity extends Disposable {

	public void update();
	public void draw(Batch batch);
}
