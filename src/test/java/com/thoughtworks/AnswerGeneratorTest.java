package com.thoughtworks;

import com.thougthworks.AnswerGenerator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnswerGeneratorTest
{
    @Test
    public void shouldGenerateFourNumber()
    {
        assertThat(new AnswerGenerator().generate().length(), is(4));
    }

    @Test
    public void shouldGenerateFourRandomNumber()
    {
        assertThat(isFourRandomNumber(new AnswerGenerator().generate()), is(true));
    }

    public boolean isFourRandomNumber(String number)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
