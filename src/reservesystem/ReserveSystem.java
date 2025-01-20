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
    private static Reserve[] reserves = new Reserve[1000];
    int currentReserve = 0;

    public void loadReserves() throws IOException {
        int count = 0;
        currentReserve = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            while ((br.readLine()) != null) {
                count++;
            }
        }

        //reserves = new Reserve[count];
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
                reserves[currentReserve] = reserve;
                currentReserve++;
            }
        }
    }

    public void makeReserve() throws IOException {
        String date;
        String user;
        String userID;
        String startTime;
        String endTime;

        System.out.print("Ingrese la fecha de la reserva: ");
        date = sc.next();
        System.out.print("Ingrese el nombre de usuario: ");
        user = sc.next();
        System.out.print("Ingrese el id: ");
        userID = sc.next();
        System.out.print("Ingrese la hora de inicio: ");
        startTime = sc.next();
        System.out.print("Ingrese la hora de fin: ");
        endTime = sc.next();

        Reserve reserve = new Reserve(date, user, userID, startTime, endTime);
        reserves[currentReserve] = reserve;
        currentReserve++;

    }

    public void showReserves() {

        //System.out.println(currentReserve);
        for (int i = 0; i < currentReserve; i++) {

            System.out.print(reserves[i].getDate() + " | ");
            System.out.print(reserves[i].getUser() + " | ");
            System.out.print(reserves[i].getId() + " | ");
            System.out.println("De " + reserves[i].getStartTime() + " a " + reserves[i].getEndTime());

        }
    }

    public void saveReserves() throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {

            for (int i = 0; i < currentReserve; i++) {
                bw.write(reserves[i].getDate() + ",");
                bw.write(reserves[i].getUser() + ",");
                bw.write(reserves[i].getId() + ",");
                bw.write(reserves[i].getStartTime() + ",");
                bw.write(reserves[i].getEndTime());
                bw.newLine();
            }
        }
    }
}
