package com.roothomes.test.bean;

import com.roothomes.test.cfg.IKey;

import java.util.*;

/**
 * 模型里面model的类，包的部分。
 */
public class TPackage {
    private String importPackage;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public String getImportPackage() {
        return importPackage;
    }

    public void setImportPackage(String importPackage) {
        this.importPackage = importPackage;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static List<TPackage> getModelClassBasePackage(){
        List<TPackage> packages = new ArrayList<TPackage>();
        TPackage one = null;
        one = new TPackage();
        one.setImportPackage("import javax.persistence.Column;");
        one.setDesc("JPA列注解");
        packages.add(one);
        one = new TPackage();
        one.setImportPackage("import javax.persistence.Entity;");
        one.setDesc("JPA实体注解");
        packages.add(one);
        one = new TPackage();
        one.setImportPackage("import javax.persistence.Table;");
        one.setDesc("JPA表注解");
        packages.add(one);
        one = new TPackage();
        one.setImportPackage("import org.hibernate.annotations.DynamicUpdate;");
        one.setDesc("hibernate动态更新");
        packages.add(one);

        one = new TPackage();
        one.setImportPackage("import org.hibernate.annotations.GenericGenerator;");
        one.setDesc("hibernate自动生成");
        packages.add(one);

        one = new TPackage();
        one.setImportPackage("import com.apec.framework.common.Constants;");
        one.setDesc("平台常量类");
        packages.add(one);

        one = new TPackage();
        one.setImportPackage("import com.apec.framework.jpa.model.BaseModel;");
        one.setDesc("平台基础模型");
        packages.add(one);
        return packages;
    }

    public static List<TPackage> getModelClassImportPackages(String modelType){
        String[] types = modelType.split(IKey.K_SPLIT);
        List<TPackage> list = getModelClassBasePackage();
        TPackage one = null;
        Map<String,String> maps = new HashMap<String,String>(types.length);
        for(String type:types){
            String packageName = "";
            if("String".equalsIgnoreCase(type)){
                packageName = "import java.lang.String;";
            }else if("Integer".equalsIgnoreCase(type)){
                packageName = "import java.lang.Integer;";
            }else if("Double".equalsIgnoreCase(type)){
                packageName = "import java.lang.Double;";
            }else if("Float".equalsIgnoreCase(type)){
                packageName = "import java.lang.Float;";
            }else if("Date".equalsIgnoreCase(type)){
                packageName = "import java.util.Date;";
            }
            if(maps.containsKey(packageName)){
                continue;
            }
            maps.put(packageName,packageName);

            one = new TPackage();
            one.setImportPackage(packageName);
            list.add(one);
        }
        return list;
    }
}
