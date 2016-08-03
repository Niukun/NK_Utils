package business.com.fzhong.service.kg.preprocess.normalize;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * AddrPreprocessService的测试类
 * @author Revan
 *
 */
public class AddrPreprocessServiceTest {

	/**
	 * 待测试类
	 */
	public static AddrPreprocessService addrPreprocess = new AddrPreprocessService();
	/**
	 * 函数的输入
	 */
	public List<DataReqDto> dataList;
	/**
	 * 用于生成输入的源地址列表
	 */
	public String[] sourceAddrs = {
			"上海市梅陇路130~132号",
			"上海市梅陇路130-133号",
			"上海市梅陇路130－134号",
			"上海市梅陇路130—135号",
			"上海市梅陇路1、2号",
			"上海市梅陇路3，4号",
			"上海市梅陇路5/6号",
			"上海市梅陇路7.8号"
	};
	/**
	 * 源地址类别对应的期望处理结果
	 */
	public String[] correctResults = {
			"上海市梅陇路130~132号",
			"上海市梅陇路130~133号",
			"上海市梅陇路130~134号",
			"上海市梅陇路130~135号",
			"上海市梅陇路1号",
			"上海市梅陇路2号",
			"上海市梅陇路3号",
			"上海市梅陇路4号",
			"上海市梅陇路5号",
			"上海市梅陇路6号",
			"上海市梅陇路7号",
			"上海市梅陇路8号"
	};
	/**
	 * 实际处理结果
	 */
	public List<String> processResults;
	
	@Before
	public void setUp() throws Exception {
		dataList = new ArrayList<DataReqDto>();
		processResults = new ArrayList<String>();
		createDtoList(sourceAddrs);
	}

	@Test
	public void testPreprocess() {
		addrPreprocess.preprocess(dataList);
		extract();
		if(correctResults.length != processResults.size()){
			for(int i = 0; i < processResults.size(); i++){
				System.out.println(processResults.get(i));
			}
			fail("最终处理结果长度不是期望值！");
		}
		for(int i = 0; i < correctResults.length; i++){
			if(!correctResults[i].equals(processResults.get(i))){
				System.out.println(correctResults[i]);
				System.out.println(processResults.get(i));
				fail("此处处理地址不是期望结果！");
			}
		}
	}

	/**
	 * 根据源地址列表生成函数所需输入
	 * @param sourceAddrs
	 */
	private void createDtoList(String[] sourceAddrs) {
		for(String sourceAddress : sourceAddrs){
			dataList.add(new DataReqDto(new CompanyReqDto("test", DataSourceEnums.PC_COMPANY, sourceAddress)));
		}
	}
	
	/**
	 * 将处理结果中的地址字段抽取出来，用于和期望值比较
	 */
	private void extract(){
		Iterator<DataReqDto> dataIter = dataList.iterator();
		while(dataIter.hasNext()){
			DataReqDto data = dataIter.next();
			Iterator<AddressReqDto> addressIter = data.getAddress().iterator();
			while(addressIter.hasNext()){
				AddressReqDto addr = addressIter.next();
				processResults.add(addr.getAddress());
			}
		}
	}
}
