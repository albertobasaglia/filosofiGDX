package com.filosofi.gui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filosofi.model.Filosofo;
import com.filosofi.model.Forchetta;

public class FilosofiGame extends ApplicationAdapter{
	private ForchettaSprite[] forchetteSprite;
	private FilosofoSprite[] filosofiSprite;
	private Filosofo[] filosofi;
	private Forchetta[] forchette;
	private int n;
	private int width;
	private int height;
	private double step;
	private int radius;
	private Texture tavoloTexture;
	private SpriteBatch tavoloSprite;
	@Override
	public void create () {
		this.tavoloTexture = new Texture("tavolo.png");
		this.tavoloSprite = new SpriteBatch();
		this.n = 7;
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
			//angolo += Math.PI/this.n;
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
			filosofi[i] = new Filosofo(forchette[i],forchette[(i+1)%this.n],i,filosofiSprite[i]);
			new Thread(filosofi[i]).start();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.tavoloSprite.begin();
		this.tavoloSprite.draw(this.tavoloTexture,this.width/2 -150,this.height/2 -150,300,300);
		this.tavoloSprite.end();
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
}
