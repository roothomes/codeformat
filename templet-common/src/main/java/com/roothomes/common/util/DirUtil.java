package com.roothomes.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件夹的工具类
 * @author roothomes
 */
public class DirUtil {
    private static final Logger LOG = LoggerFactory.getLogger( DirUtil.class );

    /**
     * 获取生成业务文件的具体路径
     * @param systemType 系统标识
     * @param cfg 配置信息
     * @return
     * @author roothomes
     */
    public Map<DirEnum,String> getFilePathMap(SystemEnum systemType, Cfg cfg){
        //基础输出地址 + 包名称 + 类名称。
        File file = new File(cfg.getCfgOutputBaseDir());
        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建基础目录" + cfg.getCfgOutputBaseDir());
        }

        Map<DirEnum,String> mapPackages = PackageUtil.generatePackages(systemType,cfg.getCfgGroupId()+"." + cfg.getCfgArtifactId());
        Iterator<DirEnum> iter = mapPackages.keySet().iterator();
        Map<DirEnum,String> mapFiles = new HashMap<DirEnum,String>();

        while(iter.hasNext()){
            DirEnum e = iter.next();
            String p = mapPackages.get(e);
            String dir = p.replace('.',File.separatorChar);
            //创建文件夹
            file = new File(cfg.getCfgOutputBaseDir() + dir);
            if(!file.exists()){
                file.mkdirs();
                System.out.println("业务代码目录" + cfg.getCfgOutputBaseDir() + dir);
            }
            String filePath = null;
            if(DirEnum.p_model.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"model" + File.separator + cfg.getCfgPojoName() + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_dto.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"dto" + File.separator + cfg.getCfgPojoName() + "DTO" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_vo.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"vo" + File.separator + cfg.getCfgPojoName() + "Vo" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_dao.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"dao" + File.separator + cfg.getCfgPojoName() + "DAO" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_util.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"util" + File.separator + cfg.getCfgPojoName() + "Util" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_web.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"web" + File.separator + cfg.getCfgPojoName() + "Controller" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_service.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"service" + File.separator + cfg.getCfgPojoName() + "Service" + IContant.JAVA_EXTENSION_NAME;
            }else if(DirEnum.p_serviceimpl.equals(e)){
                filePath = cfg.getCfgOutputBaseDir() +"service" + File.separator + "impl" + File.separator + cfg.getCfgPojoName() + "ServiceImpl"+ IContant.JAVA_EXTENSION_NAME;
            }
            mapFiles.put(e,filePath);
        }
        return mapFiles;
    }
}
