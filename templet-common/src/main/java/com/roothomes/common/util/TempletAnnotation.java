package com.roothomes.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解
 *
 * @author roothomes
 * @date 2017-10-20
 */
public class TempletAnnotation {
    private String name;
    private String desc;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<TempletAnnotation> getTModelClassList() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        TempletAnnotation one = null;
        one = new TempletAnnotation();
        one.setName("@Entity");
        one.setDesc("JPA实体注解");
        list.add(one);
        one = new TempletAnnotation();
        one.setName("@DynamicUpdate");
        one.setDesc("hibernate动态更新");
        list.add(one);
        one = new TempletAnnotation();
        one.setName("@GenericGenerator(name = Constants.SYSTEM_GENERATOR, strategy = Constants.ASSIGNED)");
        one.setDesc("hibernate自动生成");
        list.add(one);
        return list;
    }
}
