package com.roothomes.common.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型里面model的类，包的部分。
 */
public class TempletPackage {
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

}
