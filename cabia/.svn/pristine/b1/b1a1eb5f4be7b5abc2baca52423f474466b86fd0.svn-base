package business.com.fzhong.service.kg.preprocess.fill;

import java.util.List;

import business.com.fzhong.service.kg.dao.GraphDao;
import business.com.fzhong.service.kg.dto.req.DataReqDto;

public class FillNeo4j {

	public void fillNeo4j(List<DataReqDto> list){
		GraphDao graphDao = new GraphDao();
		graphDao.addNodeAndRelationship(list);
	}
}
