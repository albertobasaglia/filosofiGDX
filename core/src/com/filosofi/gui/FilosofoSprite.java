package com.filosofi.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FilosofoSprite extends SpriteBatch {
    private Texture img;
    private int x;
    private int y;
    private static int dim;
    private int forkAx;
    private int forkAy;
    private int forkBx;
    private int forkBy;
    public FilosofoSprite(int x, int y){
        img = new Texture("filosofo.png");
        this.x = x;
        this.y = y;
        dim = 100;

        forkAx = x - dim/2;
        forkBx = x + dim/2;
        forkAy = y;
        forkBy = y;
    }
    public FilosofoSprite() {
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

    public int getForkAx() {
        return forkAx;
    }

    public int getForkAy() {
        return forkAy;
    }

    public int getForkBx() {
        return forkBx;
    }

    public int getForkBy() {
        return forkBy;
    }
}
