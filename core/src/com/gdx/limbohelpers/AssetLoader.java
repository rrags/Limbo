package com.gdx.limbohelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture texture, back, ground;
	public static TextureRegion bg, floor;
	
	public static Animation walking;
	public static Sprite walk1, walk2, walk3, walk4, walk5, walk6;
	public static Sprite jump, fall;
	
	public static void load() {
		texture = new Texture(Gdx.files.internal("data/gundams2.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		back = new Texture(Gdx.files.internal("data/bg1.png"));
		back.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		ground = new Texture(Gdx.files.internal("data/floor.png"));
		ground.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bg = new TextureRegion(back, 0, 0, 320, 240);
		bg.flip(false, true);
		
		floor = new TextureRegion(ground, 0, 0, 320, 62);
		floor.flip(false, true);
		
		walk1 = new Sprite(new TextureRegion(texture, 198, 374, 60, 70));
		walk1.flip(false, true);
		
		walk2 = new Sprite(new TextureRegion(texture, 268, 374, 60, 70));
		walk2.flip(false, true);
		
		walk3 = new Sprite(new TextureRegion(texture, 334, 374, 60, 70));
		walk3.flip(false, true);
		
		walk4 = new Sprite(new TextureRegion(texture, 394, 374, 60, 70));
		walk4.flip(false, true);
		
		walk5 = new Sprite(new TextureRegion(texture, 458, 374, 60, 70));
		walk5.flip(false, true);
		
		walk6 = new Sprite(new TextureRegion(texture, 524, 374, 60, 70));
		walk6.flip(false, true);
		
		jump = new Sprite(new TextureRegion(texture, 20, 505, 60, 90));
		jump.flip(false, true);
		
		fall = new Sprite(new TextureRegion(texture, 90, 505, 60, 90));
		fall.flip(false, true);
		
		Sprite[] walks = {walk1, walk2, walk3, walk4, walk5, walk6};
		walking = new Animation(0.2f, walks);
		walking.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}
	
	public static void dispose() {
		texture.dispose();
	}
}