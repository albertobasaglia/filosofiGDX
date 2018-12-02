package com.filosofi.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forchetta {
    private Lock lock;
    private int id;
    public Forchetta(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }
    public void prendi(Filosofo filosofo) {
        this.lock.lock();
    }
    public void lascia() {
        this.lock.unlock();
    }
}
