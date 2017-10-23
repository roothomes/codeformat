package com.roothomes.test.cfg;

import java.util.ArrayList;

/**
 * 进行映射的时候键的名称
 * @author roothomes
 * @date 2017-10-23
 */
public interface IKey {
    /**
     * GroupID项目组织唯一的标识符，用于包结构等
     */
    String K_GROUPID="GROUPID";
    /**
     * ArtifactID就是项目的唯一的标识符，用于包结构等
     */
    String K_ARTIFACTID="ARTIFACTID";
    /**
     * 导入的Java文件的包语句列表
     */
    String K_PACKAGE = "PACKAGE";
    /**
     * 导入到Java文件中的注解语句列表
     */
    String K_ANNOTATION="ANNOTATION";
    /**
     * 类名称
     */
    String K_CLASSNAME = "CLASSNAME";
    /**
     * 系统分隔符
     */
    String K_SPLIT=",";
    /**
     * 导入到Java文件中的属性语句列表
     */
    String K_ATTRIBUTE = "ATTRIBUTE";
    /**
     * 数据库的表名称
     */
    String K_DBTABLENAME = "DBTABLENAME";
    /**
     * 数据库名称
     */
    String K_DBNAME="DBNAME";



}
