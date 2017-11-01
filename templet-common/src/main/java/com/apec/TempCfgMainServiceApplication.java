package com.apec;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


/** springboot架构中基础应用类 */
import com.apec.framework.base.BaseApplication;
/** springboot架构中消息队列注册类 */
import com.apec.framework.common.enumtype.RoutingKey;
/** spring云配置文件类 */
import com.apec.framework.springcloud.SpringCloudConfig;


/**
 * 类 编 号：BL_PU10000_10_application
 * 类 名 称：TempCfgMainServiceApplication
 * 内容摘要：业务启动类
 * @author roothomes
 * @date 2017-10-30
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@Import(value = {SpringCloudConfig.class})
public class TempCfgMainServiceApplication extends BaseApplication{

    public static void main(String[] args) 
    {
    	System.out.println("TempCfgMainServiceApplication start!");
        new SpringApplicationBuilder(TempCfgMainServiceApplication.class).web(true).run(args);
    }
}
