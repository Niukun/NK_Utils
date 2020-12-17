package com.utils;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class StrUtil {

    @Test
    public void randomGenerateRoomDate() throws Exception {

        BufferedWriter bufw = new BufferedWriter(new FileWriter("F:\\Data\\IntellijIdea\\NK_Utils\\mysql_learn\\src\\main\\resources\\room.txt"));

        Random random = new Random();

        double d = random.nextGaussian();
        for (int i = 0; i<= 10000000;i++){
            d = Math.abs(random.nextGaussian());
            bufw.write(d*80* (1+random.nextInt(10)*0.2) +"," + random.nextInt(200) +"," +d*80* (1+random.nextInt(10)*0.2));
            bufw.newLine();

        }
        System.out.println(random.nextGaussian());
        bufw.close();


    }

}
