package com.roothomes.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.framework.springcloud.SpringCloudClient;

/**
 * 调用其它依赖服务
 * @author roothomes
 */
@Service
public class RpcServiceImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger(RpcServiceImpl.class);
 
	@Autowired
	SpringCloudClient springCloudClient;
	
    String rpcPost(String url,String param)
    {
        long s = System.currentTimeMillis();
        String json = springCloudClient.post(url,param);
        long e = System.currentTimeMillis();
        LOG.debug("rpc success! responseTime:{}ms, url:{}, param:{}, res:{}",e-s,url,param,json);
        return json;
    }
    
    String rpcGet(String url)
    {
        long s = System.currentTimeMillis();
        String json = springCloudClient.get(url);
        long e = System.currentTimeMillis();
        LOG.debug("rpc success! responseTime:{}ms, url:{}, param:{}, res:{}",e-s,url,json);
        return json;
    }
	
}
