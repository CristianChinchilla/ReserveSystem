/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservesystem;

import java.io.IOException;

/**
 *
 * @author cchin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ReserveSystem reservesystem = new ReserveSystem();
        
        reservesystem.loadReserves();
        //reservesystem.makeReserve();
        
    }
    
}
