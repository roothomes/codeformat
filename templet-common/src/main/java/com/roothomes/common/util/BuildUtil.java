package com.roothomes.common.util;

import com.apec.framework.common.util.JsonUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author roothomes
 */
public class BuildUtil {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BuildUtil.class);

    public static void buildJavaFile4BaseModel(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_basemodel;
         /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"基础模型类,里面包含基础模型属性，以及属性的get set方法");
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_BASEMODEL);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }


    public static void buildJavaFile4Model(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_model;
         /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Pojo类,里面包含业务模型的属性，以及该属性的get set方法");
        /* 设置属性 */
        List<TempletAttribute> listModel = TempletUtil.getModelAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode(),
                param.getCfgJavaAttributeCanNull());
        root.put(IContant.K_ATTRIBUTE,listModel );
        /* 设置导入的包的信息 */
        List<TempletPackage> listPackage = TempletPackage.getModelBasePackageV1();
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

        /* 设置注解列表 */
        List<TempletAnnotation> list = TempletAnnotation.getModelAnnotationsV1();
        TempletAnnotation one = new TempletAnnotation();
        one.setName("@Table(name = \""+param.getCfgDBTableName()+"\", catalog = \""+param.getCfgDBName()+"\")");
        one.setDesc("JPA表注解");
        list.add(one);
        root.put(IContant.K_ANNOTATION, list);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_MODEL);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4DTO(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_dto;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Dto类,里面包含业务模型的属性，以及该属性的get set方法");
        /* 设置属性 */
        List<TempletAttribute> listDTO = TempletUtil.getDTOAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode());
        root.put(IContant.K_ATTRIBUTE,listDTO );
         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES, TempletPackage.getDTOBasePackageV1());
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_DTO);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }


    public static void buildJavaFile4Vo(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_vo;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Vo类,里面包含业务模型的属性，以及该属性的get set方法");
        /* 设置属性 */
        List<TempletAttribute> listDTO = TempletUtil.getDTOAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode());
        root.put(IContant.K_ATTRIBUTE,listDTO );
         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES, TempletPackage.getDTOBasePackageV1());
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_VO);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }
    public static void buildJavaFile4DAO(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_dao;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Dao类,里面包含业务模型定制的方法");

        List<TempletPackage> listPackage = new ArrayList<TempletPackage>(1);
        TempletPackage one = new TempletPackage();
        one.setImportPackage("import " + packageMap.get(DirEnum.p_model) + "." +param.getCfgPojoName() + ";");
        listPackage.add(one);

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_DAO);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4Contant(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_contant;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型常量类,包含各种常量信息");
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        root.put(IContant.K_CONTANT_CLASSNAME_DESC,param.getCfgJavaContantDesc().split(IContant.K_SPLIT));
        root.put(IContant.K_CONTANT_CLASSNAME_TYPE,param.getCfgJavaContantType().split(IContant.K_SPLIT));
        root.put(IContant.K_CONTANT_CLASSNAME_CODE,param.getCfgJavaContantCode().split(IContant.K_SPLIT));
        root.put(IContant.K_CONTANT_CLASSNAME_DEFAULT_VAL,param.getCfgJavaContantDefaultVal().split(IContant.K_SPLIT));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_CONTANT);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4Util(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_util;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Util类,里面包含业务常用的方法");
        List<TempletPackage> listPackage = PackageUtil.getBaseImportPackageList(packageMap,fileMap);
        TempletPackage one = null;
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.PageDTO");
        listPackage.add(one);

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);

        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_UTIL);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4Service(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_service;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Service接口类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义");
        List<TempletPackage> listPackage = new ArrayList<>(4);
        TempletPackage one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_model) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_model));
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_dto) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_dto));
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_vo) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_vo));
        listPackage.add(one);
        TempletPackage.getServiceBasePackageV1().stream().forEach(e->{listPackage.add(e);});

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_SERVICE);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    /**
     * 生成基础控制类主方法
     * @param param
     * @param cfg
     * @param root
     * @param packageMap
     * @param fileMap
     * @throws Exception
     */
    public static void buildJavaFile4BaseController(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_basecontroller;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型BaseController类");
        List<TempletPackage> listPackage = PackageUtil.getBaseImportPackageList(packageMap,fileMap);
        TempletPackage.getBaseControllerPackageV1().stream().forEach(e->{listPackage.add(e);});
         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_BASECONTROLLER);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4Controller(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_controller;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型BaseController类");
        List<TempletPackage> listPackage = PackageUtil.getBaseImportPackageList(packageMap,fileMap);
        TempletPackage.getControllerBasePackageV1().stream().forEach(e->{listPackage.add(e);});
        TempletPackage one = null;
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_service) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_service));
        one.setDesc("");
        listPackage.add(one);

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_CONTROLLER);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }



    public static void buildJavaFile4ServiceImpl(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_serviceimpl;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义");
        List<TempletPackage> listPackage = PackageUtil.getBaseImportPackageList(packageMap,fileMap);
        TempletPackage.getServiceImplBasePackageV1().stream().forEach(e->{ listPackage.add(e); });
        TempletPackage one = null;
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_service) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_service));
        one.setDesc("模型服务接口类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_dao) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_dao));
        one.setDesc("模型DAO类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_model) + ".Q" + DirUtil.getJavaClassName(fileMap,DirEnum.p_model));
        one.setDesc("模型DAO类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_keygen) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_keygen));
        one.setDesc("主键序列");
        listPackage.add(one);

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        //设置模型的属性（不包含基础属性）
        List<TempletAttribute> listModel = TempletUtil.getModelAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode(),
                param.getCfgJavaAttributeCanNull());
        root.put(IContant.K_ATTRIBUTE,listModel );

        //单独设置基础属性
        root.put(IContant.K_BASE_ATTRIBUTE, TempletUtil.getBaseModelAttributList());
        root.put(IContant.K_BASE_ATTRIBUTE_CAN_NULL, IContant.BASE_JAVA_ATTRIBUTE_CAN_NULL.split(IContant.K_SPLIT));
        //设置默认的属性值
        root.put(IContant.K_ATTRIBUTE_DEFAULT_VAL,param.getCfgJavaAttributeDefaultVal().split(IContant.K_SPLIT));
        root.put(IContant.K_ATTRIBUTE_CAN_NULL,param.getCfgJavaAttributeCanNull().split(IContant.K_SPLIT));
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_SERVICEIMPL);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4Application(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_application;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务启动类");
        List<TempletPackage> listPackage = TempletPackage.getApplicationBasePackageV1();
         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

         /* 设置注解列表 */
        List<TempletAnnotation> list = TempletAnnotation.getApplicationAnnotationsV1();
        root.put(IContant.K_ANNOTATION, list);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_APPLICATION);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildJavaFile4SnowFlakeKeyGen(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_keygen;
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"主键生成类");

        root.put("workerId","@Value(\"${workerId}\")");
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 获取文件序列号 */
        root.put(IContant.K_CLASS_SERIALNO,PackageUtil.generateClassSerialNo(param).get(fileType));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_KEYGEN);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPomParentFile(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_pom_parent;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_POM_PARENT);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPomFile(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_pom;
        root.put("BUILD_FINALNAME","${project.groupId}.${project.artifactId}-${project.version}");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_POM);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPropApplication(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_prop_application;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_PROP_APPLICATION);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }
    public static void buildPropApplicationDev(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_prop_application_dev;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_PROP_APPLICATION_DEV);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPropApplicationTest(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_prop_application_test;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_PROP_APPLICATION_TEST);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPropApplicationProd(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_prop_application_pord;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_PROP_APPLICATION_PROD);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void buildPropLog4j(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_prop_log4j;
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_PROP_LOG4J);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }


    public static void buildTempletManager(String[] args) throws Exception {
        Cfg param = getRedisCfg();
        buildAll(param);
        param = getTempCfgMain();
        buildAll(param);
        param = getTempCfgAttributes();
        buildAll(param);
        param = getTempCfgContants();
        buildAll(param);
    }

    public static void buildAll(Cfg param)throws Exception {
        LOG.info("cfgInfo:{}" ,JsonUtil.toJSONString(param));
        Map<DirEnum,String> packageMap = PackageUtil.generateJavaPackages(SystemEnum.spring_boots,param);
        Map<DirEnum,String> fileMap = DirUtil.getFilePathMap(SystemEnum.spring_boots,param);
        Map<DirEnum,String> serialNoMap = PackageUtil.generateClassSerialNo(param);
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(param.getCfgTempletBaseDir()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap(10);
        //设置GroupID项目组织唯一的标识符，用于包结构等
        root.put(IContant.K_GROUPID, param.getCfgGroupId());
        /*设置ArtifactID就是项目的唯一的标识符，用于包结构等*/
        root.put(IContant.K_ARTIFACTID, param.getCfgArtifactId());
        root.put(IContant.K_VERSION,param.getCfgVersion());
        /*模型依赖的父工程的Pom的相关配置*/
        root.put(IContant.K_PARENT_POM_ARTIFACTID,param.getCfgParentPomArtifactId());
        root.put(IContant.K_PARENT_POM_GROUPID,param.getCfgParentPomGroupId());
        root.put(IContant.K_PARENT_POM_VERSION,param.getCfgParentPomVersion());
        root.put(IContant.K_PARENT_POM_RELATIVEPATH,param.getCfgParentPomRelativePath());

        /* 设置类名称 */
        root.put(IContant.K_CLASSNAME,param.getCfgPojoName());
        /* 设置模型的描述信息 */
        root.put(IContant.K_MODELDESC,param.getCfgModelDesc());
        root.put(IContant.K_CREAT_AUTHOR,param.getCfgCreatAuthor());
        root.put(IContant.K_CREAT_DATE,param.getCfgCreatDate());
        /* 设置模型属性名称 */
        root.put(IContant.K_MODEL_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_model));
        root.put(IContant.K_DTO_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_dto));
        root.put(IContant.K_VO_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_vo));
        root.put(IContant.K_DAO_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_dao));
        root.put(IContant.K_SERVICE_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_service));
        root.put(IContant.K_CONTANT_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_contant));
        root.put(IContant.K_UTIL_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_util));
        root.put(IContant.K_BASECONTROLLER_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_basecontroller));
        root.put(IContant.K_CONTROLLER_CLASSNAME,DirUtil.getJavaClassName(fileMap,DirEnum.p_controller));
        root.put(IContant.K_PK_ID_TYPE,param.getCfgJavaPkIdType());

        root.put("cfgLoggingLevelComApec","${logging.level.com.apec}");
        root.put("cfgDevJdbcUrl",param.getCfgDevJdbcUrl());
        root.put("cfgDevJdbcUserName",param.getCfgDevJdbcUserName());
        root.put("cfgDevJdbcUserPwd",param.getCfgDevJdbcUserPwd());
        root.put("cfgDevEurekaIp",param.getCfgDevEurekaIp());
        root.put("cfgDevEurekaPort",param.getCfgDevEurekaPort());
        root.put("cfgDevEurekaInstanceHostname",param.getCfgDevEurekaInstanceHostname());


        root.put("cfgServerPort",param.getCfgServerPort());
        root.put("cfgWorkerId",param.getCfgWorkerId());
        root.put("cfgEurekaClientServiceUrlDefaultZone",param.getCfgEurekaClientServiceUrlDefaultZone());
        root.put("cfgEurekaInstanceInstanceId",param.getCfgEurekaInstanceInstanceId());


        buildPomParentFile(param,cfg,root,packageMap,fileMap);
        buildPomFile(param,cfg,root,packageMap,fileMap);
