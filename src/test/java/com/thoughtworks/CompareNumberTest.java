package com.thoughtworks;

import com.thougthworks.CompareNumber;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CompareNumberTest
{

    private CompareNumber compareNumber;

    @Before
    public void setUp()
    {
        compareNumber = new CompareNumber();
    }

    @Test
    public void shouldGetFourAWhenAllEqual()
    {
        String result = compareNumber.compare("1234", "1234");
        assertThat(result, is("4A0B"));
    }

    @Test
    public void shouldGetFourBWhenNoneEqual()
    {
        String result2 = compareNumber.compare("1234", "4321");
        assertThat(result2, is("0A4B"));
//        System.out.println((int)(Math.random()*8)+1);
    }

    @Test
    public void shouldGetThreeA()
    {
        String result3 = compareNumber.compare("1234", "1235");
        assertThat(result3, is("3A0B"));
    }

    @Test
    public void shouldGetTwoA()
    {
        String result4 = compareNumber.compare("1234", "1245");
        assertThat(result4, is("2A1B"));
    }

    @Test
    public void should2A2B()
    {
        String result = compareNumber.compare("1245", "1254");
        assertThat(result, is("2A2B"));
    }
}
