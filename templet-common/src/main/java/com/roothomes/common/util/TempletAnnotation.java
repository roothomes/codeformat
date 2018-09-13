package com.roothomes.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解
 * @author roothomes
 * @date 2017-10-20
 */
public class TempletAnnotation {
    private String name;
    private String desc;

    public TempletAnnotation(){}
    public TempletAnnotation(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

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

    /**
     *  PO 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletAnnotation> getModelAnnotationsV1() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.entity);
        list.add(IAnnotation.dynamicUpdate);
        list.add(IAnnotation.genericGeneratorV1);
        return list;
    }

    /**
     *  PO 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletAnnotation> getModelAnnotationsV2() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.lombokData);
        list.add(IAnnotation.entity);
        list.add(IAnnotation.dynamicUpdate);
        list.add(IAnnotation.genericGeneratorV2);
        return list;
    }


    /**
     *  DTO 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletAnnotation> getDTOAnnotationsV2() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.lombokData);
        list.add(IAnnotation.lombokAllArgsConstructor);
        list.add(IAnnotation.lombokNoArgsConstructor);
        return list;
    }
    /**
     *  QueryDTO 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletAnnotation> getQueryDTOAnnotationsV2() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.lombokData);
        list.add(IAnnotation.lombokAllArgsConstructor);
        list.add(IAnnotation.lombokNoArgsConstructor);
        return list;
    }
    /**
     * Application 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletAnnotation> getApplicationAnnotationsV1() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.springBootApplication);
        list.add(IAnnotation.springEnableDiscoveryClient);
        list.add(IAnnotation.springImport);
        list.add(IAnnotation.springEnableScheduling);
        return list;
    }

    /**
     * Application 应该在类上注入的注解 <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletAnnotation> getApplicationAnnotationsV2() {
        List<TempletAnnotation> list = new ArrayList<TempletAnnotation>();
        list.add(IAnnotation.springBootApplication);
        list.add(IAnnotation.springEnableDiscoveryClient);
        list.add(IAnnotation.springImport);
        return list;
    }
}
