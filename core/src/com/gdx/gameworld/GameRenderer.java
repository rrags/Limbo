package com.gdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.gdx.GameObjects.Floor;
import com.gdx.GameObjects.Guy;
import com.gdx.GameObjects.ScrollHandler;
import com.gdx.limbohelpers.AssetLoader;

public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batcher;
	
	private int midPointY;
	private int gameHeight;
	
	private Guy guy;
	private ScrollHandler scroller;
	private Floor frontFloor, backFloor;
	
	private TextureRegion bg, floor;
	private Sprite walk1, walk2, walk3, walk4, walk5, walk6;
	private Sprite jump, fall;
	private Animation walking;
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		myWorld = world;
		
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 204, gameHeight);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	
		initGameObjects();
		initAssets();
	}
	
	public void drawFloor() {
		batcher.draw(floor, frontFloor.getX(), frontFloor.getY(), frontFloor.getWidth(), frontFloor.getHeight());
		batcher.draw(floor, backFloor.getX(), backFloor.getY(), backFloor.getWidth(), backFloor.getHeight());
	}
	
	public void render(float runTime) {
			
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		// Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 204, midPointY + 68);
        
        shapeRenderer.end();
        
        batcher.begin();
        
        batcher.draw(bg, 0, 0, 204, gameHeight);
     
        drawFloor();
        
        batcher.enableBlending();
        
        if (!guy.isFalling() && !guy.isJumping()) {
        	batcher.draw(walking.getKeyFrame(runTime),
            		guy.getX(), guy.getY(), guy.getWidth(), guy.getHeight());	
        }
        
        else if (guy.isJumping()) {
        	batcher.draw(jump, guy.getX(), guy.getY(), guy.getWidth(), guy.getHeight());
        }
        
        else if (guy.isFalling()) {
        	batcher.draw(fall, guy.getX(), guy.getY(), guy.getWidth(), guy.getHeight());
        }
        
        batcher.end();
	}
	
	private void initGameObjects() {
		guy = myWorld.getGuy();
		scroller = myWorld.getScroller();
		Gdx.app.log("GameRenderer", "scroller made");
		frontFloor = scroller.getFrontFloor();
		backFloor = scroller.getBackFloor();
	}
	
	private void initAssets() {
		bg = AssetLoader.bg;
		floor = AssetLoader.floor;
		walking = AssetLoader.walking;
		walk1 = AssetLoader.walk1;
		walk2 = AssetLoader.walk2;
		walk3 = AssetLoader.walk3;
		walk4 = AssetLoader.walk4;
		walk5 = AssetLoader.walk5;
		walk6 = AssetLoader.walk6;
		jump = AssetLoader.jump;
		fall = AssetLoader.fall;
	}
}
