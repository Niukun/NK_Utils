package paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

public class FzhongERPFile {

	public static void main(String[] args) {
		// getfmprojectSingleAttr("address_1");
		getCabiaSingleAttr("location");
	}

	private static void getfmprojectSingleAttr(String attr) {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/paper/fmproject.json"));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/paper/fmproject_address_1.txt"));
			String str = null;
			JSONObject obj = null;
			int i = 0;
			while ((str = bufr.readLine()) != null) {
				i++;
				obj = JSONObject.parseObject(str);
				System.out.println(i + ":" + obj.getString(attr));
				if (!obj.getString(attr).contains("路") && !obj.getString(attr).contains("道")
						&& !obj.getString(attr).contains("街")
						&& (obj.getString(attr).contains("弄") || obj.getString(attr).contains("号"))) {
					bufw.write(obj.getString(attr));
					bufw.newLine();
				} else {
				}

			}
			bufw.flush();
			bufw.close();
			bufr.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	private static void getCabiaSingleAttr(String attr) {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/paper/CabiaData.txt"));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/paper/CabiaData_address.txt"));
			String str = null;
			JSONObject subobj = null;
			JSONObject obj = null;
			int i = 0;
			while ((str = bufr.readLine()) != null) {
				i++;
				subobj = JSONObject.parseObject(str);
				obj = JSONObject.parseObject(JSONObject.parseObject(subobj.getString("payload")).getString("object"));
				System.out.println(obj);
				bufw.write(obj.getString("company_name") + "\t" + obj.getString(attr));
				bufw.newLine();

			}
			bufw.flush();
			bufw.close();
			bufr.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
