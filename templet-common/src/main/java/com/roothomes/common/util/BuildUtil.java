package com.roothomes.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildUtil {


    public static void buildJavaFile4Model(Cfg param,Configuration cfg,Map root,String outputfile,String packageName,String className)throws Exception{
         /* 包名称 */
        root.put(IContant.K_PACKAGE, packageName);
         /* 设置类名称 */
        root.put(IContant.K_CLASSNAME,className);
        /* 设置属性 */
        List<TAttribute> listModel = TUtil.getModelAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode());
        root.put(IContant.K_ATTRIBUTE,listModel );
        /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,TUtil.getModelClassImportPackages(param.getCfgJavaAttributeType()));

        /* 设置注解列表 */
        List<TAnnotation> list = TAnnotation.getTModelClassList();
        TAnnotation  one = new TAnnotation();
        one.setName("@Table(name = \""+param.getCfgDBTableName()+"\", catalog = \""+param.getCfgDBName()+"\")");
        one.setDesc("JPA表注解");
        list.add(one);
        root.put(IContant.K_ANNOTATION, list);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_MODEL);

        /* Merge data-model with template */
        FileOutputStream fos = new FileOutputStream(outputfile);
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }

    public static void buildJavaFile4DTO(Cfg param,Configuration cfg,Map root,String outputfile,String packageName,String className)throws Exception{
        /* 包名称 */
        root.put(IContant.K_PACKAGE, packageName);
        /* 设置类名称 */
        root.put(IContant.K_CLASSNAME,className);
        /* 设置属性 */
        List<TAttribute> listDTO = TUtil.getDTOAttributeList(
                param.getCfgJavaAttributeCode(),
                param.getCfgJavaAttributeDesc(),
                param.getCfgJavaAttributeType(),
                param.getCfgDBColumnCode());
        root.put(IContant.K_ATTRIBUTE,listDTO );
         /* 设置导入的包的信息 */
        root.put(IContant.K_PACKAGES,TUtil.getDTOClassImportPackages(IContant.baseJavaAttributeType));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(IContant.V_TEMPLET_FILE_DTO);

        /* Merge data-model with template */
        FileOutputStream fos = new FileOutputStream(outputfile);
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
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
        Map root = new HashMap();
        //设置GroupID项目组织唯一的标识符，用于包结构等
        root.put(IContant.K_GROUPID, param.getCfgGroupId());
        /*设置ArtifactID就是项目的唯一的标识符，用于包结构等*/
        root.put(IContant.K_ARTIFACTID, param.getCfgArtifactId());

        /* 设置类名称 */
        root.put(IContant.K_CLASSNAME,param.getCfgPojoName());
        /* 设置模型的描述信息 */
        root.put(IContant.K_MODELDESC,param.getCfgModelDesc());
        root.put(IContant.K_CREATE_AUTHOR,param.getCfgCreatAuthor());
        root.put(IContant.K_CREAT_DATE,param.getCfgCreatDate());


        buildJavaFile4Model(param,cfg,root,fileMap.get(DirEnum.p_model),packageMap.get(DirEnum.p_model),param.getCfgPojoName());
        buildJavaFile4DTO(param,cfg,root,fileMap.get(DirEnum.p_dto),packageMap.get(DirEnum.p_dto),param.getCfgPojoName()+"DTO");
    }
}
