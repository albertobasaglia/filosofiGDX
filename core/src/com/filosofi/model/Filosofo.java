package com.filosofi.model;

import com.filosofi.gui.FilosofoSprite;

import java.util.Random;

public class Filosofo implements Runnable{
    private Forchetta sx;
    private Forchetta dx;
    private int id;
    private FilosofoSprite sprite;

    public Filosofo(Forchetta sx, Forchetta dx, int id, FilosofoSprite sprite) {
        this.sx = sx;
        this.dx = dx;
        this.id = id;
        this.sprite = sprite;
        this.sprite.setColor(sprite.getColor().r,sprite.getColor().g,sprite.getColor().b,0.5f);
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (this.id == 0) {
                    this.dx.prendi(sprite.getForkAx(), sprite.getForkAy());
                    Thread.sleep(1000);
                    this.sx.prendi(sprite.getForkBx(), sprite.getForkBy());
                } else {
                    this.sx.prendi(sprite.getForkBx(), sprite.getForkBy());
                    Thread.sleep(1000);
                    this.dx.prendi(sprite.getForkAx(), sprite.getForkAy());
                }
                Random r = new Random();
                int sleep = r.nextInt(5) + 1; // da 1 a 5

                sprite.setColor(sprite.getColor().r,sprite.getColor().g,sprite.getColor().b,1f);

                Thread.sleep(sleep * 1000);

                sprite.setColor(sprite.getColor().r,sprite.getColor().g,sprite.getColor().b,0.5f);

                this.sx.lascia();
                Thread.sleep(1000);
                this.dx.lascia();
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public int getId() {
        return this.id;
    }
}
