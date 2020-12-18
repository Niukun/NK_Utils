package com.hrssc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hrssc.service.CodeList;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeListImpl implements CodeList {
    String url = "http://117.71.53.199:40006/WebService1.asmx/GetCodeTable";

    String[] dics = {
            "zkml.hrssc.dt_hrssc_cod_probation",
            "zkml.hrssc.dt_hrssc_cod_study",
            "zkml.hrssc.dt_hrssc_cod_nation",
            "zkml.hrssc.dt_hrssc_cod_educationbackground",
            "zkml.hrssc.dt_hrssc_cod_language",
            "zkml.hrssc.dt_hrssc_cod_proficiency",
            "zkml.hrssc.dt_hrssc_cod_degree",
            "zkml.hrssc.dt_hrssc_cod_relationship",
            "zkml.hrssc.dt_hrssc_cod_titlelevel",
            "zkml.hrssc.dt_hrssc_cod_agreementperiod",
            "zkml.hrssc.dt_hrssc_cod_degreetype",
            "zkml.hrssc.dt_hrssc_cod_bloodtype",
            "zkml.hrssc.dt_hrssc_cod_othercerttype",
            "zkml.hrssc.dt_hrssc_cod_natureregistration",
            "zkml.hrssc.dt_hrssc_cod_province",
            "zkml.hrssc.dt_hrssc_cod_contacttype",
            "zkml.hrssc.dt_hrssc_cod_censustype",
            "zkml.hrssc.dt_hrssc_cod_sex",
            "zkml.hrssc.dt_hrssc_cod_attachment",
            "zkml.hrssc.dt_hrssc_cod_politicaloutlook",
            "zkml.hrssc.dt_hrssc_cod_staffstatus",
            "zkml.hrssc.dt_hrssc_cod_jobtype",
            };

    @Test
    public String generateBody(String value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("DICTIONARYCFGNAME",value);
        return jsonObject.toJSONString();
    }


    /**
     * 调用此方法，从paas管理平台获取token
     * @throws IOException
     */
    @Test
    public void initCodeList() throws IOException {
        for (String str: dics ) {
            postRequest(generateBody(str));
            System.out.println(str + " =====================================");
        }
        System.out.println("Done.");
    }

    @Test
    public void testDate(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }

    @Test
    public void testPID(){
        System.out.println(Integer.parseInt(String.valueOf("341281199208130623".charAt(16)))%2 == 1?"1":"2");
    }


    private void postRequest(String body) throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.addRequestProperty("ID","a83c44cba36c4887ac475b30156c7a3c");
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        connection.connect();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        writer.write(body);
        writer.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(inputStream));
            String result = responseBuffer.readLine();
            System.out.println(result);
        }
    }
}
