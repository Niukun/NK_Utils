package business.com.fzhong.service.kg.preprocess;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.preprocess.dataget.GetAddress;
import business.com.fzhong.service.kg.preprocess.fill.FillNeo4j;
import business.com.fzhong.service.kg.preprocess.normalize.NormalizeService;
/**
 * 集成了读数据，标准化，入图
 * @author Niukun
 *
 */
public class FZhongKG {
	/**
	 * 日志工具
	 */
	private static Logger logger = Logger.getLogger(FZhongKG.class);
	
	/**
	 * 数据从获取到处理到入图总流程
	 * @param args
	 */
	public static void main(String[] args){
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("Get data form Kafka and Map...");
		List<DataReqDto> dataList = new GetAddress().getAddress();
		logger.info("Raw data Normalize...");
		new NormalizeService().normalize(dataList);
		logger.info("Fill in Neo4j...");
		new FillNeo4j().fillNeo4j(dataList);
		logger.info("END...");
	}

}
