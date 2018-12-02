package com.filosofi.gui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.filosofi.model.Filosofo;
import com.filosofi.model.Forchetta;

public class FilosofiGame extends ApplicationAdapter implements InputProcessor {
	private ForchettaSprite[] forchetteSprite;
	private FilosofoSprite[] filosofiSprite;
	private Filosofo[] filosofi;
	private Forchetta[] forchette;
	private int n;
	private int width;
	private int height;
	private double step;
	private int radius;
	@Override
	public void create () {
		Gdx.input.setInputProcessor(this);
		this.n = 5;
		this.width = Gdx.graphics.getWidth();
		this.height = Gdx.graphics.getHeight();
		this.step = Math.PI*2 / (double)this.n;
		this.radius = 300;
		forchetteSprite = new ForchettaSprite[this.n];
		filosofiSprite = new FilosofoSprite[this.n];
		for(int i=0 ; i<this.n ; i++) {
			double angolo = this.step * (double)i + Math.PI/2;
			int y = (int) (Math.sin(angolo)*this.radius + height/2) ;
			int x = (int) (Math.cos(angolo)*this.radius + width/2) ;
			filosofiSprite[i] = new FilosofoSprite(x,y);
			angolo += Math.PI/this.n;
			y = (int) (Math.sin(angolo)*this.radius/3 + height/2) ;
			x = (int) (Math.cos(angolo)*this.radius/3 + width/2) ;
			forchetteSprite[i] = new ForchettaSprite(x,y);
		}
		forchette = new Forchetta[this.n];
		filosofi = new Filosofo[this.n];
		for(int i=0 ; i<this.n ; i++) {
			forchette[i] = new Forchetta(i,forchetteSprite[i]);
		}
		for(int i=0 ; i<this.n ; i++) {
			filosofi[i] = new Filosofo(forchette[i],forchette[(i+1)%5],i,filosofiSprite[i]);
			new Thread(filosofi[i]).start();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		for(FilosofoSprite s: filosofiSprite) {
			s.draw();
		}
		for(ForchettaSprite s: forchetteSprite) {
			if(s.isMoving()) {
				s.step();
			}
			s.draw();
		}

	}
	
	@Override
	public void dispose () {}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
