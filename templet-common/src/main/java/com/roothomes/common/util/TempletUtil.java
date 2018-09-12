package com.roothomes.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板常用的工具类
 * @author roothomes
 * @date 2017-10-25
 */
public class TempletUtil {

    /**
     * 获取模型的属性对象集合
     * @param javaCodeCfg java模型里面的属性字段
     * @param descCfg java属性字段里面的注释
     * @param typeCfg java属性的类型
     * @param dbCodeCfg 数据库属性对象的字段
     * @param javaCodeCanNull Java基础属性是否可以为空（0:不可为空；1:可以为空；）如果为空，所有都可为空
     * @return
     * @author roothomes
     * @date 2017-10-20
     */
    public static List<TempletAttribute> getModelAttributeList(String javaCodeCfg, String descCfg, String typeCfg, String dbCodeCfg, String javaCodeCanNull){
        String[] javaCodes = javaCodeCfg.split(IContant.K_SPLIT);
        String[] descs = descCfg.split(IContant.K_SPLIT);
        String[] types = typeCfg.split(IContant.K_SPLIT);
        String[] dbCodes = dbCodeCfg.split(IContant.K_SPLIT);
        String[] canNulls = null;
        if(StringUtils.isNotBlank(javaCodeCanNull)){
            canNulls = javaCodeCanNull.split(IContant.K_SPLIT);
        }

        List<TempletAttribute> list = new ArrayList<TempletAttribute>(javaCodeCfg.length());

        for(int i=0;i<javaCodes.length;i++){
            TempletAttribute one = new TempletAttribute();
            one.setDbCode(dbCodes[i]);
            one.setJavaCode(javaCodes[i]);
            one.setDesc(descs[i]);
            one.setType(types[i]);
            one.setCanNull(canNulls == null ? "1" : canNulls[i]);
            list.add(one);
        }
        return list;
    }

    /**
     * 模型的基础属性列表
     * @return
     */
    public static List<TempletAttribute> getBaseModelAttributList(){
        return getModelAttributeList(
                IContant.BASE_JAVA_ATTRIBUTE_CODE,
                IContant.BASE_JAVA_ATTRIBUTE_DESC,
                IContant.BASE_JAVA_ATTRIBUTE_TYPE,
                IContant.BASE_DB_COLUMN_CODE,
                IContant.BASE_JAVA_ATTRIBUTE_CAN_NULL);
    }

    public static List<TempletAttribute> getDTOAttributeList(String javaCodeCfg, String descCfg, String typeCfg, String dbCodeCfg){
        List<TempletAttribute> list = getModelAttributeList(javaCodeCfg, descCfg, typeCfg, dbCodeCfg,null);
        List<TempletAttribute> baseList =  getBaseModelAttributList();
        baseList.stream().forEach(e->{
            list.add(e);
        });
        return list;
    }


}
