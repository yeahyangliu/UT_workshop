package com.thougthworks;

public class AnswerGenerator
{
    public String generate()
    {
        String baseValue = getRandomNumber();

        String result = String.valueOf(baseValue);
        while (true) {
            String number = getRandomNumber();
            if (result.indexOf(number) == -1) {
                result += number;
            }
            if (result.length() > 3) break;
        }
        return result;

    }

    private static String getRandomNumber()
    {
        return String.valueOf((int) (Math.random() * 8) + 1);
    }
}
