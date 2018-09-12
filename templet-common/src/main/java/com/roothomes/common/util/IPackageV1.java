package com.roothomes.common.util;

public interface IPackageV1 extends IPackageBase{


    TempletPackage pkgApecBaseController =  new TempletPackage("com.apec.framework.base.BaseController","继承的基础控制类");
    TempletPackage pkgApecPageDTO =  new TempletPackage("com.apec.framework.common.PageDTO","继承的基础分页类");
    TempletPackage pkgApecException =  new TempletPackage("com.apec.framework.common.exception.ApecRuntimeException","封装的业务异常");
    TempletPackage pkgApecPageJSON =  new TempletPackage("com.apec.framework.common.PageJSON","分发器封装form和系统参数的对象");
    TempletPackage pkgApecJsonUtils =  new TempletPackage("com.apec.framework.common.util.JsonUtil","公共json的工具类");


    TempletPackage pkgApecBeanUtils = new TempletPackage("com.apec.framework.common.util.BeanUtil","Bean处理工具类");
    TempletPackage pkgApecBaseDTO = new TempletPackage("com.apec.framework.dto.BaseDTO","继承的基础分页类");
    TempletPackage pkgApecConstants = new TempletPackage("com.apec.framework.common.Constants","框架常量类");
    TempletPackage pkgApecBaseModel = new TempletPackage("com.apec.framework.jpa.model.BaseModel","模型的基础继承类");
    TempletPackage pkgApecBaseDAO = new TempletPackage("com.apec.framework.jpa.dao.BaseDAO","模型DAO需要继承的基础DAO");

    TempletPackage pkgApecCacheService = new TempletPackage("com.apec.framework.cache.CacheService","缓存类");
    /** Bean的常用方法 */
    TempletPackage pkgApecBeanUtil = new TempletPackage("com.apec.framework.common.util.BeanUtil","Bean的常用方法");



    TempletPackage pkgApecSpringCloudConfig = new TempletPackage("com.apec.framework.springcloud.SpringCloudConfig","框架初始化配置");
    TempletPackage pkgApecBaseApplication = new TempletPackage("com.apec.framework.base.BaseApplication","Appliation依赖");
    TempletPackage pkgApecRoutingKey = new TempletPackage("com.apec.framework.common.enumtype.RoutingKey","Appliation继承的RabbitMQ的监听key配置");


    TempletPackage pkgApecSpringUtil = new TempletPackage("com.apec.framework.common.util.SpringUtil","SpringUtil的常用方法");
    TempletPackage pkgApecResultData = new TempletPackage("com.apec.framework.common.ResultData","SpringUtil的常用方法");

}
