package com.roothomes.common.util;


import java.util.ArrayList;
import java.util.List;

/**
 * 属性对象
 * @author roothomes
 * @date 2017-10-20
 */
public class TempletAttribute {
    private String javaCode;
    private String desc;
    private String type;
    private String dbCode;
    /**
     * Java基础属性是否可以为空（0:不可为空；1:可以为空；）;(12个属性)
     */
    private String canNull;

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
     * Java基础属性是否可以为空（0:不可为空；1:可以为空；）;(12个属性)
     * @return
     */
    public String getCanNull() {
        return canNull;
    }

    /**
     * Java基础属性是否可以为空（0:不可为空；1:可以为空；）;(12个属性)
     * @param canNull
     */
    public void setCanNull(String canNull) {
        this.canNull = canNull;
    }
}
