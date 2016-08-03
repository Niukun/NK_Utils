package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.BuildingSuffixEnums;

/**
 * 通过启用规则进行地址标准化，并对结果进行进一步处理
 * @author Revan
 *
 */
public class AddrExtractService {

	/**
	 * 信息抽取流程集合
	 * @param dataList 地址信息列表
	 */
	public void extract(List<DataReqDto> dataList){
		//启用规则进行标准化
		new FireRulesService(dataList).fireRules("Normalize.drl");
		//对结果进行进一步处理
		laterprocess(dataList);
	}
	

	/**
	 * 后处理集合
	 * @param dataList 地址信息列表
	 */
	public void laterprocess(List<DataReqDto> dataList){
		Iterator<DataReqDto> dataIter = dataList.iterator();
		while(dataIter.hasNext()){
			DataReqDto data = dataIter.next();
			List<AddressReqDto> addressList = data.getAddress();
			//处理路名包含区名的情况
			roadNameContainCountyName(addressList);
			//处理地址中包含多个区或镇的情况
			multipleCountyORTown(addressList);
			//独立楼宇识别（号楼、栋、幢）
			getWhichBuilding(addressList);
			//从列表中移除不正确地址
			deleteIncorrectAddress(addressList);
			//如果单例中不存在地址，删除此单例
			if(addressList.size() == 0){
				dataIter.remove();
			}
		}
	}
	
	/**
	 * 处理路名包含区名的情况
	 * @param addressList 地址信息列表
	 */
	private void roadNameContainCountyName(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		//路名包含区名的情况为：（区名）X路，X为以下情况。（如：浦东南路）
		List<String> roadDetail = new ArrayList<String>();
		roadDetail.add("东");
		roadDetail.add("西");
		roadDetail.add("南");
		roadDetail.add("北");
		roadDetail.add("中");
		roadDetail.add("支");
		roadDetail.add("大");
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			//若路名包含区名，则路名长度会成为1，如（浦东南路）会处理为（浦东新区）和（南路）
			if(addr.isCorrectAddress()&&addr.getRoadName().length()<2){
				if(roadDetail.contains(addr.getRoadName())&&addr.getCountyName()!=null){
					addr.setRoadName(addr.getCountyName() + addr.getRoadName());
					addr.setCountyName(null);
				}else{
					addr.setCorrectAddress(false);
				}
			}
		}
	}

	/**
	 * 处理地址中包含多个区或镇的情况
	 * @param addressList 地址信息列表
	 */
	private void multipleCountyORTown(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		//若地址包含多个区或镇，则处理后的路名为（XX区XX），目标为删除（XX区）
		Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]{2,}[" + NormalizeService.EXCESS_INFO_SUFFIX + "]([\\u4e00-\\u9fa5]{2,}.*)");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			if(addr.isCorrectAddress()){
				matcher = pattern.matcher(addr.getRoadName());
				if(matcher.find()){
					addr.setRoadName(matcher.group(1));
				}
			}
		}
	}
	
	/**
	 * 识别独立楼宇（号楼、栋幢）
	 * @param addressList 地址信息列表
	 */
	private void getWhichBuilding(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			getBuildingNum(BuildingSuffixEnums.HAOLOU, addr);
			getBuildingNum(BuildingSuffixEnums.DONG, addr);
			getBuildingNum(BuildingSuffixEnums.ZHUANG, addr);
		}
	}
	
	/**
	 * 更加楼宇号码类型取其号码
	 * @param bsType 楼宇号码类型
	 * @param addr 地址
	 */
	private void getBuildingNum(BuildingSuffixEnums bsType, AddressReqDto addr){
		Pattern pattern = Pattern.compile("([一二三四五六七八九十零0-9a-zA-Z]+)" + bsType.getName());
		Matcher matcher;
		matcher = pattern.matcher(" " + addr.getAddressLatter());
		if(matcher.find()){
			addr.setBuildingNum(matcher.group(1));
			addr.setBaType(bsType);
		}
	}
	
	/**
	 * 从列表中删除不正确地址
	 * @param addressList 地址信息列表
	 */
	private void deleteIncorrectAddress(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			if(!addr.isCorrectAddress()){
				addressIter.remove();
			}
		}
	}

}
