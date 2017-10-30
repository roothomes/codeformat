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
     * @param systemtype 系统类型
     * @param param 配置参数对象
     * @return
     * @author roothomes
     */
    public static Map<DirEnum,String> generatePackages(SystemEnum systemtype, Cfg param){
       if(SystemEnum.spring_boots.equals(systemtype)){
           return generatePackagesCommon(param);
       }else{
           System.err.println("未定义" + systemtype.name());
           return null;
       }
    }

    /**
     * 生成业务文件的包的路径集合
     * @param param 配置参数对象
     * @return
     * @author roothomes
     */
    private static Map<DirEnum,String> generatePackagesCommon(Cfg param){
        String getPackageBaseName = param.getCfgGroupId() +"." + param.getCfgArtifactId();
        Map<DirEnum,String> map = new HashMap<DirEnum,String>(13);
        map.put(DirEnum.p_basemodel, getPackageBaseName + "." + "model");
        map.put(DirEnum.p_model, getPackageBaseName + "." + "model");
        map.put(DirEnum.p_dao, getPackageBaseName + "." + "dao");
        map.put(DirEnum.p_dto, getPackageBaseName + "." + "dto");
        map.put(DirEnum.p_service, getPackageBaseName + "." + "service");
        map.put(DirEnum.p_serviceimpl, getPackageBaseName + "." + "service" + "." +"impl");
        map.put(DirEnum.p_util, getPackageBaseName + "." + "util");
        map.put(DirEnum.p_vo, getPackageBaseName + "." + "vo");
        map.put(DirEnum.p_basecontroller, getPackageBaseName + "." + "web");
        map.put(DirEnum.p_controller, getPackageBaseName + "." + "web");
        map.put(DirEnum.p_contant, getPackageBaseName + "." + "constants");
        map.put(DirEnum.p_application,param.getCfgGroupId());
        map.put(DirEnum.p_keygen,getPackageBaseName + "." + "util");

        return map;
    }

    /**
     * 获取模型对象序列号
     * @param param
     * @return
     */
    public static Map<DirEnum,String> generateClassSerialNo(Cfg param){
        String baseSerialNo = param.getCfgSerialNo();
        Map<DirEnum,String> map = new HashMap<DirEnum,String>(13);
        map.put(DirEnum.p_basemodel, baseSerialNo + "_" + "basemodel");
        map.put(DirEnum.p_model, baseSerialNo + "_" + "model");
        map.put(DirEnum.p_dao, baseSerialNo + "_" + "dao");
        map.put(DirEnum.p_dto, baseSerialNo + "_" + "dto");
        map.put(DirEnum.p_service, baseSerialNo + "_" + "service");
        map.put(DirEnum.p_serviceimpl, baseSerialNo + "_" + "serviceimpl");
        map.put(DirEnum.p_util, baseSerialNo + "_" + "util");
        map.put(DirEnum.p_vo, baseSerialNo + "_" + "vo");
        map.put(DirEnum.p_basecontroller, baseSerialNo + "_" + "basecontroller");
        map.put(DirEnum.p_controller, baseSerialNo + "_" + "controller");
        map.put(DirEnum.p_contant, baseSerialNo + "_" + "constants");
        map.put(DirEnum.p_application,baseSerialNo + "_" + "application");
        map.put(DirEnum.p_keygen,baseSerialNo + "_" + "keygen");

        return map;
    }

    /**
     * 导入基础的 model、dto、vo、contant、util类
     * @param packageMap 包的map集合
     * @param fileMap 文件map集合
     * @return
     */
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
