package base.com.fzhong.service.kafka;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.alibaba.fastjson.JSONObject;

import business.com.fzhong.service.kg.dto.req.BuildingReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * 从阿里云kafka中读到的数据,构建一个名为strList的List<String>并返回
 * 
 * @author Niukun
 * 
 */
public class FZhongConsumer {
	private static final String CONFIG_FILE = "kafka_config.properties";// 配置文件
	private static List<DataReqDto> addressList = new ArrayList<DataReqDto>();
	private static List<String> strList = new ArrayList<String>();

	private static Properties props = new Properties();
	private static int numbKafka = 0;

	/**
	 * 调用此方法，返回从kafka中读取的未经处理数据的List
	 * 
	 * @author Niukun
	 * @return
	 */
	public static List<String> getStrList() {
		return strList;
	}

	/**
	 * Kafka 配置，暂时不考虑增加默认值
	 */
	static {
		InputStream in;
		try {
			in = FZhongConsumer.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从kafka读取数据插入strList
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void addRecordToList() {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList("cabia"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {

				System.out.println("Kafka num: " + record.offset());// 打印输出读取条数
				strList.add(record.value());
			}
		}
	}

	/**
	 * 从kafka读取数据保存到：cabia_data.txt
	 * 
	 * @throws IOException
	 */

	@SuppressWarnings({ "unused", "resource" })
	private static void getDataStored() throws IOException {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList("cabia"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("cabia_data.txt"));
		int count = 0;
		while (count++ < 3) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				// System.out.println(record.offset() + "," + record.value());
				// addDataToAddressList(record.value());
				bufw.write(record.value());
				bufw.newLine();
				bufw.flush();
			}
		}
	}

	/**
	 * 对于每条记录，判别其类别并添加到AddressList
	 * 
	 * 此处弃用此方法，应该把下面这个方法集成到数据预处理中
	 * 
	 * @param singleRecord
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static void addDataToAddressList(String singleRecord) {
		JSONObject obj = JSONObject.parseObject(singleRecord);
		if ("cabia_company".equals(obj.getJSONObject("schema").getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));

			String companyName = (String) object.get("company_name");
			String sourceAddress = (String) object.get("location");
			System.out.println(numbKafka++);
			addressList.add(new DataReqDto(new CompanyReqDto(companyName, DataSourceEnums.PC_COMPANY, sourceAddress)));
		} else if ("cabia_building".equals(obj.getJSONObject("schema").getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));

			String buildingName = (String) object.get("building_name");
			String sourceAddress = (String) object.get("location");
			System.out.println(numbKafka++);
			addressList
					.add(new DataReqDto(new BuildingReqDto(buildingName, DataSourceEnums.PC_BUILDING, sourceAddress)));
		}
	}
}
