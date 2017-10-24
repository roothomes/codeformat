package com.roothomes.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TUtil {

    /**
     * 获取模型的属性对象集合
     * @param javaCodeCfg java模型里面的属性字段
     * @param descCfg java属性字段里面的注释
     * @param typeCfg java属性的类型
     * @param dbCodeCfg 数据库属性对象的字段
     * @return
     * @author roothomes
     * @date 2017-10-20
     */
    public static List<TAttribute> getModelAttributeList(String javaCodeCfg, String descCfg, String typeCfg, String dbCodeCfg){
        String[] javaCodes = javaCodeCfg.split(IContant.K_SPLIT);
        String[] descs = descCfg.split(IContant.K_SPLIT);
        String[] types = typeCfg.split(IContant.K_SPLIT);
        String[] dbCodes = dbCodeCfg.split(IContant.K_SPLIT);
        List<TAttribute> list = new ArrayList<TAttribute>(javaCodeCfg.length());
        for(int i=0;i<javaCodes.length;i++){
            TAttribute one = new TAttribute();
            one.setDbCode(dbCodes[i]);
            one.setJavaCode(javaCodes[i]);
            one.setDesc(descs[i]);
            one.setType(types[i]);
            list.add(one);
        }
        return list;
    }


    public static List<TAttribute> getBaseModelAttributList(){
        String[] javaCodes = IContant.baseJavaAttributeCode.split(IContant.K_SPLIT);
        String[] descs = IContant.baseJavaAttributeDesc.split(IContant.K_SPLIT);
        String[] types = IContant.baseJavaAttributeType.split(IContant.K_SPLIT);
        String[] dbCodes =  IContant.baseDBColumnCode.split(IContant.K_SPLIT);
        List<TAttribute> list = new ArrayList<TAttribute>(javaCodes.length);
        for(int i=0;i<javaCodes.length;i++){
            TAttribute one = new TAttribute();
            one.setDbCode(dbCodes[i]);
            one.setJavaCode(javaCodes[i]);
            one.setDesc(descs[i]);
            one.setType(types[i]);
            list.add(one);
        }
        return list;
    }

    public static List<TAttribute> getDTOAttributeList(String javaCodeCfg, String descCfg, String typeCfg, String dbCodeCfg){
        String[] javaCodes = javaCodeCfg.split(IContant.K_SPLIT);
        String[] descs = descCfg.split(IContant.K_SPLIT);
        String[] types = typeCfg.split(IContant.K_SPLIT);
        String[] dbCodes = dbCodeCfg.split(IContant.K_SPLIT);
        List<TAttribute> list = new ArrayList<TAttribute>(javaCodeCfg.length());
        for(int i=0;i<javaCodes.length;i++){
            TAttribute one = new TAttribute();
            one.setDbCode(dbCodes[i]);
            one.setJavaCode(javaCodes[i]);
            one.setDesc(descs[i]);
            one.setType(types[i]);
            list.add(one);
        }
        List<TAttribute> baseList =  getBaseModelAttributList();
        for (TAttribute one:baseList){
            list.add(one);
        }
        return list;
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

    private static String getBaseImportPackages(String type){
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
        }else if("EnableFlag".equalsIgnoreCase(type)){
            packageName = "import com.apec.framework.common.enumtype.EnableFlag;";
        }
        return packageName;
    }
    public static List<TPackage> getModelClassImportPackages(String modelType){
        String[] types = modelType.split(IContant.K_SPLIT);
        List<TPackage> list = getModelClassBasePackage();
        TPackage one = null;
        Map<String,String> maps = new HashMap<String,String>(types.length);
        for(String type:types){
            String packageName = getBaseImportPackages(type);
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

    public static List<TPackage> getDTOClassBasePackage(){
        List<TPackage> packages = new ArrayList<TPackage>();
        TPackage one = null;
        one = new TPackage();
        one.setImportPackage("import com.apec.framework.dto.BaseDTO;");
        one.setDesc("继承的基础分页类");
        packages.add(one);
        return packages;
    }
    public static List<TPackage> getDTOClassImportPackages(String modelType){
        String[] types = modelType.split(IContant.K_SPLIT);
        List<TPackage> list = getDTOClassBasePackage();
        TPackage one = null;
        Map<String,String> maps = new HashMap<String,String>(types.length);
        for(String type:types){
            String packageName = getBaseImportPackages(type);
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
