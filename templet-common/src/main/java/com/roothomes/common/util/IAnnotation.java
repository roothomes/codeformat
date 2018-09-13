package com.roothomes.common.util;

public interface IAnnotation {

    TempletAnnotation lombokData = new TempletAnnotation("@Data","注解自动添加属性的getset方法");
    TempletAnnotation lombokNoArgsConstructor = new TempletAnnotation("@NoArgsConstructor","注解自动生成无参数的构造方法");
    TempletAnnotation lombokAllArgsConstructor = new TempletAnnotation("@AllArgsConstructor","注解自动生成全参数的构造方法");
    TempletAnnotation entity = new TempletAnnotation("@Entity","JPA实体注解");
    TempletAnnotation dynamicUpdate = new TempletAnnotation("@DynamicUpdate","hibernate动态更新");
    TempletAnnotation genericGeneratorV1 = new TempletAnnotation("@GenericGenerator(name = Constants.SYSTEM_GENERATOR, strategy = Constants.ASSIGNED)","hibernate自动生成");
    TempletAnnotation genericGeneratorV2 = new TempletAnnotation("@GenericGenerator(name = FrameConsts.SYSTEM_GENERATOR, strategy = FrameConsts.ASSIGNED)","hibernate自动生成");

    TempletAnnotation springEnableDiscoveryClient = new TempletAnnotation("@EnableDiscoveryClient","spring发现微服务客户端");
    TempletAnnotation springBootApplication = new TempletAnnotation("@SpringBootApplication","springBoot应用");
    TempletAnnotation springImport = new TempletAnnotation("@Import(value = {SpringCloudConfig.class})","导入spring上下文");
    TempletAnnotation springEnableScheduling = new TempletAnnotation("@EnableScheduling","springBoot应用");

}
