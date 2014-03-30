package com.thougthworks.level;

import com.thougthworks.CompareNumber;
import com.thougthworks.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class NormalTest
{
    private CompareNumber compareNumber;
    private InputReader inputReader;
    private Normal normal;
    private ByteArrayOutputStream out;

    @Before
    public void setUp()
    {
        compareNumber = mock(CompareNumber.class);
        inputReader = mock(InputReader.class);
        normal = new Normal(compareNumber, inputReader);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldCall6TimesGivenAllWrong()
    {
        when(compareNumber.compare("1243", "1234")).thenReturn("2A2B");
        when(inputReader.readGuess()).thenReturn("1243");

        normal.compare("1234");

        verify(inputReader, times(6)).readGuess();
        assertThat(out.toString().contains("Game Over"), is(true));
    }
}
