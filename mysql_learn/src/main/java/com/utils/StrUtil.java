package com.utils;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class StrUtil {

    @Test
    public void randomGenerateRoomDate() throws Exception {

        BufferedWriter bufw = new BufferedWriter(new FileWriter("src/main/resources/address.txt"));

        Random random = new Random();

        double d = random.nextGaussian();
        for (int i = 0; i<= 1000000;i++){
            d = Math.abs(random.nextGaussian());
            bufw.write(i +"," + random.nextInt(200) +"," + UUID.randomUUID().toString());
            bufw.newLine();

        }
        System.out.println(random.nextGaussian());
        bufw.close();


    }

}
