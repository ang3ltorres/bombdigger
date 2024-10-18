package io.bombdigger;

import com.badlogic.gdx.Gdx;
import java.util.ArrayList;

public class Timer {

	private float duration;
	private float current;
	private Runnable function;
	private int repeat;

	Timer(float duration, Runnable function, int repeat) {
		
		this.duration = duration;
		this.current = duration;
		this.function = function;
		this.repeat = repeat;

		this.repeat = (repeat >= -1) ? repeat : -1;
		timerList.add(this);
	}

	private static ArrayList<Timer> timerList = new ArrayList<Timer>();

	public static void update() {

		for (int i = timerList.size() - 1; i >= 0; i--) {

			Timer timer = timerList.get(i);
			timer.current -= Gdx.graphics.getDeltaTime();

			if (timer.current <= 0.0f) {

				timer.function.run();

				if (timer.repeat > 0 || timer.repeat == -1) {

					timer.current = timer.duration;
					timer.repeat -= (timer.repeat == -1) ? 0 : 1;
				}
				else
					timerList.remove(i);
			}
		}
	}
}
