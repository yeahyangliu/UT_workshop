package com.thougthworks;

import com.thougthworks.exception.InputException;
import com.thougthworks.level.Level;

import static java.lang.String.format;

public class Guess
{
    private AnswerGenerator answerGenerator;
    private InputReader inputReader;

    public Guess(AnswerGenerator answerGenerator, InputReader inputReader)
    {
        this.answerGenerator = answerGenerator;
        this.inputReader = inputReader;
    }

    public void run()
    {
        System.out.print("Welcome!\n Please choose run hardness:(1.Easy, 2.Normal, 3.Hard, 4.Impossible)");

        Level level = LevelFactory.getLevel(inputReader.readSelect());
        System.out.print(format("Please input your number(%d)", level.getTimes()));

        String guess = answerGenerator.generate();
        System.out.println("Answer is : " + guess);
        level.compare(guess);
    }


    public static void main(String args[])
    {
        Guess guess = new Guess(new AnswerGenerator(), new InputReader());

        guess.run();
    }
}


