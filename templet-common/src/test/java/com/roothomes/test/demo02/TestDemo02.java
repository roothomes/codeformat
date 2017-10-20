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
import java.util.HashMap;
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
        root.put(IKey.K_GROUPID, CfgDemo02.V_GROUPID);
        root.put(IKey.K_ARTIFACTID, CfgDemo02.V_ARTIFACTID);
        root.put(IKey.K_PACKAGE,TPackage.getModelClassPackage(CfgDemo02.cfg_type));
        root.put(IKey.K_ANNOTATION, TAnnotation.getTModelClassList());
        root.put(IKey.K_POJO,CfgDemo02.V_POJO);
        root.put(IKey.K_ATTRIBUTE, TAttribute.getModelAttributeList(CfgDemo02.cfg_javaCode,CfgDemo02.cfg_desc,CfgDemo02.cfg_type,CfgDemo02.cfg_dbCode));

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(CfgDemo02.templetFile);

        /* Merge data-model with template */
        FileOutputStream fos = new FileOutputStream(CfgDemo02.outputFile);
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }



}