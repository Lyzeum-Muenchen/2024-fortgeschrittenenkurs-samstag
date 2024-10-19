package de.lyzeum2.programmieren.bundeswettbewerb2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Junioraufgabe1 {

    public Junioraufgabe1() {
        List<String> words = readFile(
                "/jugendaufgabe/reimerei0.txt"
        );
        System.out.println(words.get(0));
    }

    public String getEnding(String word) {
        return "";
    }

    public List<String> readFile(String resourcePath) {
        try {
            File file = new File(this.getClass()
                    .getResource(resourcePath).getFile());
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
