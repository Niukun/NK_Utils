package base.com.fzhong.service.kafka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import business.com.fzhong.service.kg.dto.req.BuildingReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.DataSourceEnums;

public class Kafka_ConsumerTest {
	private static List<DataReqDto> addressList = new ArrayList<DataReqDto>();
	static int i = 0;

	public static void main(String[] args) throws IOException {
		getAddressList();
	}

	private static void getAddressList() throws IOException {
		BufferedReader bufr = new BufferedReader(new FileReader("files/cabia_data.txt"));
		String str = null;
		while ((str = bufr.readLine()) != null) {
			if (str.contains("cabia_company")) {
				System.out.println(str);
				str = str.replaceAll("上海湾211\"", "上海湾211").replaceAll("\"\"", "\"");
				str = str.replaceAll("\\\\", "");
				String substr = str.substring(str.lastIndexOf("object") + 9, str.length() - 3);
				JsonParser parser = new JsonParser();
				JsonObject object = (JsonObject) parser.parse(substr);
				String addressName = object.get("company_name").getAsString();
				String sourceAddress = object.get("location").getAsString();
				System.out.println(i++ + " : " + addressName + "\t" + sourceAddress);
				addressList.add(new DataReqDto(new CompanyReqDto(addressName, DataSourceEnums.PC_COMPANY, sourceAddress)));
			} else if (str.contains("cabia_building")) {
				str = str.replaceAll("\\\\", "");
				String substr = str.substring(str.lastIndexOf("object") + 9, str.length() - 3);
				JsonParser parser = new JsonParser();
				JsonObject object = (JsonObject) parser.parse(substr);
				String addressName = object.get("building_name").getAsString();
				String sourceAddress = object.get("location").getAsString();
				System.out.println(i++ + " : " + addressName + "\t" + sourceAddress);
				addressList.add(new DataReqDto(new BuildingReqDto(addressName, DataSourceEnums.PC_BUILDING, sourceAddress)));
			}
		}
		bufr.close();
	}
}
