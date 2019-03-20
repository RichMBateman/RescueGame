package com.bateman.rich.rescue;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class RescueGame extends ApplicationAdapter {
	private final int VIEWPORT_WIDTH = 800;
	private final int VIEWPORT_HEIGHT = 600;

	private OrthographicCamera m_camera;
	private ShapeRenderer m_shapeRenderer;
	private FitViewport m_fitViewport;
	private Rectangle m_screenSpace = new Rectangle();


	@Override
	public void create() {
		m_shapeRenderer = new ShapeRenderer();

		// create the m_camera and the SpriteBatch
		m_camera = new OrthographicCamera();

		m_fitViewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, m_camera);
		m_fitViewport.apply(true);
		//m_camera.position.set(m_camera.viewportWidth/2, m_camera.viewportHeight/2, 0);
	}

	@Override
	public void render() {
		// clear the screen to black.
		// The arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// tell the m_camera to update its matrices.
		m_camera.update();

		// For educational purposes, fill in a dark blue area to represent the part of the screen that is drawable.
		// that is, not covered by black bars to maintain the aspect ratio.
		// The size of this space equals the View Port width and height.
		// We must set the projection matrix on the camera so this is appropriately mapped to screen space.
		m_shapeRenderer.setProjectionMatrix(m_camera.combined);
		m_shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		// If it helps, change g to 0.8f, so the aspect rectangle contrasts brightly with the black background.
		m_shapeRenderer.setColor(0, 0.0f, 0.3f, 1);
		// To PROVE that is the correct sized space... just subtract one from the width and the height, and you'll
		// see a small gap on the top and right of the green rectangle.
		// Also... if you specify LARGER values... everything will appear to be fine, because of the black aspect ratio bars.
		m_shapeRenderer.rect(0, 0, m_fitViewport.getWorldWidth(), m_fitViewport.getWorldHeight());
		m_shapeRenderer.end();

		// Draw a red rectangle to represent the entire mission map.
		// We're going to show it in a 200 by 200 square in the center of the 800w by 600h rectangle
		m_shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		m_shapeRenderer.setColor(1, 0, 0, 1);
		// The x and y refer to lower left coordinate of rectangle.
		// And all these numbers refer to logical coordinates and sizes.
		// In the game world, the most lower left coordinate is 0,0
		m_shapeRenderer.rect(300, 200, 200, 200);
		m_shapeRenderer.end();

//
//		// process user input
//		if(Gdx.input.isTouched()) {
//			// Get the coordinates of where we clicked.  These will be SCREEN coordinates.
//			Vector3 touchPos = new Vector3();
//			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			// By calling unproject, we can map those screen coordinates to GAME WORLD coordinates.
//			// So for example, say the user clicked on the lower left of the screen.  That might be coordinates (2, 475).
//			// On calling unproject, the vector will be mapped to say (2,2).
//			m_camera.unproject(touchPos);
//			bucket.x = touchPos.x - 64 / 2;
//		}
//		if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//		if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
//
//		// make sure the bucket stays within the screen bounds
//		if(bucket.x < 0) bucket.x = 0;
//		if(bucket.x > 800 - 64) bucket.x = 800 - 64;
//
//		// check if we need to create a new raindrop
//		// 1000000000 == 1 second!
//		if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
//
//		// move the raindrops, remove any that are beneath the bottom edge of
//		// the screen or that hit the bucket. In the latter case we play back
//		// a sound effect as well.
//		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext(); ) {
//			Rectangle raindrop = iter.next();
//			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//			if(raindrop.y + 64 < 0) iter.remove();
//			if(raindrop.overlaps(bucket)) {
//				dropSound.play();
//				iter.remove();
//			}
//		}
	}

	@Override
	public void resize(int width, int height) {
		m_fitViewport.update(width, height);
		//m_fitViewport.apply(true);
	//	m_camera.position.set(m_camera.viewportWidth/2, m_camera.viewportHeight/2, 0);
	}


	@Override
	public void dispose() {
		// dispose of all the native resources
		m_shapeRenderer.dispose();
	}
}
