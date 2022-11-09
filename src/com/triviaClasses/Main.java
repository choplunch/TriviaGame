package com.triviaClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* link: https://youtu.be/kcve04b2QXM */

        /*
         * Exercise 3:
         * a) Trivia Game with CLASSES and Objects:
         * Modify the Trivia Game we have made in the previous two exercises in such a way to use Classes as well.
         * Imagine possible making custom classes for Question Answer Pairs, using Lists to save them
         *
         * b) Bank Management System:
         * Create a Bank Management System which has the following components:
         * Person (which saves first, middle and last name, age and a "social security number")
         * Bank (which saves a List of customers and their Checking Accounts, maximum overdraw amount)
         * Checking Account (should have a current value, methods for taking and depositing money)
         * Opening a Checking Account should only work via a Bank and must require a certain amount of initial deposit.
         *
         * BONUS: Make the Banking System Interactive (No Solution provided!)
         *
         *
         */

        List<Element> elementObjectList = createElementList();

        TriviaGame triviaGame = new TriviaGame("guessName", elementObjectList);

        triviaGame.startGame();
    }

    private static List<Element> createElementList() {
        List<List<String>> data = readDataFromCSV("src/data/ptable.csv");

        List<Element> elementList = new ArrayList<>();

        for (List<String> line: data) {
            Element element = new Element(Integer.parseInt(line.get(0)), line.get(1), line.get(2));
            elementList.add(element);
        }
        return elementList;
    }


    public static List<List<String>> readDataFromCSV(String filePath) {
        List<List<String>> returnData = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip headers
            String line;

            while ((line = reader.readLine()) != null) {
                List<String> lineData = Arrays.asList(line.split("\\s*,\\s*"));
                returnData.add(lineData);

            }
        } catch (IOException e) {
            //Some error logging
        }
        return returnData;
    }
}
