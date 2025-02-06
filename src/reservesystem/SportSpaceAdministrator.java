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
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author cchin
 */
public class SportSpaceAdministrator {

    Scanner sc = new Scanner(System.in);
    File sportSpacesFile = new File("SportSpaces.txt");
    SportSpace[] sportSpaces = new SportSpace[1000];
    int currentSpace = 0;

    public void loadSportSpaces() throws IOException {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(sportSpacesFile.getPath()))) {
            while ((br.readLine()) != null) {
                count++;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(sportSpacesFile.getPath()))) {

            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                SportSpace sportSpace;
                sportSpace = new SportSpace(
                        data[0].toUpperCase().trim(),
                        data[1].toUpperCase().trim(),
                        data[2].toUpperCase().trim(),
                        data[3].toUpperCase().trim());
                sportSpaces[currentSpace] = sportSpace;
                currentSpace++;
            }

        }
    }

    public void makeSportSpace() {

        String name;
        String id;
        String type;
        String capacity;

        System.out.print("Ingrese el nombre del espacio deportivo: ");
        name = sc.nextLine().replace(" ", "_");
        System.out.print("Ingrese el ID del espacio deportivo: ");
        id = sc.nextLine();
        System.out.print("Ingrese el tipo de espacio deportivo: ");
        type = sc.nextLine();
        System.out.print("Ingrese la capacidad del espacio deportivo: ");
        capacity = sc.nextLine();

        SportSpace sportSpace = new SportSpace(name, id, type, capacity);
        sportSpaces[currentSpace] = sportSpace;
        currentSpace++;

    }

    public void showSportSpaces() {
        for (int i = 0; i < currentSpace; i++) {
            System.out.print(sportSpaces[i].getName().replace("_", " ") + " | ");
            System.out.print(sportSpaces[i].getId() + " | ");
            System.out.print(sportSpaces[i].getType().replace("_", " ") + " | ");
            System.out.println(sportSpaces[i].getCapacity() + " | ");
        }
    }

    public void saveSportSpaces() throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sportSpacesFile.getPath()))) {

            for (int i = 0; i < currentSpace; i++) {
                bw.write(sportSpaces[i].getName() + ",");
                bw.write(sportSpaces[i].getId() + ",");
                bw.write(sportSpaces[i].getType() + ",");
                bw.write(sportSpaces[i].getCapacity());
                bw.newLine();
            }

        }

    }

    public void searchSpace() {
        String searchedID;
        Boolean found;
        int foundPosition = 0;
        int i = 0;

        System.out.print("Ingrese el ID del espacio que desea buscar: ");
        searchedID = sc.nextLine();
        found = false;

        while (i < currentSpace) {
            if (searchedID.equals(sportSpaces[i].getId())) {
                found = true;
                foundPosition = i;
            }
            i++;
        }
        
        if (found == true) {
            System.out.println("Espacio encontrado: ");
            
            System.out.print(sportSpaces[foundPosition].getName().replace("_", " ") + " | ");
            System.out.print(sportSpaces[foundPosition].getId() + " | ");
            System.out.print(sportSpaces[foundPosition].getType().replace("_", " ") + " | ");
            System.out.println(sportSpaces[foundPosition].getCapacity() + " | ");
        } else {
            System.out.println("La ID que ingreso no coincide con ningun espacio guardado.");
        }
    }
}
