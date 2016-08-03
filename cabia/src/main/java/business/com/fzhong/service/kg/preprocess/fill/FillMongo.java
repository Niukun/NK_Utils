package business.com.fzhong.service.kg.preprocess.fill;

import java.util.List;

import base.com.fzhong.service.db.mongo.IBaseMongo;
import base.com.fzhong.service.db.mongo.impl.BaseMongoImpl;
import business.com.fzhong.service.kg.dto.req.DataReqDto;

public class FillMongo {

	public void fillMongo(List<DataReqDto> list) {
		IBaseMongo base = new BaseMongoImpl();
		base.addCollectionData(list);
	}
}
