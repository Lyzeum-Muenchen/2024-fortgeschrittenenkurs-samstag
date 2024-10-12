package org.examples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        while(!readText().isEmpty()) {

        }
    }
    public static String readText() {
        // Kommentar
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("isPalindrome: "
                + isPalindrome(input.toLowerCase()));
        return input;
    }

    public static boolean isPalindrome(String text) {
        String firstHalf = text.substring(0, text.length()/2);
        String firstHalfReversed = new StringBuilder(firstHalf)
                .reverse().toString();
        return text.endsWith(firstHalfReversed);
    }
}