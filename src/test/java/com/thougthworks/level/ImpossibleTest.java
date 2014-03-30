package com.thougthworks.level;

import com.thougthworks.CompareNumber;
import com.thougthworks.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class ImpossibleTest
{
    private CompareNumber compareNumber;
    private InputReader inputReader;
    private Impossible impossible;
    private ByteArrayOutputStream out;

    @Before
    public void setUp()
    {
        compareNumber = mock(CompareNumber.class);
        inputReader = mock(InputReader.class);
        impossible = new Impossible(compareNumber, inputReader);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void should5TimesWhenHaveOneA()
    {
        when(compareNumber.compare("4567", "1237")).thenReturn("1A0B");
        when(inputReader.readGuess()).thenReturn("4567");

        impossible.compare("1237");

        verify(inputReader, times(5)).readGuess();
    }

    @Test
    public void shouldHave4TimeGivenAppare2A()
    {
        when(compareNumber.compare("4567", "1237")).thenReturn("1A0B");
        when(compareNumber.compare("1347", "1237")).thenReturn("2A1B");
        when(inputReader.readGuess()).thenReturn("4567").thenReturn("1347");

        impossible.compare("1237");

        verify(inputReader, times(4)).readGuess();
    }
}
