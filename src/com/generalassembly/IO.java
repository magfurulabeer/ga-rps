package com.generalassembly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IO {
    private static IO singleton = null;
    private Scanner scanner;

    private IO() {
        scanner = new Scanner(System.in);
    }

    public static IO shared() {
        if (singleton == null)
            singleton = new IO();
        return singleton;
    }

    public String in() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public void out(String text) {
        try {
            Thread.sleep(150);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(text);
    }

    public String qa(String question, boolean allowAbbreviations, String... validInput) {
        this.out(question);
        String answer = this.in();

        ArrayList<String> validInputList = new ArrayList<String>(Arrays.asList(validInput));
        if(allowAbbreviations) {
            ArrayList<String> abbreviations = (ArrayList<String>)Arrays
                    .stream(validInput)
                    .map(input -> String.valueOf(input.charAt(0)))
                    .collect(Collectors.toList());
            validInputList.addAll(abbreviations);
        }

        while(!validInputList.contains(answer)) {
            this.out("Invalid Input!");
            this.out(question);
            answer = in();
        }

        if(allowAbbreviations) {
            String finalAnswer = answer;
            return Arrays
                    .stream(validInput)
                    .filter(input -> input.startsWith(finalAnswer))
                    .findFirst()
                    .get();
        }
        return answer;
    }

    public void lineBreak() {
        System.out.println("");
    }
}