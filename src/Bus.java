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
public class Bus extends Thread{

    // Shared resource object
    private Resources resources;

    // Id to identify threads seperately
    int id;

    // Constructor for Bus thread
    public Bus(Resources resources,int id) {
     this.resources = resources;
     this.id = id;
    }

    // Thread run method overriding according to solution #2 in the book
    @Override
    public void run() {
        try {
            System.out.println("BUS : "+Integer.toString(this.id)+" -> ARRIVED");
            resources.getMutex().acquire();
            int n = Math.min(resources.getWaiting(),50);
            for(int i=0;i<n;i++){
                resources.getBus().release();
                resources.getBoarded().acquire();
            }
            resources.setWaiting(Math.max((resources.getWaiting()-50),0));
            resources.getMutex().release();
            this.depart();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
        }
;
        
    }

    // Bus depart method
    void depart(){
        System.out.println("BUS : "+Integer.toString(this.id)+" -> DEPARTED");
    }
    
}
