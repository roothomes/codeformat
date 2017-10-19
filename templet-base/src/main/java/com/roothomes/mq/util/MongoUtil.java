package com.roothomes.mq.util;
//package com.apec.erp.util;
//
//import java.util.Date;
//import java.util.Map;
//
//import org.bson.Document;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.mongodb.BasicDBObject;
//import com.mongodb.Block;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientOptions;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoIterable;
//import com.mongodb.client.result.UpdateResult;
//
//@Service
//public class MongoUtil {
//
//	private static final org.slf4j.Logger _log = LoggerFactory.getLogger(MongoUtil.class);
//	
//	@Value("${mongodb.host}")
//	private String host;
//	@Value("${mongodb.port}")
//	private String port;
//	@Value("${mongodb.user}")
//	private String user;
//	@Value("${mongodb.password}")
//	private String password;
//	@Value("${mongodb.dbname}")
//	private String dbname;
//	
//	private String erplog = "erplog";
//	
//	public MongoClient getMongoClient() {
//		try {
//			ServerAddress server = new ServerAddress(host, Integer.parseInt(port));
//			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
//			build.connectionsPerHost(50); // 与目标数据库能够建立的最大connection数量为50
//			build.heartbeatConnectTimeout(1000);
//			build.threadsAllowedToBlockForConnectionMultiplier(50); // 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
//			/*
//			 * 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
//			 * 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
//			 * 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
//			 */
//			build.maxWaitTime(1000 * 60 * 2);
//			build.connectTimeout(1000 * 60 * 1); // 与数据库建立连接的timeout设置为1分钟
//
//			MongoClientOptions options = build.build();
//			// 数据库连接实例
//			MongoClient mongoClient = new MongoClient(server, options);
//			return mongoClient;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public boolean insertERPLog(JSONObject jsonObject) {
//		MongoClient mongoClient = getMongoClient();
//		if(null != mongoClient){
//			try{
//				MongoIterable<String> iter = mongoClient.getDatabase(dbname).listCollectionNames();
//				iter.forEach(new Block<String>() {
//					public void apply(final String str) {
//						_log.debug("collection:{}",str);
//					}
//				});
//				MongoCollection<Document> collection = mongoClient.getDatabase(dbname).getCollection(erplog);
//				Document doc = new Document();
//				doc.putAll((Map)jsonObject);
//				collection.insertOne(doc);
//				System.out.println(JSON.toJSONString(doc));
//				findErpLog(jsonObject.getString("id"));
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				mongoClient.close();
//			}
//		}else{
//			_log.debug("获取mongodb的数据库连接失败。");
//		}
//		
//		return true;
//	}
//
//
//	public void findErpLog(String id) {
//		MongoClient mongoClient = getMongoClient();
//		if(null != mongoClient){
//			try{
//				MongoCollection<Document> collection =  mongoClient.getDatabase(dbname).getCollection(erplog);
//				long size = collection.count();
//				_log.debug("{}共有{}条数据",erplog,size);
//				BasicDBObject queryObj = new BasicDBObject(); // 构建查询条件
//				queryObj.put("id", id);
//				FindIterable<Document> iter = collection.find(queryObj);
//				iter.forEach(new Block<Document>() {
//					public void apply(final Document document) {
//						_log.debug(JSON.toJSONString(document));
//					}
//				});
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				mongoClient.close();
//			}
//		}else{
//			_log.debug("获取mongodb的数据库连接失败。");
//		}
//	}
//	
//	public void updateErpLog(String id,String result){
//		_log.debug("更新mongodb数据id={}",id);
//		MongoClient mongoClient = getMongoClient();
//		if(null != mongoClient){
//			try{
//				MongoCollection<Document> collection = mongoClient.getDatabase(dbname).getCollection(erplog);
//				long size = collection.count();
//				_log.debug("{}共有{}条数据",erplog,size);
//				BasicDBObject queryObj = new BasicDBObject(); // 构建查询条件 
//				queryObj.put("id", id);
//				FindIterable<Document> iter = collection.find(queryObj);
//				iter.forEach(new Block<Document>() {
//					public void apply(final Document document) {
//						JSONObject jsonRS =JSON.parseObject(result);
//						document.append("result", jsonRS);
//						document.append("responseTime", new Date());
//						_log.debug(JSON.toJSONString(document));
//						UpdateResult ur = collection.replaceOne(queryObj, document);
//						_log.debug("更新mongodb数据：{}",JSON.toJSONString(ur));
//					}
//				});
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				mongoClient.close();
//			}
//		}else{
//			_log.debug("获取mongodb的数据库连接失败。");
//		}
//		
//	}
//
//}
