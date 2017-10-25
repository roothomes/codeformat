package com.roothomes.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板包的处理类
 * @author roothomes
 */
public class PackageUtil {
    /**
     * 生成业务包的路径集合
     * @param systemtype
     * @param packageBaseName
     * @return
     * @author roothomes
     */
    public static Map<DirEnum,String> generatePackages(SystemEnum systemtype, String packageBaseName){
       if(SystemEnum.spring_boots.equals(systemtype)){
           return generatePackagesCommon(packageBaseName);
       }else{
           System.err.println("未定义" + systemtype.name());
           return null;
       }
    }

    /**
     * 生成业务文件的包的路径集合
     * @param getPackageBaseName
     * @return
     * @author roothomes
     */
    private static Map<DirEnum,String> generatePackagesCommon(String getPackageBaseName){
        Map<DirEnum,String> map = new HashMap<DirEnum,String>();
        map.put(DirEnum.p_basemodel, getPackageBaseName + "." + "model");
        map.put(DirEnum.p_model, getPackageBaseName + "." + "model");
        map.put(DirEnum.p_dao, getPackageBaseName + "." + "dao");
        map.put(DirEnum.p_dto, getPackageBaseName + "." + "dto");
        map.put(DirEnum.p_service, getPackageBaseName + "." + "service");
        map.put(DirEnum.p_serviceimpl, getPackageBaseName + "." + "service" + "." +"impl");
        map.put(DirEnum.p_util, getPackageBaseName + "." + "util");
        map.put(DirEnum.p_vo, getPackageBaseName + "." + "vo");
        map.put(DirEnum.p_web, getPackageBaseName + "." + "web");
        map.put(DirEnum.p_contant, getPackageBaseName + "." + "constants");
        map.put(DirEnum.p_application,getPackageBaseName);
        map.put(DirEnum.p_keygen,getPackageBaseName + "." + "util");

        return map;
    }


    public static List<TempletPackage> getBaseImportPackageList(Map<DirEnum,String> packageMap, Map<DirEnum,String> fileMap){
        List<TempletPackage> listPackage = new ArrayList<TempletPackage>(4);
        TempletPackage one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_model) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_model));
        one.setDesc("模型类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_dto) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_dto));
        one.setDesc("模型DTO类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_vo) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_vo));
        one.setDesc("模型Vo类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_contant) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_contant));
        one.setDesc("模型常量类");
        listPackage.add(one);
        one = new TempletPackage();
        one.setImportPackage(packageMap.get(DirEnum.p_util) + "." + DirUtil.getJavaClassName(fileMap,DirEnum.p_util));
        one.setDesc("模型常用方法类");
        listPackage.add(one);
        return listPackage;
    }
}
