package com.niukun.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class InetAddressDemo {
    private static Logger logger = Logger.getLogger(InetAddressDemo.class);
    public static final String FIRST_LEVEL = "www.85814.com/meinv/";

    public static void main(String[] args) throws Exception {
        if(InetAddressDemo.isAccessable(FIRST_LEVEL, 5000)){
            logger.info("Yes, we can do it....");
        }else{
            logger.info("No, we can not do this right now...");
        }
        URL url = new URL(FIRST_LEVEL);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setConnectTimeout(5000);
        urlConn.setRequestMethod("GET");








    }

    //Test the url is accessable or not
    private static boolean isAccessable(String url, int timeout) {
        boolean flag = false;
        try {
            InetAddress ip = InetAddress.getByName(url);
            flag = ip.isReachable(timeout);
        } catch (UnknownHostException e) {
            logger.warn("UnknownHostException happens...");
//            e.printStackTrace();
        } catch (IOException e) {
            logger.warn("IOException happens...");
//            e.printStackTrace();
        }
        return flag;
    }


}
