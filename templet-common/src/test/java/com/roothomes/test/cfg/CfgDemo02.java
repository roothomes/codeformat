package com.roothomes.test.cfg;

import java.io.File;

/**
 * 配置文件
 * @author  roothomes
 * @date 2017-10-20
 */
public class CfgDemo02
{
    /**  */
    public static String baseDir = ".\\templet-common\\src\\test\\resources";
    /**  */
    public static String templetFile = "demo02.ftlh";
    /**
     * 生成文件的基本目录
     */
    public static String outputBaseDir = "D:\\git\\codeformat\\templet-common\\output";

    /** 项目组织唯一的标识符 */
    public static String V_GROUPID="com.apec";
    /** 项目的唯一的标识符 */
    public static String V_ARTIFACTID="notice";
    /** POJO中模型类的名称 */
    public static String V_POJO = "Notice";
    /**
     * Java POJO模型类中属性的名称;
     */
    public static String cfg_javaCode = "name,key,val";
    /**
     * 数据库字段名称
     * */
    public static String cfg_dbCode = "t_x_01,t_x_02,t_x_03";
    /**
     * Java属性名称
     * */
    public static String cfg_desc = "属性1名称,属性2名称,属性3名称";
    /**
     * Java属性类型(支持基本数据类型)
     * */
    public static String cfg_type = "String,Integer,Double";


    /** 数据库表名称 */
    public static String cfg_dbTableName="notice";
    /** 数据库名称 */
    public static String cfg_dbName = "cncsen";
    public static final String javafile = ".java";


    /**
     * 是否初始化目录列表
     */
    private static boolean isInitDir = false;

    /**
     * 初始化目录列表
     */
    public static void initDir(){
        //基础输出地址 + 包名称 + 类名称。
        File file = new File(outputBaseDir);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建基础目录" + outputBaseDir);
        }
        String group = outputBaseDir + File.separator + V_GROUPID.replace('.',File.separatorChar);
        String artifact = group + File.separator + V_ARTIFACTID;
        String dao = artifact + File.separator + "dao";
        String dto = artifact + File.separator + "dto";
        String model = artifact + File.separator + "model";
        String service = artifact + File.separator + "service" + File.separator + "impl";
        String util = artifact + File.separator + "util";
        String vo = artifact + File.separator + "vo";
        String web = artifact + File.separator + "web";

        file = new File( group);
        file.mkdirs();
        file = new File(artifact);
        file.mkdirs();
        file = new File(dao);
        file.mkdirs();
        file = new File(dto);
        file.mkdirs();
        file = new File(model);
        file.mkdirs();
        file = new File(service);
        file.mkdirs();
        file = new File(util);
        file.mkdirs();
        file = new File(vo);
        file.mkdirs();
        file = new File(web);
        file.mkdirs();
    }

    /**
     * 获取基础的输入目录地址
     * @return
     */
    public static String getBaseDir(){
        if(!isInitDir){
            initDir();
        }
        return outputBaseDir;
    }

    /**
     * 获取组织的文件地址
     * @return
     */
    public static String getFilePath4Group(){
        String group = getBaseDir() + File.separator + V_GROUPID.replace('.',File.separatorChar);
        return group;
    }

    /**
     * 获取项目的文件地址
     * @return
     */
    public static String getFilePath4Artifact(){
        String artifact = getFilePath4Group() + File.separator + V_ARTIFACTID;
        return artifact;
    }

    /**
     * 获取项目中model模型的文件地址。
     * @return
     */
    public static String getFilePath4Model(){
        String path = getFilePath4Artifact() + File.separator + "model" + File.separator + V_POJO + javafile;
        return path;
    }
    /**
     * 获取项目中dao模型的文件地址。
     * @return
     */
    public static String getFilePath4Dao(){
        String path = getFilePath4Artifact() + File.separator + "dao" + File.separator + V_POJO + "DAO" + javafile;
        return path;
    }

    /**
     * 获取项目中dto模型的文件地址。
     * @return
     */
    public static String getFilePath4DTO(){
        String path = getFilePath4Artifact() + File.separator + "dto" + File.separator + V_POJO + "DTO" + javafile;
        return path;
    }

    /**
     * 获取项目中util模型的文件地址。
     * @return
     */
    public static String getFilePath4Util(){
        String path = getFilePath4Artifact() + File.separator + "util" + File.separator + V_POJO + "Util" + javafile;
        return path;
    }

    /**
     * 获取项目中vo模型的文件地址。
     * @return
     */
    public static String getFilePath4Vo(){
        String path = getFilePath4Artifact() + File.separator + "vo" + File.separator + V_POJO + "Vo" + javafile;
        return path;
    }

    /**
     * 获取项目中web模型的文件地址。
     * @return
     */
    public static String getFilePath4Web(){
        String path = getFilePath4Artifact() + File.separator + "web" + File.separator + V_POJO + "Controller" + javafile;
        return path;
    }

    /**
     * 获取项目中service模型的文件地址。
     * @return
     */
    public static String getFilePath4Service(){
        String path = getFilePath4Artifact() + File.separator + "service" + File.separator + V_POJO + "Service" + javafile;
        return path;
    }

    /**
     * 获取项目中serviceImpl模型的文件地址。
     * @return
     */
    public static String getFilePath4ServiceImpl(){
        String path = getFilePath4Artifact() + File.separator + "service" + File.separator + "impl"+ File.separator + V_POJO + "ServiceImpl" + javafile;
        return path;
    }

    /**
     * 获取业务的基础包名称
     * @return
     */
    public static String getPackageBaseName(){
        return V_GROUPID + "." + V_ARTIFACTID;
    }

    /**
     * 获取项目该业务model包的名称
     * @return
     */
    public static String getPackageName4Model(){
        String pkg = getPackageBaseName() + "." + "model";
        return pkg;
    }
    /**
     * 获取项目该业务dao包的名称
     * @return
     */
    public static String getPackageName4Dao(){
        String pkg = getPackageBaseName() + "." + "dao";
        return pkg;
    }
    /**
     * 获取项目该业务dto包的名称
     * @return
     */
    public static String getPackageName4DTO(){
        String pkg = getPackageBaseName() + "." + "dto";
        return pkg;
    }
    /**
     * 获取项目该业务service包的名称
     * @return
     */
    public static String getPackageName4Service(){
        String pkg = getPackageBaseName() + "." + "service";
        return pkg;
    }
    /**
     * 获取项目该业务serviceImpl包的名称
     * @return
     */
    public static String getPackageName4ServiceImpl(){
        String pkg = getPackageBaseName() + "." + "service" + "." +"impl";
        return pkg;
    }
    /**
     * 获取项目该业务util包的名称
     * @return
     */
    public static String getPackageName4Util(){
        String pkg = getPackageBaseName() + "." + "util";
        return pkg;
    }
    /**
     * 获取项目该业务vo包的名称
     * @return
     */
    public static String getPackageName4Vo(){
        String pkg = getPackageBaseName() + "." + "vo";
        return pkg;
    }
    /**
     * 获取项目该业务web包的名称
     * @return
     */
    public static String getPackageName4Web(){
        String pkg = getPackageBaseName() + "." + "web";
        return pkg;
    }


}
