<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>${ARTIFACTID}-parent</artifactId>
    <packaging>pom</packaging>

    <parent>
        <artifactId>${PARENT_POM_ARTIFACTID}</artifactId>
        <groupId>${PARENT_POM_GROUPID}</groupId>
        <version>${PARENT_POM_VERSION}</version>
        <#--<relativePath>${PARENT_POM_RELATIVEPATH}</relativePath>-->
    </parent>
    <modules>
        <module>${ARTIFACTID}-server</module>
    </modules>

    <version>${VERSION}</version>
</project>