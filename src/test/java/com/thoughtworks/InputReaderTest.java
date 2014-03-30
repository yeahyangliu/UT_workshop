package com.thoughtworks;

import com.thougthworks.InputReader;
import com.thougthworks.exception.InputException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InputReaderTest
{

    private InputReader inputReader;
    private ByteArrayOutputStream out;

    @Test(expected = InputException.class)
    public void shouldThrowExceptionWhenInvalidInput() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("@##$".getBytes());
        System.setIn(byteArrayInputStream);
        out = new ByteArrayOutputStream();
        System.setErr(new PrintStream(out));
        inputReader = new InputReader();

        inputReader.read();

        assertThat(out.toString().contains("Please input 4 numbers"), is(true));
    }

    @Test
    public void shouldGetValidInput() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1234".getBytes());
        System.setIn(byteArrayInputStream);
        inputReader = new InputReader();

        String read = inputReader.read();

        assertThat(read, is("1234"));
    }

    @Test(expected = InputException.class)
    public void shouldGetFourDigit() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("123445".getBytes());
        System.setIn(byteArrayInputStream);
        inputReader = new InputReader();

        inputReader.read();
    }

    @Test
    public void shouldGetValidSelectGivenInputOne() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        inputReader = new InputReader();

        String select = inputReader.select();

        assertThat(select, is("1"));
    }

    @Test(expected = InputException.class)
    public void shouldGetInvalidSelectGivenMoreThanTwoChars() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("12".getBytes());
        System.setIn(byteArrayInputStream);
        inputReader = new InputReader();

        inputReader.select();
    }
}
