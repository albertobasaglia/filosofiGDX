package com.filosofi.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ForchettaSprite extends SpriteBatch {
    private final int defaultY;
    private final int defaultX;
    private Texture img;
    private int x;
    private int y;
    private static int dim;
    public ForchettaSprite(int x, int y){
        img = new Texture("forchetta.jpg");
        this.x = x;
        this.y = y;
        this.defaultX = x;
        this.defaultY = y;
        dim = 100;
    }
    public ForchettaSprite() {
        this(0,0);
    }
    public void draw() {
        super.begin();
        super.draw(img,x-dim/2,y-dim/2,dim,dim);
        super.end();
    }
    public static int getDim() {
        return dim;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDefaultY() {
        return defaultY;
    }

    public int getDefaultX() {
        return defaultX;
    }
}
