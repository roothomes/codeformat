<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <version>${VERSION}</version>
    <artifactId>${ARTIFACTID}-server</artifactId>
    <parent>
        <artifactId>${ARTIFACTID}-parent</artifactId>
        <groupId>${GROUPID}</groupId>
        <version>${VERSION}</version>
    </parent>

    <dependencies>

        <!--依赖项底层接口和模块 start -->
        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>framework-jpa</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>

        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>framework-springcloud</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>

        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>framework-common</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>
        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>framework-mq</artifactId>
            <version>1.0.2.BUILD-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>framework-ftp</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>

        <!--依赖项底层接口和模块 end -->

        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>magpie-cb</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>

        <dependency>
            <groupId>com.apec</groupId>
            <artifactId>redis-cache</artifactId>
            <version>${PARENT_POM_VERSION}</version>
        </dependency>

        <!-- spring cloud依赖包 start -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

    </dependencies>

    <!-- 打包方式 -->
    <build>
        <finalName>${r'${project.artifactId}'}-${r'${project.version}'}</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <!-- querydsl 插件 自动生成Qmodle，简化Criteria操作 -->
            <plugin>
                <groupId>com.mysema.maven</groupId>
                <artifactId>apt-maven-plugin</artifactId>
                <version>1.1.3</version>
                <executions>
                    <execution>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>process</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>target/generated-sources/java</outputDirectory>
                            <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

        </plugins>

    </build>
</project>