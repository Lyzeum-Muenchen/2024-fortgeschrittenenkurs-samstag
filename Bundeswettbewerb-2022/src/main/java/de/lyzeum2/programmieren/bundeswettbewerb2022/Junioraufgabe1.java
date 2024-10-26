package de.lyzeum2.programmieren.bundeswettbewerb2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Junioraufgabe1 {

    public Junioraufgabe1(String path) {
        List<String> wordsString = readFile(
                path
        );
        // Wörter sortieren
        wordsString.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<Word> words = new ArrayList<Word>();
        for (String wordString: wordsString) {
            Word word = new Word(wordString);
            if (word.isValid()) {
                words.add(word);
            }
        }
        List<String[]> foundCombinations = new ArrayList<>();
        // Wörtervergleich
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (compareWords(words.get(i), words.get(j))) {
                    foundCombinations.add(
                            new String[]{
                                    words.get(i).getWord(),
                                    words.get(j).getWord()}
                    );
                }
            }
        }
        // Wortpaare ausgeben
        for (String[] combinations : foundCombinations) {
            System.out.println(combinations[0] +
                    " - " + combinations[1]);
        }
    }

    public boolean compareWords(Word word1, Word word2) {
        // Wort darf nicht im anderen Wort ganz enthalten sein
        if (word1.getWord().contains(word2.getWord())
                || word2.getWord().contains(word1.getWord())) {
            return false;
        }
        // Beide Wörter haben die gleiche Endung
        if (!word1.getEnding().equals(word2.getEnding())) {
            return false;
        }
        return true;
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
