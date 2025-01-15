/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservesystem;

import java.io.IOException;
import java.util.Scanner;

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

        selectionMenu(reservesystem);

        //reservesystem.makeReserve();
    }

    private static void selectionMenu(ReserveSystem reservesystem) throws IOException {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.println("""
                           Escoja que opción desea realizar:
                           
                           1. Ingresar una reserva
                           2. Ver una reserva
                           3. Mostrar reservas
                           6. Salir
                           """);
        option = sc.next();

        switch (option) {
            case "1" -> {
                reservesystem.makeReserve();
                selectionMenu(reservesystem);
            }

            case "2" -> {
                System.out.println("Función pendiente.");
                selectionMenu(reservesystem);
            }
            
            case "3" -> {
                reservesystem.showReserves();
                selectionMenu(reservesystem);
            }
            
            case "6" -> {
                System.exit(0);
            }

            default -> {
                System.out.println("Opcion no valida.");
                selectionMenu(reservesystem);

            }

        }
    }

}
