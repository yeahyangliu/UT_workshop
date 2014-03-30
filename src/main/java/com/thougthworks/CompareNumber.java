package com.thougthworks;

import static java.lang.String.format;

public class CompareNumber
{
    public String compare(String input, String expect)
    {
        int numberOfA = 0;
        int numberOfB = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (input.charAt(i) == expect.charAt(j)) {
                    if (i == j)
                        numberOfA++;
                    else
                        numberOfB++;
                }
            }
        }
        return format("%dA%dB", numberOfA, numberOfB);
    }
}