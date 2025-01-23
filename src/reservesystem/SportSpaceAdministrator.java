/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.Integer.parseInt;

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
                        parseInt(data[3].toUpperCase().trim()));
                sportSpaces[currentSpace] = sportSpace;
                currentSpace++;
            }

        }
    }

    public void makeSportSpace() {

        String name;
        String id;
        String type;
        int capacity = 0;

        System.out.print("Ingrese el nombre del espacio deportivo: ");
        name = sc.next();
        System.out.print("Ingrese el ID del espacio deportivo: ");
        id = sc.next();
        System.out.print("Ingrese el tipo de espacio deportivo: ");
        type = sc.next();
        System.out.print("Ingrese la capacidad del espacio deportivo: ");
        sc.nextInt();

        SportSpace sportSpace = new SportSpace(name, id, type, capacity);
        sportSpaces[currentSpace] = sportSpace;
        currentSpace++;

    }

}
