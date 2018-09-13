package com.roothomes.common.util;

public interface IPackageV2 extends IPackageBase{


    TempletPackage pkgApecController =  new TempletPackage("com.apec.framework.base.BaseController","继承的基础控制类");
    TempletPackage pkgApecPageDTO =  new TempletPackage("com.apec.framework.common.dto.PageDTO","继承的基础分页类");
    TempletPackage pkgApecException =  new TempletPackage("com.apec.framework.common.exception.ApecRuntimeException","封装的业务异常");
    TempletPackage pkgApecPageJSON =  new TempletPackage("com.apec.framework.common.model.PageJSON","分发器封装form和系统参数的对象");
    TempletPackage pkgApecJsonUtils =  new TempletPackage("com.apec.framework.common.util.JsonUtils","公共json的工具类");

    TempletPackage pkgApecBaseDTO = new TempletPackage("com.apec.framework.common.dto.BaseDTO","继承的基础分页类");
    TempletPackage pkgApecFrameConsts = new TempletPackage("com.apec.framework.common.constant.FrameConsts","框架中的常量接口");
    TempletPackage pkgApecBaseDAO = new TempletPackage("com.apec.framework.jpa.dao.BaseDAO","继承的基础DAO");
    TempletPackage pkgSpringBaseModel = new TempletPackage("com.apec.framework.jpa.model.BaseModel","基础依赖的模型");
    TempletPackage pkgHibernateGenericGenerator = new TempletPackage("org.hibernate.annotations.GenericGenerator","hibernate自动生成");

    TempletPackage pkgApecBeanUtils = new TempletPackage("com.apec.framework.common.util.BeanUtils","Bean处理工具类");
    TempletPackage pkgApecIDGenerator = new TempletPackage("com.apec.framework.common.tools.IDGenerator","自动生成Id");

    TempletPackage pkgApecSpringCloudConfig = new TempletPackage("com.apec.framework.springcloud.SpringCloudConfig","框架初始化配置");
    TempletPackage pkgApecBaseApplication = new TempletPackage(" com.apec.framework.base.BaseApplication","Appliation依赖");
    TempletPackage pkgApecResultData =  new TempletPackage("com.apec.framework.common.model.ResultData","框架封装的返回值对象");

    TempletPackage pkgApecCacheService = new TempletPackage("com.apec.cache.base.CacheService","缓存类");

}
