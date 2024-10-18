package io.bombdigger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

	static public float u_time;
	static public Input input;
	static public SpriteBatch spriteBatch;
	static public ShapeRenderer shapeRenderer;

	static public BitmapFont font;
	static public OrthographicCamera camera;
	static public OrthographicCamera cameraInternal;

	// Render target
	static public FrameBuffer frameBuffer;
	static public Texture frameBufferTexture;
	static public int frameWidth = 240*2;
	static public int frameHeight = 135*2;
	static public int scale = 1;
	static public float offset_x = 0.0f;
	static public float offset_y = 0.0f;

	static public PaletteShader paletteShader;
	static public SpriteAnimated spriteAnimated;
	static public Texture texture;
	static public Player player;

	@Override
	public void create() {

		//#region Debug
		paletteShader = new PaletteShader();
		texture = new Texture(Gdx.files.internal("spr_kirby.png"));
		spriteAnimated = new SpriteAnimated(texture, new Rectangle(0, 0, 43, 47), new Rectangle(0, 0, 43, 47), 5, 0.17f);
		player = new Player();
		//#endregion

		//#region Misc
		input = new Input(); Gdx.input.setInputProcessor(input);
		shapeRenderer = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		//#endregion

		//#region Render target
		frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, frameWidth, frameHeight, false);
		frameBufferTexture = frameBuffer.getColorBufferTexture();
		frameBufferTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
		int scale_x = Gdx.graphics.getWidth() / frameWidth;
		int scale_y = Gdx.graphics.getHeight() / frameHeight;
		scale = scale_x < scale_y ? scale_x : scale_y;
		offset_x = (Gdx.graphics.getWidth() - frameWidth * scale) / 2;
		offset_y = (Gdx.graphics.getHeight() - frameHeight * scale) / 2;
		//#endregion

		//#region Camera
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		cameraInternal = new OrthographicCamera(frameWidth, frameHeight);
		cameraInternal.setToOrtho(true, frameWidth, frameHeight);
		//#endregion

		//#region Font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("tiny5.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 8;
		parameter.color = PaletteShader.BLACK;
		parameter.flip = true;
		font = generator.generateFont(parameter);
		generator.dispose();
		//#endregion
	}

	@Override
	public void render() {

		// Update game logic
		update();
		
		// Draw inside frame buffer
		frameBuffer.begin();
		ScreenUtils.clear(0.25f, 0.25f, 0.25f, 1.0f);
		draw();
		frameBuffer.end();
		
		// Draw framebuffer
		ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1.0f);
		spriteBatch.begin();
		spriteBatch.setProjectionMatrix(Main.camera.combined);
			spriteBatch.draw(frameBufferTexture, offset_x, offset_y, frameWidth * scale, frameHeight * scale);
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		
		font.dispose();
		frameBufferTexture.dispose();
		frameBuffer.dispose();
		spriteBatch.dispose();	
		shapeRenderer.dispose();
	}

	public void update() {

		Timer.update();
		u_time += Gdx.graphics.getDeltaTime();
		camera.update();
		cameraInternal.update();
		player.update();
		Input.reset();
	}

	public void draw() {

		spriteBatch.setProjectionMatrix(Main.cameraInternal.combined);
		spriteBatch.begin();
		//spriteBatch.setShader(paletteShader);
		font.draw(spriteBatch, String.format("FPS: %d", Gdx.graphics.getFramesPerSecond()), 16.0f, 16.0f);
		//spriteAnimated.draw(spriteBatch)
		player.draw(spriteBatch);;
		//spriteBatch.setShader(null);
		spriteBatch.end();
	}
}