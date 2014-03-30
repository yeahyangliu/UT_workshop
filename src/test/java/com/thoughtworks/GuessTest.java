package com.thoughtworks;

import com.thougthworks.AnswerGenerator;
import com.thougthworks.CompareNumber;
import com.thougthworks.Guess;
import com.thougthworks.InputReader;
import com.thougthworks.exception.InputException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GuessTest
{
    private AnswerGenerator answerGenerator;
    private CompareNumber compareNumber;
    private InputReader inputReader;
    private ByteArrayOutputStream out;
    private Guess guess;

    @Before
    public void setUp()
    {
        answerGenerator = mock(AnswerGenerator.class);
        compareNumber = mock(CompareNumber.class);
        inputReader = mock(InputReader.class);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        guess = new Guess(answerGenerator, inputReader);
    }

    @Test
    public void shouldIntegrationSuccess() throws InputException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1234".getBytes());
        System.setIn(byteArrayInputStream);

        when(inputReader.readSelect()).thenReturn("1");
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234", "1234")).thenReturn("4A0B");

        guess.run();

        assertThat(out.toString().contains("Welcome!\n Please choose run hardness:(1.Easy, 2.Normal, 3.Hard, 4.Impossible)"), is(true));
        assertThat(out.toString().contains("Please input your number(12)"), is(true));
        assertThat(out.toString().contains("Congratulations!"), is(true));
    }
}