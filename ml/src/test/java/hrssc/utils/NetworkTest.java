package hrssc.utils;

import com.mysql.cj.jdbc.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;

public class NetworkTest {
    private static BufferedWriter bufw;

    static {
        try {
            bufw = new BufferedWriter(new FileWriter("ip.txt",true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() throws IOException {
        String ip = "192.168.";
//        for(int i = 100; i<255;i++){
            for(int j = 0; j<255;j++){
                isReachIp(ip + 110 +"." + j);
            }
//        }

    }


    public boolean isReachIp(String ip) {
        boolean isReach = false;
        try {
            InetAddress address = InetAddress.getByName(ip);// ping this IP
            if (address.isReachable(5000)) {
                isReach = true;
                bufw.write("SUCCESS - ping : " + ip);
                System.out.println("1: " + ip);
            } else {
//                System.out.println("0: " + ip);
            }
        } catch (Exception e) {
            System.out.println("error occurs:" + e.getMessage());
        }
        return isReach;
    } 

}
