package com.thougthworks.level;

import com.thougthworks.CompareNumber;
import com.thougthworks.InputReader;

public abstract class Level
{
    public static final String PERFECT = "4A0B";
    public static final String WORST = "0A0B";

    protected CompareNumber compareNumber;
    protected InputReader inputReader;
    protected int times;

    Level(int times, CompareNumber compareNumber, InputReader inputReader)
    {
        this.times = times;
        this.compareNumber = compareNumber;
        this.inputReader = inputReader;
    }

    public abstract void compare(String expect);

    public int getTimes()
    {
        return times;
    }
}