//        buildJavaFile4BaseModel(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Model(param,cfg,root,packageMap,fileMap);
        buildJavaFile4DTO(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Vo(param,cfg,root,packageMap,fileMap);
        buildJavaFile4DAO(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Contant(param,cfg,root,packageMap,fileMap);
        buildJavaFile4SnowFlakeKeyGen(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Util(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Service(param,cfg,root,packageMap,fileMap);
        buildJavaFile4ServiceImpl(param,cfg,root,packageMap,fileMap);
        buildJavaFile4BaseController(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Controller(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Application(param,cfg,root,packageMap,fileMap);

        buildPropApplication(param,cfg,root,packageMap,fileMap);
        buildPropApplicationTest(param,cfg,root,packageMap,fileMap);
        buildPropApplicationDev(param,cfg,root,packageMap,fileMap);
        buildPropApplicationProd(param,cfg,root,packageMap,fileMap);
        buildPropLog4j(param,cfg,root,packageMap,fileMap);
    }

    /**
     * 配置缓存表的数据
     * @return
     */
    public static Cfg getRedisCfg(){
        Cfg param = new Cfg();
        /** 项目的唯一的标识符 */
        param.setCfgArtifactId("tempcfgredis");
        /** POJO中模型类的名称 */
        param.setCfgPojoName("TempCfgRedis");
        param.setCfgSerialNo("BL_PU10000_10");
        /** 数据库表名称 */
        param.setCfgDBTableName("temp_cfg_redis");
        /** 数据库名称 */
        param.setCfgDBName("cncsen");
        /** 模型的描述 */
        param.setCfgModelDesc("模板生成记录之Redis配置信息");
        param.setCfgJavaAttributeDesc("缓存类型|IP地址|端口|口令|索引");
        /**
         * 数据库字段名称
         * */
        param.setCfgDBColumnCode("REDIS_TYPE|REDIS_IP|REDIS_PORT|REDIS_PASSWORD|REDIS_INDEX");
        /**
         * Java属性类型(支持基本数据类型)
         * */
        param.setCfgJavaAttributeType("String|String|String|String|String");
        /**
         * Java POJO模型类中属性的名称;
         */
        param.setCfgJavaAttributeCode("redisType|redisIp|redisPort|redisPassword|redisIndex");
        /**
         * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
         */
        param.setCfgJavaAttributeCanNull("0|0|0|0|0");
        /**
         * 设置属性的默认值
         */
        param.setCfgJavaAttributeDefaultVal(
                "DEFAULT_VAL_REDIS_TYPE_SINGLETON|" +
                "DEFAULT_VAL_REDIS_IP|" +
                "DEFAULT_VAL_REDIS_PORT|" +
                "DEFAULT_VAL_REDIS_PASSWORD|" +
                "DEFAULT_VAL_REDIS_INDEX"
        );

        param.setCfgJavaContantDesc(
                "redis实例类型(单例:singleton;)|" + "redis实例类型(集群:cluster)|" +
                        "redis配置Ip地址|" +
                "redis的端口号6379|" + "redis的端口号7000|" + "redis的端口号7001|" +"redis的端口号7002|" +"redis的端口号7003|" +"redis的端口号7004|" +"redis的端口号7005|" +
                        "redis密码|" +
                "redis的数据默认索引:0|" + "redis的数据默认索引:1|"  + "redis的数据默认索引:2|" + "redis的数据默认索引:3|" + "redis的数据默认索引:4|" + "redis的数据默认索引:5|" + "redis的数据默认索引:6|" + "redis的数据默认索引:7|" +
                        "缓存Key值前缀"
        );
        /**
         * 配置常量接口里面常量的类型
         */
        param.setCfgJavaContantType(
                "String|" + "String|" +
                "String|" +
                "String|" + "String|" +"String|" +"String|" +"String|" +"String|" +"String|" +
                "String|" +
                "String|" + "String|" + "String|" +"String|" +"String|" +"String|" +"String|" +"String|" +
                "String"
        );

        /**
         * 配置常量接口里面常量的名称
         */
        param.setCfgJavaContantCode(
                "DEFAULT_VAL_REDIS_TYPE_SINGLETON|" + "DEFAULT_VAL_REDIS_TYPE_CLUSTER|" +
                "DEFAULT_VAL_REDIS_IP|" +
                "DEFAULT_VAL_REDIS_PORT|" + "DEFAULT_VAL_REDIS_PORT7000|" + "DEFAULT_VAL_REDIS_PORT7001|" + "DEFAULT_VAL_REDIS_PORT7002|" + "DEFAULT_VAL_REDIS_PORT7003|" + "DEFAULT_VAL_REDIS_PORT7004|" + "DEFAULT_VAL_REDIS_PORT7005|" +
                "DEFAULT_VAL_REDIS_PASSWORD|"  +
                "DEFAULT_VAL_REDIS_INDEX|" + "DEFAULT_VAL_REDIS_INDEX1|" +"DEFAULT_VAL_REDIS_INDEX2|" +"DEFAULT_VAL_REDIS_INDEX3|" +"DEFAULT_VAL_REDIS_INDEX4|" +"DEFAULT_VAL_REDIS_INDEX5|" +"DEFAULT_VAL_REDIS_INDEX6|" +"DEFAULT_VAL_REDIS_INDEX7|" +
                        "CACHE_PREFIX"
        );
        /**
         * 配置常量接口里面常量的默认值
         */
        param.setCfgJavaContantDefaultVal(
                "singleton|" + "cluster|" +
                        "127.0.0.1|" +
                        "6379|" + "7000|" + "7001|" + "7002|" + "7003|" + "7004|" + "7005|" +
                        "foobared|"  +
                        "0|" + "1|" +"2|" +"3|" +"4|" +"5|" +"6|" +"7|" +
                        "Cache_Model_"
        );

        return param;
    }


    /**
     * 模板配置主表
     * @return
     */
    public static Cfg getTempCfgMain(){
        Cfg param = new Cfg();
        /** 项目的唯一的标识符 */
        param.setCfgArtifactId("tempcfgmain");
        /** POJO中模型类的名称 */
        param.setCfgPojoName("TempCfgMain");
        param.setCfgSerialNo("BL_PU10000_10");
        /** 数据库表名称 */
        param.setCfgDBTableName("temp_cfg_main");
        /** 数据库名称 */
        param.setCfgDBName("cncsen");

        /** 模型的描述 */
        param.setCfgModelDesc("模板生成记录之配置主表信息");
        param.setCfgJavaAttributeDesc(
                "组织标示符|业务标示符|模型PoJo的类|模型描述|模型对象序列号|创建作者|创建时间|" +
                        "模型对应表所在数据库|模型对应表|" +
                        "是否启用缓存|是否启用消息"
        );
        /**
         * 数据库字段名称
         * */
        param.setCfgDBColumnCode(
                "GROUPID|ARTIFACTID|MODEL_CLASSNAME|MODEL_CLASSNAME_DESC|MODEL_CLASS_SERIALNO|CREAT_AUTHOR|CREAT_DATETIME|" +
                        "DATABASE_NAME|TABLE_NAME|" +
                        "OPEN_CACHE|OPEN_MQ"
        );
        /**
         * Java属性类型(支持基本数据类型)
         * */
        param.setCfgJavaAttributeType(
                "String|String|String|String|String|String|String|" +
                        "String|String|" +
                        "String|String"
        );
        /**
         * Java POJO模型类中属性的名称;
         */
        param.setCfgJavaAttributeCode(
                "groupId|artifactId|modelClassName|modelClassDesc|modelClassSerialNo|createAuthor|createDateTime|" +
                        "databaseName|tableName|" +
                        "openCache|openMQ"
        );
        /**
         * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
         */
        param.setCfgJavaAttributeCanNull(
                "0|0|0|0|0|0|0|" +
                        "0|0|" +
                        "0|0"
        );
        /**
         * 设置属性的默认值
         */
        param.setCfgJavaAttributeDefaultVal(
                "DEFAULT_VAL_GROUPID|DEFAULT_VAL_ARTIFACTID|DEFAULT_VAL_MODEL_CLASSNAME|DEFAULT_VAL_MODEL_CLASSNAME_DESC|DEFAULT_VAL_MODEL_CLASS_SERIALNO|DEFAULT_VAL_CREAT_AUTHOR|DEFAULT_VAL_CREAT_DATE|" +
                        "DEFAULT_VAL_DATABASE_NAME|DEFAULT_VAL_TABLE_NAME|" +
                        "DEFAULT_VAL_OPEN_CACHE_NO|DEFAULT_VAL_OPEN_MQ_NO"
        );

        param.setCfgJavaContantDesc(
                "组织标示符|业务标示符|模型PoJo的类|模型描述|模型对象序列号|创建作者|创建时间|" +
                        "模型对应表所在数据库|模型对应表|" +
                        "不启用缓存|启用缓存|" +
                        "不启用消息|启用消息|" +
                        "缓存Key值前缀"
        );
        /**
         * 配置常量接口里面常量的类型
         */
        param.setCfgJavaContantType(
                "String|String|String|String|String|String|String|" +
                        "String|String|" +
                        "String|String|" +
                        "String|String|" +
                        "String"
        );

        /**
         * 配置常量接口里面常量的名称
         */
        param.setCfgJavaContantCode(
                "DEFAULT_VAL_GROUPID|DEFAULT_VAL_ARTIFACTID|DEFAULT_VAL_MODEL_CLASSNAME|DEFAULT_VAL_MODEL_CLASSNAME_DESC|DEFAULT_VAL_MODEL_CLASS_SERIALNO|DEFAULT_VAL_CREAT_AUTHOR|DEFAULT_VAL_CREAT_DATE|" +
                        "DEFAULT_VAL_DATABASE_NAME|DEFAULT_VAL_TABLE_NAME|" +
                        "DEFAULT_VAL_OPEN_CACHE_NO|DEFAULT_VAL_OPEN_CACHE_YES|" +
                        "DEFAULT_VAL_OPEN_MQ_NO|DEFAULT_VAL_OPEN_MQ_YES|" +
                        "CACHE_PREFIX"
        );
        /**
         * 配置常量接口里面常量的默认值
         */
        param.setCfgJavaContantDefaultVal(
                "com.apec|default|DefaultClass|默认描述|defaultSerialNo|roothomes|2017-10-31|" +
                        "tempservice|defaulttable|" +
                        "no|yes|" +
                        "no|yes|" +
                        "Cache_Model_"
        );

        return param;
    }


    /**
     * 模板配置属性表
     * @return
     */
    public static Cfg getTempCfgAttributes(){
        Cfg param = new Cfg();
        /** 项目的唯一的标识符 */
        param.setCfgArtifactId("tempcfgattributes");
        /** POJO中模型类的名称 */
        param.setCfgPojoName("TempCfgAttributes");
        param.setCfgSerialNo("BL_PU10000_11");
        /** 数据库表名称 */
        param.setCfgDBTableName("temp_cfg_attributes");
        /** 数据库名称 */
        param.setCfgDBName("cncsen");
        /** 模型的描述 */
        param.setCfgModelDesc("模板生成记录之配置模型属性信息");
        param.setCfgJavaAttributeDesc(
                "主表Id|属性描述|属性JAVA类型|属性数据库字段名称|属性JAVA编码|属性是否可以为空|属性默认值"
        );
        /**
         * 数据库字段名称
         * */
        param.setCfgDBColumnCode(
                "MAIN_ID|ATTRIBUTE_DESC|ATTRIBUTE_JAVA_TYPE|ATTRIBUTE_COLUMN_NAME|ATTRIBUTE_JAVA_CODE|ATTRIBUTE_VAL_CAN_NULL|DEFAULT_VAL"
        );
        /**
         * Java属性类型(支持基本数据类型)
         * */
        param.setCfgJavaAttributeType(
                "String|String|String|String|String|String|String"
        );
        /**
         * Java POJO模型类中属性的名称;
         */
        param.setCfgJavaAttributeCode(
                "mainId|attributeId|attributeJavaType|attributeColumnName|attributeJavaCode|attributeCanNull|defaultVal"
        );
        /**
         * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
         */
        param.setCfgJavaAttributeCanNull(
                "0|0|0|0|0|0|0"
        );
        /**
         * 设置属性的默认值
         */
        param.setCfgJavaAttributeDefaultVal(
                "DEFAULT_VAL_MAIN_ID|" +
                        "DEFAULT_VAL_ATTRIBUTE_DESC|" +
                        "DEFAULT_VAL_ATTRIBUTE_JAVA_TYPE|" +
                        "DEFAULT_VAL_ATTRIBUTE_COLUMN_NAME|" +
                        "DEFAULT_VAL_ATTRIBUTE_JAVA_CODE|" +
                        "DEFAULT_VAL_ATTRIBUTE_VAL_CAN_NULL|" +
                        "DEFAULT_VAL"
        );

        param.setCfgJavaContantDesc(
                "主表Id|属性描述|属性JAVA类型|属性数据库字段名称|属性JAVA编码|属性是否可以为空|属性默认值|缓存前缀"
        );
        /**
         * 配置常量接口里面常量的类型
         */
        param.setCfgJavaContantType(
                "String|String|String|String|String|String|String|String"
        );

        /**
         * 配置常量接口里面常量的名称
         */
        param.setCfgJavaContantCode(
                "DEFAULT_VAL_MAIN_ID|" +
                        "DEFAULT_VAL_ATTRIBUTE_DESC|" +
                        "DEFAULT_VAL_ATTRIBUTE_JAVA_TYPE|" +
                        "DEFAULT_VAL_ATTRIBUTE_COLUMN_NAME|" +
                        "DEFAULT_VAL_ATTRIBUTE_JAVA_CODE|" +
                        "DEFAULT_VAL_ATTRIBUTE_VAL_CAN_NULL|" +
                        "DEFAULT_VAL|" +

                        "CACHE_PREFIX"
        );
        /**
         * 配置常量接口里面常量的默认值
         */
        param.setCfgJavaContantDefaultVal(
                "default|default|default|default|default|default|default|" +
                        "Cache_Model_"
        );

        return param;
    }

    /**
     * 模板配置属性表
     * @return
     */
    public static Cfg getTempCfgContants(){
        Cfg param = new Cfg();
        /** 项目的唯一的标识符 */
        param.setCfgArtifactId("tempcfgcontents");
        /** POJO中模型类的名称 */
        param.setCfgPojoName("CodeTempletContants");
        param.setCfgSerialNo("BL_PU10000_12");
        /** 数据库表名称 */
        param.setCfgDBTableName("temp_cfg_contants");
        /** 数据库名称 */
        param.setCfgDBName("cncsen");
        /** 模型的描述 */
        param.setCfgModelDesc("模板生成记录之配置模型常量信息");
        param.setCfgJavaAttributeDesc(
                "主表Id|常量描述|常量JAVA类型|常量JAVA编码|常量是否可以为空|常量值"
        );
        /**
         * 数据库字段名称
         * */
        param.setCfgDBColumnCode(
                "MAIN_ID|CONTANT_DESC|CONTANT_JAVA_TYPE|CONTANT_JAVA_CODE|CONTANT_VAL_CAN_NULL|CONTANT_VAL"
        );
        /**
         * Java属性类型(支持基本数据类型)
         * */
        param.setCfgJavaAttributeType(
                "String|String|String|String|String|String"
        );
        /**
         * Java POJO模型类中属性的名称;
         */
        param.setCfgJavaAttributeCode(
                "mainId|contantDesc|contantJavaType|contantJavaCode|contantCanNull|contantVal"
        );
        /**
         * 属性新增的是否是否可以为空（0:不可为空；1:可以为空；）
         */
        param.setCfgJavaAttributeCanNull(
                "0|0|0|0|0|0"
        );
        /**
         * 设置属性的默认值
         */
        param.setCfgJavaAttributeDefaultVal(
                "DEFAULT_VAL_MAIN_ID|" +
                        "DEFAULT_VAL_CONTANT_DESC|" +
                        "DEFAULT_VAL_CONTANT_JAVA_TYPE|" +
                        "DEFAULT_VAL_CONTANT_JAVA_CODE|" +
                        "DEFAULT_VAL_CONTANT_VAL_CAN_NULL|" +
                        "DEFAULT_VAL_CONTANT_VAL"
        );

        param.setCfgJavaContantDesc(
                "主表Id|常量描述|常量JAVA类型|常量JAVA编码|常量是否可以为空|常量值|缓存前缀"
        );
        /**
         * 配置常量接口里面常量的类型
         */
        param.setCfgJavaContantType(
                "String|String|String|String|String|String|String"
        );

        /**
         * 配置常量接口里面常量的名称
         */
        param.setCfgJavaContantCode(
                "DEFAULT_VAL_MAIN_ID|" +
                        "DEFAULT_VAL_CONTANT_DESC|" +
                        "DEFAULT_VAL_CONTANT_JAVA_TYPE|" +
                        "DEFAULT_VAL_CONTANT_JAVA_CODE|" +
                        "DEFAULT_VAL_CONTANT_VAL_CAN_NULL|" +
                        "DEFAULT_VAL_CONTANT_VAL|" +

                        "CACHE_PREFIX"
        );
        /**
         * 配置常量接口里面常量的默认值
         */
        param.setCfgJavaContantDefaultVal(
                "default|default|default|default|default|default|" +
                        "Cache_Model_"
        );

        return param;
    }



}
