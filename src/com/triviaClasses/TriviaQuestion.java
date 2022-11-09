package com.triviaClasses;

import java.util.Objects;
import java.util.Random;

public class TriviaQuestion {
    String question = this.question;
    String answer = this.answer;

    public TriviaQuestion(String name, String symbol, String mode) {
        if (Objects.equals(mode, "random")) {
            Random random = new Random();
            mode = random.nextInt(2) == 1 ? "guessSymbol" : "guessName";
        }

        if (Objects.equals(mode, "guessSymbol")) {
            this.question = "What is the chemical symbol for " + name + "?";
            this.answer = symbol;
        }
        else if (Objects.equals(mode, "guessName")){
            this.question = "What is the name of the element with symbol " + symbol + "?";
            this.answer = name;
        }

    }

    // What is the chemical symbol for Cobalt?
    // What is the name of the element with symbol Co?

    public boolean isAnswerCorrect(String answer) {
        return answer.equalsIgnoreCase(this.answer);
    }

    public void askQuestion() {
        System.out.println(this.question);
    }



}
