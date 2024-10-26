package de.lyzeum2.programmieren.bundeswettbewerb2022;

import java.util.ArrayList;

public class Word {

    private String word;
    private String ending;

    public Word(String word) {
        this.word = word;
        this.ending = calculateEnding();
    }

    private String calculateEnding() {
        ArrayList<Integer> startPoints = new ArrayList<>();
        boolean previousVocal = false;
        // Rückwärts Wort anschauen
        // Schaue auf previousVocal
        // previousVocal && !currentVocal -> Startpunkt erkannt
        boolean currentVocal = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            currentVocal = isVocal(word.charAt(i));
            if (previousVocal && !currentVocal) {
                startPoints.add(i + 1);
            }
            previousVocal = currentVocal;
        }
        if (previousVocal) {
            startPoints.add(0); // Wort startet mit Vokal
        }
        if (startPoints.isEmpty()) {
            return "";
        } else if (startPoints.size() == 1) {
            return word.substring(startPoints.get(0));
        } else {
            return word.substring(startPoints.get(1));
        }
    }

    private boolean isVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'ä' || c == 'ö' || c == 'ü';
    }

    public String getWord() {
        return word.toLowerCase();
    }

    public String getEnding() {
        return ending.toLowerCase();
    }

    // Endung besitzt mehr als die Haelfte des Wortes
    public boolean isValid() {
        return ending.length() * 2 >= word.length();
    }
}
