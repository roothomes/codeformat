package com.roothomes.common.util;

public interface IPackageBase {
    TempletPackage pkgApecEnableFlag =  new TempletPackage("com.apec.framework.common.enumtype.EnableFlag","是否逻辑删除标识");
    TempletPackage pkgJavaLang =  new TempletPackage("java.lang.*","基础类");
    TempletPackage pkgJavaUtil =  new TempletPackage("java.util.*","基础工具类");

    TempletPackage pkgLogger =  new TempletPackage("org.slf4j.Logger","日志slf4j");
    TempletPackage pkgLoggerFactory =  new TempletPackage("org.slf4j.LoggerFactory","日志slf4j");

    TempletPackage pkgSpringAutowired =  new TempletPackage("org.springframework.beans.factory.annotation.Autowired","@Autowired是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Qualifier使用");
    TempletPackage pkgSpringPageRequest =  new TempletPackage("org.springframework.data.domain.PageRequest","Spring Data Jpa提供分页类(page、size)");
    TempletPackage pkgSpringPage = new TempletPackage("org.springframework.data.domain.Page","spring分页");
    TempletPackage pkgSpringService = new TempletPackage("org.springframework.stereotype.Service","spring服务注解");
    TempletPackage pkgSpringTransactional = new TempletPackage("org.springframework.transaction.annotation.Transactional","spring的事务注解");
    TempletPackage pkgSpringMediaType =  new TempletPackage("org.springframework.http.MediaType","MediaType在网络协议的消息头里面叫做Content-Type,spring 封装的web的常量");
    TempletPackage pkgSpringRequestBody =  new TempletPackage("org.springframework.web.bind.annotation.RequestBody","@RequestBody 注解则是将 HTTP 请求正文插入方法中，使用适合的 HttpMessageConverter 将请求体写入某个对象。");
    TempletPackage pkgSpringRequestMapping =  new TempletPackage("org.springframework.web.bind.annotation.RequestMapping","@RequestMapping 是一个用来处理请求地址映射的注解，可用于类或方法上。");

    TempletPackage pkgSpringRequestMethod =  new TempletPackage("org.springframework.web.bind.annotation.RequestMethod","HTTP请求方法RequestMethod(GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE)");
    TempletPackage pkgSpringRestController =  new TempletPackage("org.springframework.web.bind.annotation.RestController","@RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json");

    TempletPackage pkgLombokData =  new TempletPackage("lombok.Data","编译的时候生成的getset方法");
    TempletPackage pkgLombokAllArgsConstructor =  new TempletPackage("lombok.AllArgsConstructor","编译的时候生成的全属性构造方法");
    TempletPackage pkgLombokNoArgsConstructor =  new TempletPackage("lombok.NoArgsConstructor","编译的时候生成的无参数构造方法");

    TempletPackage pkgJsonFormat = new TempletPackage("com.fasterxml.jackson.annotation.JsonFormat","xml与JSON转换类(主要处理日期)");

    TempletPackage pkgPersistenceEntity = new TempletPackage("javax.persistence.Entity","JPA注解包");
    TempletPackage pkgPersistenceTable = new TempletPackage("javax.persistence.Table","JPA注解包");
    TempletPackage pkgPersistenceColumn = new TempletPackage("javax.persistence.Column","JPA注解包");
    TempletPackage pkgHibernateDynamicUpdate = new TempletPackage("org.hibernate.annotations.DynamicUpdate","JPA注解包");
    TempletPackage pkgHibernateGenericGenerator = new TempletPackage("org.hibernate.annotations.GenericGenerator","JPA注解包");
    TempletPackage pkgQuerydslExpressionUtils = new TempletPackage("com.querydsl.core.types.ExpressionUtils","Querydsl查询");
    TempletPackage pkgMysemaPredicate = new TempletPackage("com.mysema.query.types.Predicate","Querydsl断言");
    TempletPackage pkgMysemaBooleanExpression = new TempletPackage("com.mysema.query.types.expr.BooleanExpression","Querydsl表达式");

    TempletPackage pkgQuerydslPredicate = new TempletPackage("com.querydsl.core.types.Predicate","Querydsl断言");
    TempletPackage pkgQuerydslBooleanExpression = new TempletPackage("com.querydsl.core.types.dsl.BooleanExpression","Querydsl表达式");

    TempletPackage pkgApacheCommonLang = new TempletPackage("org.apache.commons.lang.*","apache组织的common.lang包");

    TempletPackage pkgSpringSort = new TempletPackage("org.springframework.data.domain.Sort","Spring Sort");

    TempletPackage pkgJavaxTransactional = new TempletPackage("javax.transaction.Transactional","Javax的事务注解");

    TempletPackage pkgSpringBootApplication = new TempletPackage("org.springframework.boot.autoconfigure.SpringBootApplication","Application");
    TempletPackage pkgSpringApplicationBuilder = new TempletPackage("org.springframework.boot.builder.SpringApplicationBuilder","创建Application配置类");
    TempletPackage pkgSpringEnableDiscoveryClient = new TempletPackage("org.springframework.cloud.client.discovery.EnableDiscoveryClient","服务发现客户端");
    TempletPackage pkgSpringImport= new TempletPackage("org.springframework.context.annotation.Import","spring上下文导入");
    TempletPackage pkgSpringEnableScheduling = new TempletPackage("org.springframework.scheduling.annotation.EnableScheduling","spring定时任务");










}
