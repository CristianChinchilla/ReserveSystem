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
        SportSpaceAdministrator sportSpaceAdmin = new SportSpaceAdministrator();
        ReserveSystem reservesystem = new ReserveSystem();
        sportSpaceAdmin.loadSportSpaces();
        reservesystem.loadReserves();

        selectionMenu(reservesystem, sportSpaceAdmin);

        //reservesystem.makeReserve();
    }
    
    private static void selectionMenu(ReserveSystem reservesystem, SportSpaceAdministrator sportSpaceAdmin) throws IOException {
        Scanner sc = new Scanner(System.in);
        String option;
        
        System.out.print("""
                         --------------------------
                         Ingrese el tipo de usurio:
                         
                         1. Usurario normal
                         2. Administrador
                         --------------------------
                         """);
        option = sc.next();
        
        switch (option) {
            
            case "1" -> {
                userMenu(reservesystem);
            }
            
            case "2" -> {
                adminMenu(sportSpaceAdmin);
            }

            default -> {
                System.out.println("Opcion no valida.");
                selectionMenu(reservesystem, sportSpaceAdmin);
            }
        }
    }

    private static void userMenu(ReserveSystem reservesystem) throws IOException {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.print("""
                           ---------------------------------
                           Escoja que opción desea realizar:
                           
                           1. Ingresar una reserva
                           2. Ver una reserva
                           3. Mostrar reservas
                         
                           6. Guardar y salir
                           ---------------------------------
                           """);
        option = sc.next();

        switch (option) {
            case "1" -> {
                reservesystem.makeReserve();
                userMenu(reservesystem);
            }

            case "2" -> {
                System.out.println("Función pendiente.");
                userMenu(reservesystem);
            }

            case "3" -> {
                reservesystem.showReserves();
                userMenu(reservesystem);
            }

            case "6" -> {
                reservesystem.saveReserves();
                System.exit(0);
            }

            default -> {
                System.out.println("Opcion no valida.");
                userMenu(reservesystem);

            }

        }
    }

    private static void adminMenu(SportSpaceAdministrator sportSpaceAdmin) {
        Scanner sc = new Scanner(System.in);
        String option;
        
        System.out.print("""
                         --------------------------------------
                         Escoja que opcion desea realizar:
                         
                         1. Ingresar un nuevo espacio deportivo
                         2. Ver un espacio deportivo
                         3. Ver espacios deportivos
                         
                         6. Guardar y Salir
                         --------------------------------------
                         """);
        option = sc.next();
        
        switch (option) {
        
            case "1" -> {
                sportSpaceAdmin.makeSportSpace();
                adminMenu(sportSpaceAdmin);
            }
            
            case "2" -> {
                System.out.println("Funcion pendiente");
            }
            
            case "3" -> {
                System.out.println("Funcion pendiente");
            }
            
            case "6" -> {
                System.exit(0);
            }
        }
        
    }

}
