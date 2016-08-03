package base.com.fzhong.service.db.mongo.impl;

import java.util.Iterator;
import java.util.List;

import base.com.fzhong.service.db.mongo.IBaseMongo;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.dto.req.EntityReqDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * MongoDB数据库
 * @author DingFengwu
 *
 */
public class BaseMongoImpl implements IBaseMongo {


	private static Mongo mongoInstance = null;// 实例化
	private static DB dataSet = null;// 数据集
	private static String collectionName = null;// 集合名称

	/***
	 * 删除数据集
	 */
	public void dropCollection() {

		dataSet.getCollection(collectionName).drop();
	}

	/**
	 * 获取mongodb数据库连接
	 */
	@SuppressWarnings("deprecation")
	public void init() {
		try {
			mongoInstance = new MongoClient(FZhongConsts.DRIVER_MONGO_PARAM, 27017);
		} catch (MongoException e) {
			e.printStackTrace();
		}
		dataSet = mongoInstance.getDB("test");
	}

	/***
	 * 添加数据
	 */
	public void addCollectionData(List<DataReqDto> list) {
		init();
		DBCollection dbCol = dataSet.getCollection(collectionName);
		BasicDBObject doc = new BasicDBObject();
		Iterator<DataReqDto> iter = list.iterator();
		while (iter.hasNext()) {
			DataReqDto data = iter.next();
			EntityReqDto entity = data.getEntity();
			doc.put("sourceAddress", entity.getSourceAddress());
			doc.put("dataSource", entity.getDataSource());
			dbCol.insert(doc);
		}
		closeConnection();
	}

	/**
	 * 关闭mongodb数据库连接
	 */
	public void closeConnection() {
		if (null != mongoInstance) {
			mongoInstance.close();
			dataSet = null;
			mongoInstance = null;
		}
	}

}
