/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.Semaphore;

/**
 *
 * @author thili
 */
public class Resources {

    private Semaphore mutex;
    private Semaphore bus;
    private Semaphore boarded;
    private int waiting;
    
    public Resources() {
        mutex = new Semaphore(1);
        bus = new Semaphore(0);
        boarded = new Semaphore(0);
        waiting = 0;
    }
    
    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @return the bus
     */
    public Semaphore getBus() {
        return bus;
    }

    /**
     * @return the boarded
     */
    public Semaphore getBoarded() {
        return boarded;
    }
    

    /**
     * @return the waiting
     */
    public int getWaiting() {
        return waiting;
    }

    /**
     * @param waiting the waiting to set
     */
    public synchronized void setWaiting(int waiting) {
        this.waiting = waiting;
    }
    
}
