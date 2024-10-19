package de.lyzeum2.programmieren.bundeswettbewerb2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Junioraufgabe1 {

    public List<String> readFile(String resourcePath) {
        try {
            File file = new File(Main.getClass().getResource(resourcePath).getFile());
            Scanner sc = new Scanner(file);
            ArrayList<String> words = new ArrayList<>();
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
            return words;
        }catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return List.of();
    }
}
