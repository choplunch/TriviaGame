package com.triviaClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TriviaGame {
    public TriviaGame(String mode, List<Element> elementList) {
        this.mode = mode;
        this.elementList = elementList;
        this.amountOfQuestions = 10;
        this.score = 0;
    }

    int score = this.score;
    int amountOfQuestions = this.amountOfQuestions;
    String mode = this.mode;
    boolean shuffleElementList = true;
    List<Element> elementList = this.elementList;
    Scanner scanner = new Scanner(System.in);
    List<Element> incorrectElementList = new ArrayList<>();



    public void startGame() {
        if (this.shuffleElementList) {
            Collections.shuffle(elementList);
        }


        for (int i = 0; i < amountOfQuestions; i++) {

            String name = elementList.get(i).getName();
            String symbol = elementList.get(i).getElementalSymbol();

            TriviaQuestion question = new TriviaQuestion(name, symbol, this.mode);

            question.askQuestion();
            String answer = scanner.nextLine();

            System.out.println();

            if (question.isAnswerCorrect(answer)) {
                incrementScore();
                System.out.println("Correct!");
            }
            else {
                // add element to incorrect element list
                incorrectElementList.add(this.elementList.get(i));
                System.out.println("Incorrect! The correct answer was " + question.answer);
            }

            printScore();
            System.out.println();
            System.out.println("------------------------------");

        }

        endMessage();


    }




    public void incrementScore() {
        this.score++;
    }

    public void printScore() {
        System.out.println("Your current score is " + this.score + "/" + this.amountOfQuestions);
    }

    public void endMessage() {
        System.out.println("You have made it to the end, congrats!");
        System.out.println("You guessed " + this.score + " elements correct out of " + this.amountOfQuestions);
        printErrors();
    }

    public void printErrors() {
        System.out.println();
        System.out.println("You got these elements wrong:");
        for (Element element : incorrectElementList) {
            System.out.println(element.getElementalSymbol() + " -> " + element.getName());
        }
    }


}
