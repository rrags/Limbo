package com.gdx.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Guy {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private int width;
	private int height;
	
	public Guy(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 100);
		acceleration = new Vector2(0, 100);
	}
	
	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		
		if (velocity.y > 100) {
			velocity.y = 100;
		}
		
		position.add(velocity.cpy().scl(delta));
		
		if(Gdx.input.isTouched() && !isJumping() && !isFalling()) {
			velocity.y = -100;
			
		}
		
		if (position.y > 80) {
			position.y = 80;
		}
	}
	
	public void onClick() {
		//velocity.y = -140;
	}
	
	public boolean isJumping() {
		return velocity.y < 0;
	}
	
	public boolean isFalling() {
		return velocity.y < 100 && velocity.y > 0;
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
}
