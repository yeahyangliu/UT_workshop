package com.thougthworks;

import com.thougthworks.level.*;

public class LevelFactory
{
//    public static ImmutableMap levels = new ImmutableMap.Builder<String, Level>()
//            .put("1", Level.EASY)
//            .put("2", Level.NORMAL)
//            .put("3", Level.HARD)
//            .put("4", Level.IMPOSSIBLE)
//            .build();



    public static Level getLevel(String select)
    {
        if("1".equals(select)) return new Easy();
        else if("2".equals(select)) return new Normal();
        else if("3".equals(select)) return new Hard();
        else if("4".equals(select)) return new Impossible();
        else return null;
    }
}
