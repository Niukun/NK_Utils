package hrssc.utils.logs;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IntegrateLogSummary {


    @Test
    public void getLogSum(){
        List list = new ArrayList();
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(new FileReader("C:\\Users\\Niuk\\Downloads\\log\\integrate.2022-01-17.0.log"));
            bufw = new BufferedWriter(new FileWriter("C:\\Users\\Niuk\\Downloads\\log\\integrate.2022-01-17.0.log.log"));

            int number = 1;
            String line = null;
            while((line = bufr.readLine())!= null){
                if(line.contains("decodedStr is:")){
                    bufw.write("第" + number++ + "条记录\n");
                    String text = "时间: " + getTime(line.substring(0,8),8) + "\tdecodedStr is:" + line.substring(line.indexOf("decodedStr is:")+"decodedStr is:".length());
                    list.add(text);
                    bufw.write(text);
                }

                boolean isStep1 = true;

                if(line.contains("推送贷款进度 解密 is: {\"customerCode")){
                    if(isStep1){
                        bufw.write("第" + number++ + "条记录\n");
                    }

                    String text = "时间: " + getTime(line.substring(0,8),8) + "\t推送贷款进度 解密 is:" + line.substring(line.indexOf("推送贷款进度 解密 is")+"推送贷款进度 解密 is".length());
                    isStep1 = !isStep1;
                    list.add(text);
                    bufw.write(text);
                }

                if(line.contains("反馈贷款信息 解密 is: {\"bra")){
                    if(isStep1){
                        bufw.write("第" + number++ + "条记录\n");
                    }

                    String text = "时间: " + getTime(line.substring(0,8),8) + "\t反馈贷款信息 解密 is:" + line.substring(line.indexOf("反馈贷款信息 解密 is:")+"反馈贷款信息 解密 is:".length());
                    isStep1 = !isStep1;
                    list.add(text);
                    bufw.write(text);
                }

                boolean isStep5 = false;
                if(line.contains("交换机第五步")){
                    isStep5 = true;
                }
                if(line.contains("in2out result:")){

                    String result = "\n时间: " + getTime(line.substring(0,8),8) + "\t返回结果:" + line.substring(line.indexOf("in2out result:")+"in2out result:".length());
                    list.add(result +"\n");
                    bufw.write(result);
                    bufw.newLine();
                    bufw.newLine();
                    isStep5 = false;
                }
            }
            bufw.close();
            bufr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufr != null){
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(list);
        }
    }

    private String getTime(String time, int hours){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR, 8);// 24小时制
            date = cal.getTime();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return format.format(date);
    }

}
