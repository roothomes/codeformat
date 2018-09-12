package com.roothomes.common.util;


import java.util.ArrayList;
import java.util.List;

/**
 * 模型里面model的类，包的部分。
 * @author roothomes
 */
public class TempletPackage {
    private String importPackage;
    private String desc;

    public TempletPackage(){}

    public TempletPackage(String importPackage,String desc)
    {
        this.importPackage = importPackage;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public String getImportPackage() {
        return importPackage;
    }

    public void setImportPackage(String importPackage) {
        this.importPackage = importPackage;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    /**
     * Model 依赖的包； <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getModelBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgPersistenceEntity);
        packages.add(IPackageV1.pkgPersistenceTable);
        packages.add(IPackageV1.pkgPersistenceColumn);
        packages.add(IPackageV1.pkgHibernateDynamicUpdate);
        packages.add(IPackageV1.pkgHibernateGenericGenerator);
        packages.add(IPackageV1.pkgApecConstants);
        packages.add(IPackageV1.pkgApecJsonUtils);
        packages.add(IPackageV1.pkgApecEnableFlag);
        packages.add(IPackageV1.pkgApecBaseModel);
        return packages;
    }


    /**
     * Model 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getModelBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgApecFrameConsts);
        packages.add(IPackageV2.pkgSpringBaseModel);
        packages.add(IPackageV2.pkgJsonFormat);
        packages.add(IPackageV2.pkgLombokData);
        packages.add(IPackageV2.pkgHibernateGenericGenerator);
        packages.add(IPackageV2.pkgPersistenceEntity);
        packages.add(IPackageV2.pkgPersistenceTable);
        packages.add(IPackageV2.pkgPersistenceColumn);
        packages.add(IPackageV2.pkgApecEnableFlag);
        packages.add(IPackageV2.pkgApecJsonUtils);
        return packages;
    }

    /**
     * DTO 依赖的包； <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getDTOBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgApecBaseDTO);
        packages.add(IPackageV1.pkgJsonFormat);
        packages.add(IPackageV1.pkgApecJsonUtils);
        packages.add(IPackageV1.pkgApecEnableFlag);
        return packages;
    }

    /**
     * DTO 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getDTOBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgApecBaseDTO);
        packages.add(IPackageV2.pkgApecEnableFlag);
        packages.add(IPackageV2.pkgJsonFormat);
        packages.add(IPackageV2.pkgLombokData);
        packages.add(IPackageV2.pkgLombokAllArgsConstructor);
        packages.add(IPackageV2.pkgLombokNoArgsConstructor);
        return packages;
    }


    /**
     * DTO 依赖的包； <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getDAOBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgApecBaseDAO);
        return packages;
    }

    /**
     * DTO 依赖的包； <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getDAOBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgApecBaseDAO);
        return packages;
    }


    /**
     * Controller 依赖的包；  <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getControllerBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgApecConstants);
        packages.add(IPackageV1.pkgApecEnableFlag);
        packages.add(IPackageV1.pkgApecPageDTO);
        packages.add(IPackageV1.pkgApecException);
        packages.add(IPackageV1.pkgApecPageJSON);
        packages.add(IPackageV1.pkgApecResultData);
        packages.add(IPackageV1.pkgApecSpringUtil);
        packages.add(IPackageV1.pkgApecJsonUtils);
        packages.add(IPackageV1.pkgLogger);
        packages.add(IPackageV1.pkgLoggerFactory);
        packages.add(IPackageV1.pkgSpringAutowired);
        packages.add(IPackageV1.pkgSpringPageRequest);
        packages.add(IPackageV1.pkgSpringMediaType);
        packages.add(IPackageV1.pkgSpringRequestBody);
        packages.add(IPackageV1.pkgSpringRequestMapping);
        packages.add(IPackageV1.pkgSpringRequestMethod);
        packages.add(IPackageV1.pkgSpringRestController);
        //具体模型的扩展类单独生成
        return packages;
    }
    /**
     * BaseController 依赖的包；  <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getBaseControllerPackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgApecBaseController);
        packages.add(IPackageV1.pkgApecPageJSON);
        packages.add(IPackageV1.pkgApecJsonUtils);
        packages.add(IPackageV1.pkgApecBaseDTO);
        packages.add(IPackageV1.pkgSpringSort);
        packages.add(IPackageV1.pkgSpringPageRequest);

        //具体模型的扩展类单独生成
        return packages;
    }



    /**
     * Controller 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getControllerBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgApecController);
        packages.add(IPackageV2.pkgApecEnableFlag);
        packages.add(IPackageV2.pkgApecPageDTO);
        packages.add(IPackageV2.pkgApecException);
        packages.add(IPackageV2.pkgApecPageJSON);
        packages.add(IPackageV2.pkgApecResultData);
        packages.add(IPackageV2.pkgApecJsonUtils);
        packages.add(IPackageV2.pkgLogger);
        packages.add(IPackageV2.pkgLoggerFactory);
        packages.add(IPackageV2.pkgSpringAutowired);
        packages.add(IPackageV2.pkgSpringPageRequest);
        packages.add(IPackageV2.pkgSpringMediaType);
        packages.add(IPackageV2.pkgSpringRequestBody);
        packages.add(IPackageV2.pkgSpringRequestMapping);
        packages.add(IPackageV2.pkgSpringRequestMethod);
        packages.add(IPackageV2.pkgSpringRestController);
        packages.add(IPackageV2.pkgJavaUtil);
        //具体模型的扩展类单独生成
        return packages;
    }

    /**
     * ServiceImpl 依赖的包；  <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getServiceImplBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgApecPageDTO);
        packages.add(IPackageV1.pkgApecEnableFlag);
        packages.add(IPackageV1.pkgApecException);
        packages.add(IPackageV1.pkgApecBeanUtils);
        packages.add(IPackageV1.pkgApacheCommonLang);
        packages.add(IPackageV1.pkgApecJsonUtils);
        packages.add(IPackageV1.pkgLogger);
        packages.add(IPackageV1.pkgLoggerFactory);
        packages.add(IPackageV1.pkgSpringAutowired);
        packages.add(IPackageV1.pkgSpringPage);
        packages.add(IPackageV1.pkgSpringPageRequest);
        packages.add(IPackageV1.pkgSpringService);
        packages.add(IPackageV1.pkgJavaxTransactional);
        packages.add(IPackageV1.pkgSpringSort);
        packages.add(IPackageV1.pkgApecCacheService);
        packages.add(IPackageV1.pkgMysemaPredicate);
        packages.add(IPackageV1.pkgMysemaBooleanExpression);

        //具体模型的扩展类单独生成
        return packages;
    }

    /**
     * ServiceImpl 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getServiceImplBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgApecPageDTO);
        packages.add(IPackageV2.pkgApecEnableFlag);
        packages.add(IPackageV2.pkgApecException);
        packages.add(IPackageV2.pkgApecIDGenerator);
        packages.add(IPackageV2.pkgApecBeanUtils);
        packages.add(IPackageV2.pkgApacheCommonLang);
        packages.add(IPackageV2.pkgQuerydslExpressionUtils);
        packages.add(IPackageV2.pkgQuerydslBooleanExpression);
        packages.add(IPackageV2.pkgQuerydslPredicate);
        packages.add(IPackageV2.pkgApecJsonUtils);
        packages.add(IPackageV2.pkgLogger);
        packages.add(IPackageV2.pkgLoggerFactory);
        packages.add(IPackageV2.pkgSpringAutowired);
        packages.add(IPackageV2.pkgSpringPage);
        packages.add(IPackageV2.pkgSpringPageRequest);
        packages.add(IPackageV2.pkgSpringService);
        packages.add(IPackageV2.pkgSpringTransactional);
        packages.add(IPackageV2.pkgSpringSort);
        //具体模型的扩展类单独生成
        return packages;
    }

    /**
     * Service 依赖的包；  <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getServiceBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgApecPageDTO);
        packages.add(IPackageV1.pkgApecException);
        packages.add(IPackageV1.pkgSpringPageRequest);
        //具体模型的扩展类单独生成
        return packages;
    }

    /**
     * Service 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getServiceBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgApecPageDTO);
        packages.add(IPackageV2.pkgApecException);
        packages.add(IPackageV2.pkgSpringPageRequest);
        //具体模型的扩展类单独生成
        return packages;
    }


    /**
     * Application 依赖的包； <br/>
     * 使用 framework 的 1.0-CNCSEN 版本
     * @return
     */
    public static List<TempletPackage> getApplicationBasePackageV1(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV1.pkgJavaLang);
        packages.add(IPackageV1.pkgJavaUtil);
        packages.add(IPackageV1.pkgSpringBootApplication);
        packages.add(IPackageV1.pkgSpringApplicationBuilder);
        packages.add(IPackageV1.pkgSpringEnableDiscoveryClient);
        packages.add(IPackageV1.pkgSpringImport);
        packages.add(IPackageV1.pkgSpringEnableScheduling);

        packages.add(IPackageV1.pkgApecSpringCloudConfig);
        packages.add(IPackageV1.pkgApecBaseApplication);
        packages.add(IPackageV1.pkgApecRoutingKey);
        //具体模型的扩展类单独生成
        return packages;
    }

    /**
     * Application 依赖的包； <br/>
     * 使用 framework 的 1.5.0-RELEASE 版本
     * @return
     */
    public static List<TempletPackage> getApplicationBasePackageV2(){
        List<TempletPackage> packages = new ArrayList<TempletPackage>();
        packages.add(IPackageV2.pkgJavaLang);
        packages.add(IPackageV2.pkgJavaUtil);
        packages.add(IPackageV2.pkgSpringBootApplication);
        packages.add(IPackageV2.pkgSpringApplicationBuilder);
        packages.add(IPackageV2.pkgSpringEnableDiscoveryClient);
        packages.add(IPackageV2.pkgSpringImport);

        packages.add(IPackageV2.pkgApecSpringCloudConfig);
        packages.add(IPackageV2.pkgApecBaseApplication);
        //具体模型的扩展类单独生成
        return packages;
    }

}
