package com.thougthworks.level;

import com.thougthworks.CompareNumber;
import com.thougthworks.InputReader;

public class Hard extends Level
{

    public Hard(CompareNumber compareNumber, InputReader inputReader)
    {
        super(6, compareNumber, inputReader);
    }

    public Hard()
    {
        super(6, new CompareNumber(), new InputReader());
    }

    @Override
    public void compare(String expect)
    {
        for (int i = times; i >= 0; i--) {
            if (i > 0) {
                String result = compareNumber.compare(inputReader.readGuess(), expect);
                if (PERFECT.equals(result)) {
                    System.out.println("Congratulations!");
                } else if (WORST.equals(result)) {
                    i--;
                    System.out.println("Please input your number(" + (i - 1) + ")");
                } else {
                    System.out.println("Please input your number(" + (i - 1) + ")");
                }
            } else {
                System.out.println("Game Over");
            }
        }
    }

}
