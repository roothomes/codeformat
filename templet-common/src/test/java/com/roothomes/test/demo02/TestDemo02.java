package com.roothomes.test.demo02;

import com.roothomes.test.bean.TAnnotation;
import com.roothomes.test.bean.TAttribute;
import com.roothomes.test.bean.TPackage;
import com.roothomes.test.cfg.CfgDemo02;
import com.roothomes.test.cfg.IKey;
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

public class TestDemo02 {

    public static void main(String[] args) throws Exception {

        TestDemo02 instance = new TestDemo02();
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(CfgDemo02.baseDir));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap();
        //设置GroupID项目组织唯一的标识符，用于包结构等
        root.put(IKey.K_GROUPID, CfgDemo02.V_GROUPID);
        /*设置ArtifactID就是项目的唯一的标识符，用于包结构等*/
        root.put(IKey.K_ARTIFACTID, CfgDemo02.V_ARTIFACTID);
        /* 设置表对应Java对象的类型 */
        root.put(IKey.K_PACKAGE,TPackage.getModelClassPackage(CfgDemo02.cfg_type));
        /* 设置注解列表 */
        List<TAnnotation> list = TAnnotation.getTModelClassList();
        TAnnotation  one = new TAnnotation();
        one.setName("@Table(name = \""+CfgDemo02.cfg_dbTableName+"\", catalog = \""+CfgDemo02.cfg_dbName+"\")");
        one.setDesc("JPA表注解");
        list.add(one);
        root.put(IKey.K_ANNOTATION, list);
        /* 设置类名称 */
        root.put(IKey.K_CLASSNAME,CfgDemo02.V_POJO);
        root.put(IKey.K_ATTRIBUTE, TAttribute.getModelAttributeList(CfgDemo02.cfg_javaCode,CfgDemo02.cfg_desc,CfgDemo02.cfg_type,CfgDemo02.cfg_dbCode));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(CfgDemo02.templetFile);

        /* Merge data-model with template */
        FileOutputStream fos = new FileOutputStream(CfgDemo02.getFilePath4Model());
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }



}