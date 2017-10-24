package com.roothomes.common.util;

import java.util.HashMap;
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
}
