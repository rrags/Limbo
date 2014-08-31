package com.gdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.gdx.GameObjects.Floor;
import com.gdx.GameObjects.Guy;
import com.gdx.GameObjects.ScrollHandler;

public class GameWorld {
	private Guy guy;
	private ScrollHandler scroller;
	
	public GameWorld(int midpointY) {
		guy = new Guy(33, 2* midpointY - 45, 30, 45);
		scroller = new ScrollHandler(2*midpointY - 36);
	}
	
	public void update(float delta) {
		guy.update(delta);
		scroller.update(delta);
	}
	
	public Guy getGuy() {
		return guy;
	}
	
	public ScrollHandler getScroller() {
		return scroller;
	}
}
