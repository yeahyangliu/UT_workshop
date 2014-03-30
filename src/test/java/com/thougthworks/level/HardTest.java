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

public class HardTest
{
    private CompareNumber compareNumber;
    private InputReader inputReader;
    private Hard hard;
    private ByteArrayOutputStream out;

    @Before
    public void setUp()
    {
        compareNumber = mock(CompareNumber.class);
        inputReader = mock(InputReader.class);
        hard = new Hard(compareNumber, inputReader);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldCall6TimesGivenAllWrong()
    {
        when(compareNumber.compare("1243", "1234")).thenReturn("2A2B");
        when(compareNumber.compare("5678", "1234")).thenReturn("0A0B");
        when(inputReader.readGuess()).thenReturn("5678").thenReturn("1243");

        hard.compare("1234");

        verify(inputReader, times(5)).readGuess();
        assertThat(out.toString().contains("Game Over"), is(true));
    }
}
