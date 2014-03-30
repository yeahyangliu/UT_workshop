package com.thougthworks.level;

import com.thougthworks.CompareNumber;
import com.thougthworks.InputReader;

import java.util.HashSet;
import java.util.Set;

public class Impossible extends Level
{
    private Set rightChoose = new HashSet();

    public Impossible(CompareNumber compareNumber, InputReader inputReader)
    {
        super(6, compareNumber, inputReader);
    }

    public Impossible()
    {
        super(6, new CompareNumber(), new InputReader());
    }

    @Override
    public void compare(String expect)
    {
        for (int round = times; round >= 0; round--) {
            if (round > 0) {
                String guess = inputReader.readGuess();
                String result = compareNumber.compare(guess, expect);
                round -= reduceChance(guess, expect);
                if (PERFECT.equals(result)) {
                    System.out.println("Congratulations!");
                } else {
                    System.out.println("Please input your number(" + (round - 1) + ")");
                }
            } else {
                System.out.println("Game Over");
            }
        }

    }

    private int reduceChance(String input, String expect)
    {
        Set currentRightChoose = new HashSet();
        for (int j = 0; j < 4; j++) {
            if (input.charAt(j) == expect.charAt(j)) {
                if (!rightChoose.contains(input.charAt(j))) {
                    currentRightChoose.add(input.charAt(j));
                }
                rightChoose.add(input.charAt(j));
            }
        }
        return currentRightChoose.size();
    }
}


