package com.roothomes.common.util;

import java.util.HashMap;
import java.util.Map;

public enum EnumBasicType {

    String ("String" , "字符")
    ,Integer("Integer","整型")
    ,Long("Long","长整型")
    ,Double ("Double" , "双浮点")
    ,Float ("Float" , "浮点")
    ,Date ("Date" , "日期")
    ,Enum ("Enum" , "枚举")
    ;

    private String code;
    private String name;

    private EnumBasicType(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getValue(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private static Map<String, EnumBasicType> pool = new HashMap<>();

    static {
        for (EnumBasicType e : EnumBasicType.values()) {
            pool.put(e.code, e);
        }
    }

    public static Map<String, String> getAllEnums() {
        Map<String, String> m = new HashMap<String, String>();
        for (EnumBasicType e : EnumBasicType.values()) {
            m.put(e.getCode(), e.getName());
        }
        return m;
    }

    public static EnumBasicType getByCode(String code) {
        for (EnumBasicType item : EnumBasicType.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public static String getByValue(String value) {
        for (EnumBasicType item : EnumBasicType.values()) {
            if (item.getName().equals(value)) {
                return item.getCode();
            }
        }
        return null;
    }
}
