package com.filosofi.model;

import java.util.Random;

public class Filosofo implements Runnable{
    private Forchetta sx;
    private Forchetta dx;
    private int id;
    public Filosofo(Forchetta sx, Forchetta dx,int id) {
        this.sx = sx;
        this.dx = dx;
        this.id = id;
    }
    @Override
    public void run() {
        while(true) {
            if(this.id == 0) {
                this.dx.prendi(this);
                this.sx.prendi(this);
            } else {
                this.sx.prendi(this);
                this.dx.prendi(this);
            }
            Random r = new Random();
            int sleep = r.nextInt(5) + 1; // da 1 a 5
            System.out.printf("[%d] sta mangiando per %d secondi\n",id,sleep);
            try {
                Thread.sleep(sleep*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sx.lascia();
            this.dx.lascia();
            System.out.printf("[%d] ha finito di mangiare\n",id);
        }
    }
    public int getId() {
        return this.id;
    }
}
