package com.roothomes.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 能为空值
 * @author shangxw
 * @date 2018-08-22
 */
public enum EnumCanNull {
    NO("0", "否")
    , YES("1", "是")
    ;

    private EnumCanNull(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }

    public static Map<String, String> getAllEnums() {
        Map<String, String> map = new HashMap<String, String>();
        for (EnumCanNull item : EnumCanNull.values()) {
            map.put(item.getCode(), item.getName());
        }
        return map;
    }

    public static EnumCanNull getByCode(String code) {
        for (EnumCanNull item : EnumCanNull.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public static String getByValue(String value) {
        for (EnumCanNull item : EnumCanNull.values()) {
            if (item.getName().equals(value)) {
                return item.getCode();
            }
        }
        return null;
    }

}
