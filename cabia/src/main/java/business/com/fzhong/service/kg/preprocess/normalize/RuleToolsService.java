package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.enums.CountyTypeEnums;
import business.com.fzhong.service.kg.enums.DoorplateCombinationEnums;
import business.com.fzhong.service.kg.enums.RoadTypeEnums;
import business.com.fzhong.service.kg.enums.UptownTypeEnums;

/**
 * 标准化规则时使用到的一些处理函数
 * @author Revan
 *
 */
public class RuleToolsService {

	/**
	 * 将地址分块，确定路（级别）的类型和弄或号的值
	 * @param addr 地址信息
	 */
	public static void setDcFirstAndRodeType(AddressReqDto addr){
		Pattern pattern = Pattern.compile(NormalizeService.CORRECT_ADDRESS);
	   	Matcher matcher = pattern.matcher(addr.getAddress());
	   	if(matcher.find()){
	   		addr.setAddressFront(matcher.group(1));
	   		addr.setAddressLatter(matcher.group(5));
	   		addr.setDcFirst(matcher.group(3));
	   		for(RoadTypeEnums roadType : RoadTypeEnums.values()){
	   			if(roadType.getName().equals(matcher.group(2))){
	   				addr.setRoadType(roadType);
	   			}
	   		}
	   		for(UptownTypeEnums uptownType : UptownTypeEnums.values()){
	   			if(uptownType.getName().equals(matcher.group(2))){
	   				addr.setUptownType(uptownType);
	   			}
	   		}
	   		for(DoorplateCombinationEnums dcType : DoorplateCombinationEnums.values()){
	   			if(dcType.getName().equals(matcher.group(4))){
	   				addr.setDcType(dcType);
	   			}
	   		}
	   	}
	}

	/**
	 * 获取支弄或号的值
	 * @param addr 地址信息
	 */
	public static void setDcSecondAndDcType(AddressReqDto addr){
		Pattern patternZN = Pattern.compile("(^[\\d~]+)支弄(.*)");
		Pattern patternH = Pattern.compile("(^[\\d~]+)号(.*)");
		Pattern patternHL = Pattern.compile("^\\d+号楼");
		Matcher matcher = patternZN.matcher(addr.getAddressLatter());
		if(matcher.find()){
			addr.setDcSecond(matcher.group(1));
			addr.setDcType(DoorplateCombinationEnums.NONG_ZHINONG);
			addr.setAddressLatter(matcher.group(2));
		}else{
			matcher = patternHL.matcher(addr.getAddressLatter());
			if(!matcher.find()){
				matcher = patternH.matcher(addr.getAddressLatter());
				if(matcher.find()){
					addr.setDcSecond(matcher.group(1));
					addr.setDcType(DoorplateCombinationEnums.NONG_HAO);
					addr.setAddressLatter(matcher.group(2));
				}
			}
	   	}
	}
	
	/**
	 * 避免将号楼判断为号
	 * @param addr 地址信息
	 */
	public static void checkDcTypeHao(AddressReqDto addr){
		Pattern pattern = Pattern.compile("^楼");
		Matcher matcher = pattern.matcher(addr.getAddressLatter());
		if(matcher.find()){
			addr.setCorrectAddress(false);
		}
	}
	
	/**
	 * 获取市
	 * @param addr 地址信息
	 */
	public static void getCity(AddressReqDto addr){
		addr.setCity("上海市");
		Pattern pattern = Pattern.compile("^上海市(.+)");
		Matcher matcher = pattern.matcher(addr.getAddressFront());
		if(matcher.find()){
			addr.setAddressFront(matcher.group(1));
		}else{
			pattern = Pattern.compile("^上海(.+)");
			matcher = pattern.matcher(addr.getAddressFront());
			if(matcher.find()){
				addr.setAddressFront(matcher.group(1));
			}
		}
	}
	
	/**
	 * 获取区和路(级别)
	 * @param addr 地址信息
	 */
	public static void getCountyAndRoadOrUptown(AddressReqDto addr){
		Pattern pattern = Pattern.compile("^浦东(.+)");
		Matcher matcher = pattern.matcher(addr.getAddressFront());
		if(matcher.find()){
			addr.setCountyName("浦东");
			addr.setCountyType(CountyTypeEnums.XIN_QU);
			addr.setAddressFront(matcher.group(1));
			pattern = Pattern.compile("^新区(.+)");
			matcher = pattern.matcher(addr.getAddressFront());
			if(matcher.find()){
				addr.setAddressFront(matcher.group(1));
			}else{
				pattern = Pattern.compile("^区(.+)");
				matcher = pattern.matcher(addr.getAddressFront());
				if(matcher.find()){
					addr.setAddressFront(matcher.group(1));
				}
			}
		}
		
		String[] countys = new String[]{"黄埔","徐汇","长宁","静安","普陀","虹口","杨浦","闵行","宝山","嘉定","金山","松江","青浦","奉贤","卢湾","闸北","黄浦"};
		for(int i = 0; i < countys.length; i++){
			pattern = Pattern.compile("^"+countys[i]+"(.+)");
			matcher = pattern.matcher(addr.getAddressFront());
			if(matcher.find()){
				addr.setCountyName(countys[i]);
				addr.setCountyType(CountyTypeEnums.QU);
				addr.setAddressFront(matcher.group(1));
				pattern = Pattern.compile("^区(.+)");
				matcher = pattern.matcher(addr.getAddressFront());
				if(matcher.find()){
					addr.setAddressFront(matcher.group(1));
				}
			}
		}

		pattern = Pattern.compile("^崇民(.+)");
		matcher = pattern.matcher(addr.getAddressFront());
		if(matcher.find()){
			addr.setCountyName("崇民县");
			addr.setCountyType(CountyTypeEnums.XIAN);
			addr.setAddressFront(matcher.group(1));
			pattern = Pattern.compile("^县(.+)");
			matcher = pattern.matcher(addr.getAddressFront());
			if(matcher.find()){
				addr.setAddressFront(matcher.group(1));
			}
		}
		
		if(addr.getRoadType()!=null){
			addr.setRoadName(addr.getAddressFront());
		}
		if(addr.getUptownType()!=null){
			addr.setRoadName(addr.getAddressFront());
		}
		
	}
	
}
