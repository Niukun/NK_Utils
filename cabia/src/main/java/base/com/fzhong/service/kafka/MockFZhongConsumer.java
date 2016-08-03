package base.com.fzhong.service.kafka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONObject;

import business.com.fzhong.service.kg.dto.req.BuildingReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * 从阿里云kafka中读到的数据存入本地文件cabia_data.txt，程序联调时使用该类作为kafka数据读入模块
 * 
 * @author Niukun
 * 
 */
public class MockFZhongConsumer {
	private static List<DataReqDto> addressList = new ArrayList<DataReqDto>();
	private static List<String> strList = new ArrayList<String>();
	private static Set<String> addressSet = new TreeSet<String>();
	private static int numbKafka = 0;

	/**
	 * 运行main函数获得数据相关信息,单独测试该类时使用
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		List<DataReqDto> testaddress = getAddressList();
		System.out.println("kafka中所有数据条数" + addressList.size());
		System.out.println("kafka中不同爬虫数据个数：" + addressSet.size());
	}

	/**
	 * 从文件读取逐行数据，添加到strList中，并返回
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<String> getLocalStrList() {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("CabiaData.txt"));
			String line = "";
			int count = 0;
			while ((line = bufr.readLine()) != null) {
				if (count++ < 1000) {
					strList.add(line);
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return strList;
	}

	public static List<String> getStrList() {
		return strList;
	}

	/**
	 * 从本地文件读数据，解析处理每条数据，直接返回DataDto类型的List
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	@Deprecated
	public static List<DataReqDto> getAddressList() {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("CabiaData.txt"));
			String line = "";
			int count = 0;
			while ((line = bufr.readLine()) != null) {
				if (count++ < 1000) {
					addDataToAddressList(line);
					addressSet.add(line);
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return addressList;
	}

	/**
	 * 每一条数据根据其类型进行不同的初始化形成DataDto，然后加入List<DataDto>中
	 * 
	 * @param singleRecord
	 */
	@Deprecated
	private static void addDataToAddressList(String singleRecord) {
		System.out.println(singleRecord);
		JSONObject obj = JSONObject.parseObject(singleRecord);
		if ("cabia_company".equals(obj.getJSONObject("schema").getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));

			String addressName = (String) object.get("company_name");
			String sourceAddress = (String) object.get("location");
			String industry = (String) object.get("industry");
			System.out.println(numbKafka++ + "address " + addressList.size());
			addressList.add(new DataReqDto(
					new CompanyReqDto(addressName, DataSourceEnums.PC_COMPANY, sourceAddress, industry)));
		} else if ("cabia_building".equals(obj.getJSONObject("schema").getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));

			String addressName = (String) object.get("building_name");
			String sourceAddress = (String) object.get("location");

			System.out.println(numbKafka++ + "address " + addressList.size());
			addressList
					.add(new DataReqDto(new BuildingReqDto(addressName, DataSourceEnums.PC_BUILDING, sourceAddress)));
		}
	}
}
