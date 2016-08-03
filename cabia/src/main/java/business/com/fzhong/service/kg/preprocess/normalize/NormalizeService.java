package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.List;

import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.utils.XmlReader;

/**
 * 地址标准化的全过程
 * @author Revan
 *
 */
public class NormalizeService {
	
	/**
	 * 地址的标准化分为三部分
	 * 1.将地址都处理为单地址形式
	 * 2.抽取地址中的各类信息
	 * 3.通过地图补全地址中信息
	 * @param dataList
	 * @throws Exception
	 */
	public void normalize(List<DataReqDto> dataList){
		//将多地址处理为单地址，解决地址中的不规范字符
		new AddrPreprocessService().preprocess(dataList);
		//抽取地址中的各类信息
		new AddrExtractService().extract(dataList);
		//地址补全，包括经纬度，区名等
		new AddrCompleteService().complete(dataList);
	}
	
	/**
	 * 正确地址的最小长度
	 */
	public static int ADDRESS_MIN_LENGTH = 5;
	
	public static final String CORRECT_ADDRESS = XmlReader.getNormRegex("CorrectAddress");
	
	public static final String TO_CHAR_SET = XmlReader.getNormRegex("ToCharSet");
	
	public static final String SPLIT_CHAR_SET = XmlReader.getNormRegex("SplitCharSet");
	
	public static final String USEFUL_CHAR = XmlReader.getNormRegex("UsefulChar");
	
	public static final String NUM_SUFFIX = XmlReader.getNormRegex("NumSuffix");
	
	public static final String EXCESS_INFO_SUFFIX = XmlReader.getNormRegex("ExcessInfoSuffix");

}
