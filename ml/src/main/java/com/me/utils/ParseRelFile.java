package com.me.utils;

import com.me.bean.MeKeys;
import com.me.bean.MeRel;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;

public class ParseRelFile {

    public static void main(String[] args) {
        readCfgFile();
//        getRequest();

//        postResuest();

    }

    private static void postResuest() {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //通过默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            //创建httpGet远程连接实例
            HttpPost httpPost = new HttpPost("http://localhost:8081/test/aaa");
            //设置请求头信息
            httpPost.addHeader("Accept", "application/json");

            //执行get请求得到返回对象
            response = httpClient.execute(httpPost);
            //通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            //通过EntityUtils中的toString方法将结果转换为字符串，后续根据需要处理对应的reponse code
            result = EntityUtils.toString(entity);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


    private static void getRequest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://localhost:8081/test/hello");
        System.out.println("Executing request " + httpget.getRequestLine());

        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = null;
        try {
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
    }


    private static void readCfgFile() {
        BufferedReader bufr = null;
        Map<MeKeys, List<MeRel>> relationShips = new HashMap<MeKeys, List<MeRel>>();

        try {
            bufr = new BufferedReader(new FileReader(new File("ml/src/main/resources/me/rel-door.txt")));
            String line = null;
            while ((line = bufr.readLine()) != null) {

                if (!line.startsWith("#") && line.trim().length() > 0) {
                    System.out.println(line);
                    // 1. 读取每一行，获取关系数组
                    String[] strs = line.split(",");

                    // 2. 得到数组以后，后面两个作为映射关系；前面所有内容作为唯一标识的key
                    String[] keys = Arrays.copyOf(strs, strs.length - 2);
                    String[] rels = Arrays.copyOfRange(strs, strs.length - 2, strs.length);

                    // 3. 维护key中的映射关系
                    MeKeys meKeys = new MeKeys(keys);
                    if (relationShips.containsKey(meKeys)) {
                        relationShips.get(meKeys).add(new MeRel(rels[0], rels[1]));
                    } else {
                        List<MeRel> relList = new ArrayList<MeRel>();
                        relList.add(new MeRel(rels[0], rels[1]));
                        relationShips.put(meKeys, relList);
                    }

                }
            }
            System.out.println(relationShips);
            bufr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufr != null) {
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            return list;
        }
    }
}
