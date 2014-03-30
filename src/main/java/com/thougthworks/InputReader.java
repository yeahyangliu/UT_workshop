package com.thougthworks;

import com.thougthworks.exception.InputException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputReader
{
    private Scanner scannerIn = new Scanner(System.in);

    public String read() throws InputException
    {
        String theInputNumber = scannerIn.nextLine();

        Pattern compile = Pattern.compile("[0-9]{4}");
        if (!compile.matcher(theInputNumber).matches()) {
            throw new InputException("invalid input");
        } else {
            return theInputNumber;
        }
    }

    public String select() throws InputException
    {
        String value = scannerIn.nextLine();

        Pattern compile = Pattern.compile("[1-4]");
        if (compile.matcher(value).matches()) {
            return value;
        } else {
            throw new InputException("invald select");
        }
    }


    public String readSelect()
    {
        try {
            return select();
        } catch (InputException e) {
            System.err.println("Please select 1 ~ 4");
        }
        return readSelect();
    }



    public String readGuess()
    {
        try {
            return read();
        } catch (InputException e) {
            System.err.println("Please input 4 numbers");
        }
        return readGuess();
    }
}
