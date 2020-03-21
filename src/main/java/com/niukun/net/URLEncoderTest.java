package com.niukun.net;

import org.apache.log4j.Logger;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderTest {
    private static Logger logger = Logger.getLogger(URLEncoderTest.class);

    public static void main(String[] args) throws Exception {
        String encodedStr = URLEncoder.encode("一个汉字", "utf-8");
        String decodedStr = URLDecoder.decode("%E4%B8%80%E4%B8%AA%E6%B1%89%E5%AD%97", "utf-8");
        logger.info(encodedStr);
        logger.info(decodedStr);

    }
}
