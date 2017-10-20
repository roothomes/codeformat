package com.roothomes.test.bean;

import com.roothomes.test.cfg.IKey;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性对象
 * @author roothomes
 * @date 2017-10-20
 */
public class TAttribute {
    private String javaCode;
    private String desc;
    private String type;
    private String dbCode;

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDbCode(String dbCode) {
        this.dbCode = dbCode;
    }

    public String getDbCode() {
        return dbCode;
    }

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
    public static List<TAttribute> getModelAttributeList(String javaCodeCfg,String descCfg,String typeCfg,String dbCodeCfg){
        String[] javaCodes = javaCodeCfg.split(IKey.K_SPLIT);
        String[] descs = descCfg.split(IKey.K_SPLIT);
        String[] types = typeCfg.split(IKey.K_SPLIT);
        String[] dbCodes = dbCodeCfg.split(IKey.K_SPLIT);
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
}
