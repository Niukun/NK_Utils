package com.codewar;

public class HumanReadableTime {

    public static void main(String[] args) {
        HumanReadableTime.makeReadable(100);
    }
    public static String makeReadable(int seconds) {

        StringBuffer stringBuffer = new StringBuffer();

        String hour = seconds / 3600 < 10 ? "0" + seconds / 3600 : Integer.toString(seconds / 3600) ;
        String min = seconds % 3600 / 60 < 10 ?  "0" + seconds % 3600 / 60  :  Integer.toString(seconds % 3600 / 60);
        String sec = seconds % 3600 % 60 < 10 ?  "0" + seconds % 3600 % 60  :  Integer.toString(seconds % 3600 % 60);

        stringBuffer.append(hour).append(":").append(min).append(":").append(sec);

        return stringBuffer.toString();
    }
}