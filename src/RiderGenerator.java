/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author thili
 */
public class RiderGenerator extends Thread{

    // Random object for generate random float value for the exponential time calculation
    Random random;

    // Arrival time mean (30 secs)
    double arrivalIntervel;

    // Shared resources holder for threads
    Resources resourses;

    // Constructor for RiderGenerator Thread
    public RiderGenerator(Resources resourses) {
        this.random = new Random();
        this.arrivalIntervel = 30*1000;
        this.resourses = resourses;
    }

    
    // RiderGenerator thread run method for create Rider thread with exponentially distributed time intervals
    @Override
    public void run() {
        int riderId=1;
        while (true) {
            try {
                new Rider(this.resourses,riderId).start();
                riderId++;
                Thread.sleep(getExponentiallyDistributedBusInterArrivalTime());
            } catch (InterruptedException ex) {
            }
        }
    }

    // Exponentially distributed time interval generator with statistical approach
    public long getExponentiallyDistributedBusInterArrivalTime() {
        double lambda = 1 / this.arrivalIntervel;
        return Math.round(-Math.log(1 - this.random.nextFloat()) / lambda);
    }
    
}
