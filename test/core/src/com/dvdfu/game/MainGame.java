package com.dvdfu.game;

import java.util.Stack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.dvdfu.game.screens.AbstractScreen;
import com.dvdfu.game.screens.TestScreen;

public class MainGame extends Game {
	private Stack<AbstractScreen> screens;

	public void create() {
		screens = new Stack<AbstractScreen>();
		enterScreen(new TestScreen(this));
	}

	public void enterScreen(AbstractScreen screen) {
		if (!screens.isEmpty()) {
			screens.peek().pause();
		}
		screens.push(screen);
		setScreen(screens.peek());
	}

	public void changeScreen(AbstractScreen screen) {
		if (screens.isEmpty()) {
			return;
		}
		screens.pop();
		screens.push(screen);
		setScreen(screens.peek());
	}

	public void exitScreen() {
		if (screens.isEmpty()) {
			Gdx.app.exit();
		}
		screens.pop();
		screens.peek().resume();
		setScreen(screens.peek());
	}

	public void dispose() {
	}

	public void render() {
		if (getScreen() != null) {
			super.render();
		}
	}

	public void resize(int width, int height) {
		super.resize(width, height);
	}

	public void pause() {
	}

	public void resume() {
	}
}