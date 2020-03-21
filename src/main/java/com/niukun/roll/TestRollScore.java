package com.niukun.roll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRollScore {
    RollScore rs = new RollScore();
    @Test
    public void testOneTwo(){
        String str = "12 12 12 12 12 12 12 12 12 12";
        assertEquals(30, rs.getScore(str));
    }

    @Test
    public void testOneZero(){
        String str = "1- 1- 1- 1- 1- 1- 1- 1- 1- 1-";
        assertEquals(10, rs.getScore(str));
    }

    @Test
    public void testOneSlash(){
        String str = "1/ 1- 1- 1- 1- 1- 1- 1- 1- 1-";
        assertEquals(20, rs.getScore(str));
    }

    @Test
    public void testOneSlashOne(){
        String str = "1- 1- 1- 1- 1- 1- 1- 1- 1- 1/1";
        assertEquals(20, rs.getScore(str));
    }

    @Test
    public void testFiveSlashFour(){
        String str = "5/ 4- -- -- -- -- -- -- -- --";
        assertEquals(18, rs.getScore(str));
    }

    @Test
    public void testAllZero(){
        String str = "-- -- -- -- -- -- -- -- -- --";
        assertEquals(0, rs.getScore(str));
    }

    @Test
    public void testAllTen(){
        String str = "X X X X X X X X X XXX";
        assertEquals(300, rs.getScore(str));
    }

}
