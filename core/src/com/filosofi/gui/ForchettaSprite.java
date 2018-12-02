package com.filosofi.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ForchettaSprite extends SpriteBatch {
    private final int defaultY;
    private final int defaultX;
    private Texture img;
    private int x;
    private int y;
    private static int dim;

    private boolean moving;
    private double moveX;
    private double moveY;
    private int moveCount;
    private double moveXtot;
    private double moveYtot;
    public ForchettaSprite(int x, int y){
        img = new Texture("forchetta.jpg");
        this.x = x;
        this.y = y;
        this.defaultX = x;
        this.defaultY = y;
        dim = 100;
        moving = false;
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

    public void moveTo(int x,int y) {
        moving = true;
        int relX = x-this.x;
        int relY = y-this.y;
        double mod = Math.sqrt(Math.pow(relX,2)+Math.pow(relY,2));
        double ang = Math.atan2(relY,relX);
        double modStep = mod/60;
        moveX = modStep * Math.cos(ang);
        moveY = modStep * Math.sin(ang);
        moveCount = 60;
        this.moveXtot = this.x;
        this.moveYtot = this.y;
    }

    public void step(){
        if(--moveCount==0) moving = false;
        this.moveXtot += this.moveX;
        this.moveYtot += this.moveY;
        this.x = (int) this.moveXtot;
        this.y = (int) this.moveYtot;
    }

    public int getDefaultY() {
        return defaultY;
    }

    public int getDefaultX() {
        return defaultX;
    }

    public boolean isMoving() {
        return moving;
    }

    public double getMoveX() {
        return moveX;
    }

    public double getMoveY() {
        return moveY;
    }

    public double getMoveXtot() {
        return moveXtot;
    }

    public double getMoveYtot() {
        return moveYtot;
    }

    public void setMoveXtot(double moveXtot) {
        this.moveXtot = moveXtot;
    }

    public void setMoveYtot(double moveYtot) {
        this.moveYtot = moveYtot;
    }
}
