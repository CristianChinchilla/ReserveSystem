/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cchin
 */
public class ReserveSystem {

    Scanner sc = new Scanner(System.in);
    File file = new File("Reserves.txt");

    public void loadReserves() throws IOException {
        int count = 0;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            while ((br.readLine()) != null) {
                count++;
            }
        }
        
        Reserve[] reserves = new Reserve[count];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
        
            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                Reserve reserve = new Reserve(
                        data[0].toUpperCase().trim(),
                        data[1].toUpperCase().trim(),
                        data[2].toUpperCase().trim(),
                        data[3].toUpperCase().trim(),
                        data[4].toUpperCase().trim());
                reserves[i] = reserve;
                i++;
            }
        }
        
        System.out.println(reserves[1].getDate());
    }

    public void makeReserve() throws IOException {
        String data;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath(), true))) {

            System.out.print("Ingrese la fecha de la reserva: ");
            data = sc.next();
            bw.write(data + ",");
            System.out.print("Ingrese el nombre de usuario: ");
            data = sc.next();
            bw.write(data + ",");
            System.out.print("Ingrese el id: ");
            data = sc.next();
            bw.write(data + ",");
            System.out.print("Ingrese la hora de inicio: ");
            data = sc.next();
            bw.write(data + ",");
            System.out.print("Ingrese la hora de fin: ");
            data = sc.next();
            bw.write(data);
            bw.newLine();

        }
    }
}
