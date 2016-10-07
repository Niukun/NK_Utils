package com.niukun.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnectMongodb {

	public static void main(String[] args) {
		 try{   
		       // 连接到 mongodb 服务
		         MongoClient mongoClient = new MongoClient( "192.168.1.13" , 27017 );
		       
		         // 连接到数据库
		         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
		       System.out.println("Connect to database successfully");
		        
		      }catch(Exception e){
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     }

	}

}
