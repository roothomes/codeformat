package com.roothomes.mq.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.framework.springcloud.SpringCloudClient;

/**
 * 调用其它依赖服务
 */
@Service
public class RpcServiceImpl {
	
	private static final org.slf4j.Logger _log = LoggerFactory.getLogger(RpcServiceImpl.class);
 
	@Autowired
	SpringCloudClient springCloudClient;
	
    String rpcPost(String url,String param)
    {
        long s = System.currentTimeMillis();
        String json = springCloudClient.post(url,param);
        long e = System.currentTimeMillis();
        _log.debug("rpc success! responseTime:{}ms, url:{}, param:{}, res:{}",e-s,url,param,json);
        return json;
    }
    
    String rpcGet(String url)
    {
        long s = System.currentTimeMillis();
        String json = springCloudClient.get(url);
        long e = System.currentTimeMillis();
        _log.debug("rpc success! responseTime:{}ms, url:{}, param:{}, res:{}",e-s,url,json);
        return json;
    }
	
}
