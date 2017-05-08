package paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

public class getAddressFromFile {

	public static void main(String[] args) {
		getfmprojectSingleAttr("D:/NLPIR/paper/cabia-customer.txt","D:/NLPIR/paper/address.txt","company_address");
		getfmprojectSingleAttr("D:/NLPIR/paper/cabia-fwo.txt","D:/NLPIR/paper/address.txt","building_address");
		getfmprojectSingleAttr("D:/NLPIR/paper/fmproject.json","D:/NLPIR/paper/address.txt","address_1");
		// getCabiaSingleAttr("location");
		System.out.println("The end...");
	}

	private static void getfmprojectSingleAttr(String sourcefilename, String destfilename,String attr) {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(sourcefilename));
			BufferedWriter bufw = new BufferedWriter(new FileWriter(destfilename,true));
			String str = null;
			JSONObject obj = null;
			int i = 0;
			while ((str = bufr.readLine()) != null) {
				
				try {
					obj = JSONObject.parseObject(str);
//					System.out.println(i + ":" + obj.getString(attr));
					if(obj.getString(attr)!=null&&obj.getString(attr).length()>0){
					bufw.write(obj.getString(attr));
					bufw.newLine();}
				} catch (Exception e) {
					System.out.println(i+++" Not a format json string...");
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
