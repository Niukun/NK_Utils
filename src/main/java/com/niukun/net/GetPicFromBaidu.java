package com.niukun.net;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPicFromBaidu {
    static final String homeStr = "http://w1.adca2cf2fdb.xyz/pw/";
//    static final String homeStr = "http://w1.adca2cf2fdb.xyz/pw/";
    static final String siWaEntry = "http://w1.adca2cf2fdb.xyz/pw/thread.php?fid=21&page=";
    static final String againInfo = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)";
    static Random r = new Random();


    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i = 0;i< 20; i++){
            getFromPageNum(i);
            System.out.println("Page " + i + "Done...");
        }
//

        System.out.println("Done...");
    }

    private static void getFromPageNum(int pageNum) throws IOException, InterruptedException {
        File folder;
        String pPath;
        FileWriter urlSource;
        List<String> list = getPageDownLoadURLs(pageNum);
        System.out.println("Start...");
        for(int i = 0; i< list.size();i++){
            pPath = "H:\\pic0929\\" + pageNum + i;
            folder = new File(pPath);
            folder.mkdirs();
            System.out.println("url " + i + " " + list.get(i));
            urlSource = new FileWriter(new File(pPath + "\\sourceUrl.txt"));
            urlSource.write(list.get(i));
            urlSource.close();
            Document doc = Jsoup.parse(getHtmlElement(getSourceCodeFromURL(list.get(i))));
            Element divWithImgs = doc.getElementById("read_tpc");
            Elements imgs = divWithImgs.getElementsByTag("img");
            for(int j =0; j< imgs.size();j++){
                String imgURI = imgs.get(j).attr("src");
                getPicFromCertainURL(imgURI, pPath + j +".jpg");
//                Thread.sleep(1000 * r.nextInt(10));
                System.out.println(imgURI);
            }
        }
    }

    private static List getPageDownLoadURLs(int pageNum) throws IOException, InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        String siwaPageStr = getSourceCodeFromURL(siWaEntry+pageNum);
        String htmlStr = getHtmlElement(siwaPageStr);
//        System.out.println("htmlStr is: \n" + htmlStr);

        Document doc = Jsoup.parse(htmlStr);
        Elements divTable = doc.getElementsByClass("t_one");

        for(Element table: divTable){
            Elements h3s = table.getElementsByTag("h3");
            for(Element h3:h3s){
                String href = h3.getElementsByTag("a").get(0).attr("href");
                if(href.startsWith("html_data")){
                    String realHref = homeStr.concat(href);
                    list.add(realHref);
                }
            }
        }
        return list;
    }

    private static String getHtmlElement(String htmlSourceCode) throws IOException {
//        String htmlSourceCode = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html><script></script><script></script>";
        String pattern = "<html(.*)</html>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(htmlSourceCode);
//        System.out.println("htmlSourceCode is：\n" +htmlSourceCode);
        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
            //保存 /TODO
//            FileWriter fw = new FileWriter("H:\\getHtmlElement.html");
//            fw.write(m.group(0));
//            fw.close();
            return m.group(0);
        } else {
            System.out.println("NO MATCH");
            return "";
        }
    }

    private static String getSourceCodeFromURL(String urlStr) throws IOException, InterruptedException {
        URL url = new URL(urlStr);
        Thread.sleep(1000 * r.nextInt(10));
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", againInfo);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while((line = bufr.readLine())!=null){
            sb.append(line);
        }
        //保存 /TODO
//        FileWriter fw = new FileWriter("H:\\getSourceCodeFromURL.html");
//        fw.write(sb.toString());
//        fw.close();
        bufr.close();
        return sb.toString();
    }


    /**
     *
     * @param uri 图片的url
     * @param abPath 图片要存放的目录（绝对路径）
     * @throws IOException
     */
    public static void getPicFromCertainURL(String uri,String abPath) throws IOException {
        URL url;
        String urlStr = uri;
        BufferedInputStream bufi;
        FileOutputStream file;

        String filePath = abPath;
        url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
        bufi = new BufferedInputStream(connection.getInputStream());
        file = new FileOutputStream(new File(filePath));
        int t;
        while((t = bufi.read())!=-1){
            file.write(t);
        }
        file.close();
    }
}
