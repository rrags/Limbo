package com.gdx.GameObjects;

import com.badlogic.gdx.Gdx;

public class ScrollHandler {

    private Floor frontFloor, backFloor;
    public static final int SCROLL_SPEED = -20;

    public ScrollHandler(float yPos) {
        frontFloor = new Floor(0, yPos, 204, 40, SCROLL_SPEED);
        backFloor = new Floor(frontFloor.getTailX(), yPos, 204, 40,
                SCROLL_SPEED);
    }

    public void update(float delta) {
        // Update our objects
        frontFloor.update(delta);
        backFloor.update(delta);

        if (frontFloor.isScrolledLeft()) {
            frontFloor.reset(backFloor.getTailX());

        } else if (backFloor.isScrolledLeft()) {
            backFloor.reset(frontFloor.getTailX());
        }
    }

    public Floor getFrontFloor() {
        return frontFloor;
    }

    public Floor getBackFloor() {
        return backFloor;
    }
}