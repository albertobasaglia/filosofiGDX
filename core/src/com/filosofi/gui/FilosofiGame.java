package com.filosofi.gui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filosofi.model.Filosofo;
import com.filosofi.model.Forchetta;

public class FilosofiGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Forchetta[] forchette;
	private Filosofo[] filosofi;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("forchetta.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0,50,50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
