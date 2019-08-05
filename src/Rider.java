/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author thili
 */
public class Rider extends Thread{

    // Shared resource object
    private Resources resources;

    // Id to identify threads seperately
    private int id;

    // Constructor for Bus thread
    public Rider(Resources resources,int id) {
        this.resources = resources;
        this.id = id;
    }

    // Thread run method overriding according to solution #2 in the book
    @Override
    public void run() {
        System.out.println("RIDER : "+Integer.toString(this.id)+" -> WAITING");
        try {
            this.resources.getMutex().acquire();
            this.resources.setWaiting(this.resources.getWaiting()+1);
            this.resources.getMutex().release();
            
            this.resources.getBus().acquire();
            boarded();
            this.resources.getBoarded().release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Rider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Rider boarded method
    void boarded(){
        System.out.println("RIDER : "+Integer.toString(this.id)+" -> BOARDED");
    }
    
}
