package com.roothomes.common.util;

import java.util.HashMap;
import java.util.Map;

public class PackageUtil {

    public static Map<DirEnum,String> generatePackages(SystemEnum systemtype, String packageBaseName){
       if(SystemEnum.spring_boots.equals(systemtype)){
           return generatePackagesCommon(packageBaseName);
       }else{
           return null;
       }
    }

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
        return map;
    }
}
