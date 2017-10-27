package com.roothomes.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

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


    public static void buildJavaFile4BaseModel(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_basemodel;
         /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
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
        List<TempletPackage> listPackage = TempletUtil.getModelClassImportPackages(param.getCfgJavaAttributeType());
        TempletPackage packae = new TempletPackage();
        packae.setImportPackage("import " + packageMap.get(DirEnum.p_basemodel) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_basemodel) + ";");
        packae.setDesc("模型的基础继承类");
        listPackage.add(packae);
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));

        /* 设置注解列表 */
        List<TempletAnnotation> list = TempletAnnotation.getTModelClassList();
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
        root.put(IContant.K_PACKAGES, TempletUtil.getDTOClassImportPackages(IContant.BASE_JAVA_ATTRIBUTE_TYPE));
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
        root.put(IContant.K_PACKAGES, TempletUtil.getDTOClassImportPackages(IContant.BASE_JAVA_ATTRIBUTE_TYPE));
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
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Service接口类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义");
        List<TempletPackage> listPackage = new ArrayList<TempletPackage>(4);
        TempletPackage one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_model) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_model));
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_dto) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_dto));
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_vo) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_vo));
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.PageDTO");
        listPackage.add(one);

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



    public static void buildJavaFile4ServiceImpl(Cfg param,Configuration cfg,Map root,Map<DirEnum,String> packageMap,Map<DirEnum,String> fileMap)throws Exception{
        DirEnum fileType = DirEnum.p_serviceimpl;
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务模型Service实现类,里面包含新增、删除、单个查询、模糊查询、分页查询的基础方法的定义");
        List<TempletPackage> listPackage = PackageUtil.getBaseImportPackageList(packageMap,fileMap);
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
        one.setImportPackage("com.apec.framework.cache.CacheService");
        one.setDesc("缓存类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.PageDTO");
        one.setDesc("分页模型类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.enumtype.EnableFlag");
        one.setDesc("逻辑删除的枚举");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.util.BeanUtil");
        one.setDesc("Bean的常用方法");
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
        /* 生成类文件的注释中的描述信息 */
        root.put(IContant.K_CLASSNAME_DESC,"业务启动类");
        List<TempletPackage> listPackage = new ArrayList<TempletPackage>(3);
        TempletPackage one = new TempletPackage();
        one.setImportPackage("com.apec.framework.base.BaseApplication");
        one.setDesc("springboot架构中基础应用类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.common.enumtype.RoutingKey");
        one.setDesc("springboot架构中消息队列注册类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage("com.apec.framework.springcloud.SpringCloudConfig");
        one.setDesc("spring云配置文件类");
        listPackage.add(one);

         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,listPackage);
        // 设置类名称
        root.put(IContant.K_CLASSNAME,DirUtil.getJavaClassName(fileMap,fileType));
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
        root.put(IContant.K_PACKAGE, packageMap.get(fileType));/* 生成类文件的注释中的描述信息 */

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_KEYGEN);
        FileOutputStream fos = new FileOutputStream(fileMap.get(fileType));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
    }

    public static void main(String[] args) throws Exception {

        Cfg param = new Cfg();
        Map<DirEnum,String> packageMap = PackageUtil.generatePackages(
                SystemEnum.spring_boots,param.getCfgGroupId() +"." + param.getCfgArtifactId());
        Map<DirEnum,String> fileMap = DirUtil.getFilePathMap(SystemEnum.spring_boots,param);

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(IContant.V_TEMPLET_BASEDIR));
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
        root.put(IContant.K_PK_ID_TYPE,param.getCfgJavaPkIdType());

        buildJavaFile4BaseModel(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Model(param,cfg,root,packageMap,fileMap);
        buildJavaFile4DTO(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Vo(param,cfg,root,packageMap,fileMap);
        buildJavaFile4DAO(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Contant(param,cfg,root,packageMap,fileMap);
        buildJavaFile4SnowFlakeKeyGen(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Util(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Service(param,cfg,root,packageMap,fileMap);
        buildJavaFile4ServiceImpl(param,cfg,root,packageMap,fileMap);
        buildJavaFile4Application(param,cfg,root,packageMap,fileMap);

    }
}
