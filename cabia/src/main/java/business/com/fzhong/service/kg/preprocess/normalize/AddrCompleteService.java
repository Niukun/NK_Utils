package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.Iterator;
import java.util.List;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.CountyTypeEnums;
import business.com.fzhong.service.kg.map.MapApiTools;

/**
 * 对地址中不存在但需要的信息通过地图进行补全
 * @author Revan
 *
 */
public class AddrCompleteService {
	
	/**
	 * 地址补全操作全流程
	 * @param dataList 地址信息列表
	 */
	public void complete(List<DataReqDto> dataList){
		//补全区名
		completeCounty(dataList);
	}
	
	/**
	 * 补全区名信息
	 * @param dataList 地址信息列表
	 */
	private void completeCounty(List<DataReqDto> dataList){
		Iterator<DataReqDto> dataIter = dataList.iterator();
		MapApiTools returnCounty = new MapApiTools();
		while(dataIter.hasNext()){
			DataReqDto data = dataIter.next();
			Iterator<AddressReqDto> addressIt = data.getAddress().iterator();
			while(addressIt.hasNext()){
				AddressReqDto add = addressIt.next();
				if(add.isCorrectAddress() && add.getCountyType() == null){
					add.setCountyName(returnCounty.getCounty(add.getAddress()));
					add.setCountyType(CountyTypeEnums.QU);
				}
			}
		}
	}
	
}
