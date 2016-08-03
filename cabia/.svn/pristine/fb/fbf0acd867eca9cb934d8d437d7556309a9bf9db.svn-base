package business.com.fzhong.service.kg.preprocess.dataget;

import java.util.ArrayList;
import java.util.List;

import base.com.fzhong.service.kafka.FZhongConsumer;
import base.com.fzhong.service.kafka.MockFZhongConsumer;
import business.com.fzhong.service.kg.dao.KafkaDao;
import business.com.fzhong.service.kg.dto.req.DataReqDto;

/**
 * 从Kafka和地图中获得地址数据
 * @author Revan
 *
 */
public class GetAddress {

	/**
	 * 地址数据列表
	 */
	public List<DataReqDto> dataList = new ArrayList<DataReqDto>();
	
	/**
	 * 获取待处理的所有地址数据列表
	 * @return
	 */
	public List<DataReqDto> getAddress(){
		getAddressFromKafka();
		getAddressFromMap();
		return dataList;
	}
	
	/**
	 * 从Kafak中读取数据
	 */
	private void getAddressFromKafka(){
		boolean chooseGetSource = false;
		if(chooseGetSource){
			FZhongConsumer.addRecordToList();
			dataList = new KafkaDao().getDataList(FZhongConsumer.getStrList());
		}else{
			MockFZhongConsumer.getLocalStrList();
			dataList = new KafkaDao().getDataList(MockFZhongConsumer.getStrList());
		}
	}

	/**
	 * 从地图中读取数据
	 */
	private void getAddressFromMap(){
		
	}
	
}
