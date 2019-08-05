/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thili
 */
public class CP_LAB_03 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        try {

            // Resource object creation
            Resources resources = new Resources();

            // BusGenerator thread object creation
            BusGenerator busGen = new BusGenerator(resources);

            // RiderGenerator thread object creation
            RiderGenerator riderGen = new RiderGenerator(resources);

            // Start the BusGenerator thread
            busGen.start();

            // Start the RiderGenerator thread
            riderGen.start();

            // Join started threads to the main thread
            busGen.join();
            riderGen.join();

        } catch (InterruptedException ex) {
            
        }
        
    }
    
}
