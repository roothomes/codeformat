package com.roothomes.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

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
    public static Map<DirEnum,String> getFilePathMap(SystemEnum systemType, Cfg cfg){
        //基础输出地址 + 包名称 + 类名称。
        File file = new File(cfg.getCfgOutputBaseDir());
        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建基础目录" + cfg.getCfgOutputBaseDir());
        }
        Map<DirEnum,String> mapPackages = PackageUtil.generateJavaPackages(systemType,cfg);
        Iterator<DirEnum> iter = mapPackages.keySet().iterator();
        Map<DirEnum,String> mapFiles = new HashMap<DirEnum,String>(12);
        String dir_parent = "-parent";
        String dir_server = "-server";
        while(iter.hasNext()){
            DirEnum e = iter.next();
            String javaFilePackage = mapPackages.get(e);
            String fileName = getFileName(cfg,e);
            //这里都是Java文件的信息
            String packageDir = javaFilePackage.replace('.',File.separatorChar);
            String fileDir = cfg.getCfgOutputBaseDir() + File.separator
                    + cfg.getCfgArtifactId() + dir_parent + File.separator
                    + cfg.getCfgArtifactId() + dir_server + File.separator
                    + "src" + File.separator
                    + "main" + File.separator
                    + "java" + File.separator
                    + packageDir ;
            //创建文件夹
            file = new File(fileDir);
            if(!file.exists()){
                file.mkdirs();
                System.out.println("业务代码目录" + fileDir);
            }
            mapFiles.put(e,fileDir + File.separator + fileName);
        }

        List<DirEnum> listDir = getDirEnumNotJavaFile();
        for(DirEnum e:listDir){
            String fileName = getFileName(cfg,e);
            String fileDir = getFileDirNotJavaFile(cfg.getCfgOutputBaseDir(),cfg.getCfgArtifactId(),e);
            file = new File(fileDir);
            if(!file.exists()){
                file.mkdirs();
                System.out.println("业务代码目录" + fileDir);
            }
            mapFiles.put(e,fileDir + File.separator + fileName);
        }
        return mapFiles;
    }

    /**
     * 获取非Java文件的文件枚举集合
     * @return
     */
    public static List<DirEnum> getDirEnumNotJavaFile(){
        List<DirEnum> listDir = new ArrayList<DirEnum>();
        listDir.add(DirEnum.p_prop_application);
        listDir.add(DirEnum.p_prop_application_dev);
        listDir.add(DirEnum.p_prop_application_test);
        listDir.add(DirEnum.p_prop_application_pord);
        listDir.add(DirEnum.p_prop_log4j);
        listDir.add(DirEnum.p_pom);
        listDir.add(DirEnum.p_pom_parent);
        return listDir;
    }
    /**
     * 获取非Java文件的上级文件夹路径
     * @param outputBaseDir 配置的基础路径
     * @param artifactId 项目的唯一标示
     * @param e 路径
     * @return
     */
    public static String getFileDirNotJavaFile(String outputBaseDir, String artifactId, DirEnum e){
        String fileDir = outputBaseDir;
        String dir_parent = "-parent";
        String dir_server = "-server";
        if(DirEnum.p_pom_parent.equals(e)){
            fileDir = outputBaseDir + File.separator
                    + artifactId+ dir_parent ;
        }else if(DirEnum.p_pom.equals(e)){
            fileDir = outputBaseDir + File.separator
                    + artifactId + dir_parent + File.separator
                    + artifactId + dir_server ;
        }else if(DirEnum.p_prop_application.equals(e) || DirEnum.p_prop_application_dev.equals(e)
                || DirEnum.p_prop_application_test.equals(e) || DirEnum.p_prop_application_pord.equals(e)
                || DirEnum.p_prop_log4j.equals(e) ){
            fileDir = outputBaseDir + File.separator
                    + artifactId + dir_parent + File.separator
                    + artifactId + dir_server + File.separator
                    + "src" + File.separator
                    + "main" + File.separator
                    + "resources" ;
        }else{
            fileDir = "UndefinedFolder";
        }
        return fileDir;
    }

    /**
     * 获取所有枚举文件名称
     * @param cfg 配置对象
     * @param e 文件枚举
     * @return
     */
    public static String getFileName( Cfg cfg,DirEnum e){
        String fileName = null;
        if(DirEnum.p_model.equals(e)){
            fileName = cfg.getCfgPojoName() + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_dto.equals(e)){
            fileName = cfg.getCfgPojoName() + "DTO" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_vo.equals(e)){
            fileName = cfg.getCfgPojoName() + "Vo" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_dao.equals(e)){
            fileName =cfg.getCfgPojoName() + "DAO" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_util.equals(e)){
            fileName = cfg.getCfgPojoName() + "Util" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_basecontroller.equals(e)){
            fileName = "MyBaseController" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_controller.equals(e)){
            fileName = cfg.getCfgPojoName() + "Controller" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_service.equals(e)){
            fileName = cfg.getCfgPojoName() + "Service" + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_serviceimpl.equals(e)){
            fileName = cfg.getCfgPojoName() + "ServiceImpl"+ IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_contant.equals(e)){
            fileName = cfg.getCfgPojoName() + "Contant"+ IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_application.equals(e)){
            fileName = cfg.getCfgPojoName() + "ServiceApplication"+ IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_keygen.equals(e)){
            fileName = "KeyGen" + cfg.getCfgPojoName() + IContant.JAVA_EXTENSION_NAME;
        }else if(DirEnum.p_basemodel.equals(e)){
            fileName = "BaseModel"+ IContant.JAVA_EXTENSION_NAME;;
        }else if(DirEnum.p_pom.equals(e) || DirEnum.p_pom_parent.equals(e)){
            fileName="pom.xml";
        }else if(DirEnum.p_prop_application.equals(e)){
            fileName = "application.properties";
        }else if(DirEnum.p_prop_application_dev.equals(e)){
            fileName = "application-dev.properties";
        }else if(DirEnum.p_prop_application_test.equals(e)){
            fileName = "application-test.properties";
        }else if(DirEnum.p_prop_application_pord.equals(e)){
            fileName = "application-prod.properties";
        }else if(DirEnum.p_prop_log4j.equals(e)){
            fileName = "log4j.properties";
        }else{
            fileName = "Undefined.file";
        }

        return fileName;
    }

    /**
     * 从文件路径中获取文件类的名称
     * @param fileMap 文件路径集合
     * @param fileType 文件类型
     * @return
     */
    public static String getJavaClassName(Map<DirEnum,String> fileMap, DirEnum fileType){
        // 设置类名称
        String className = fileMap.get(fileType).substring(fileMap.get(fileType).lastIndexOf(File.separator)+1,fileMap.get(fileType).lastIndexOf("."));
        return className;
    }


}
