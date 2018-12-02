package com.filosofi.model;

import com.filosofi.gui.ForchettaSprite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forchetta {
    private Lock lock;
    private int id;
    private ForchettaSprite sprite;

    public Forchetta(int id, ForchettaSprite sprite) {
        this.id = id;
        this.sprite = sprite;
        this.lock = new ReentrantLock();
    }
    public void prendi(int x, int y) {
        this.lock.lock();
        sprite.moveTo(x,y);
    }
    public void lascia() {
        this.lock.unlock();
        sprite.moveTo(sprite.getDefaultX(),sprite.getDefaultY());
    }
}
