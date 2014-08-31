package com.gdx.limbo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gdx.limbohelpers.AssetLoader;
import com.gdx.screens.GameScreen;

public class LimboGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("LimboGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}