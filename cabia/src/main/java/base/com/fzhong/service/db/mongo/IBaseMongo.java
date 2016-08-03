package base.com.fzhong.service.db.mongo;

import java.util.List;

import business.com.fzhong.service.kg.dto.req.DataReqDto;

public interface IBaseMongo {

	/**
	 * 添加数据到mongo中
	 * @param list
	 */
	void addCollectionData(List<DataReqDto> list);

	/**
	 * 删除数据集
	 */
	void dropCollection();

	

}
