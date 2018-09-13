spring.profiles.active = test
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.datasource.primary.time-between-eviction-runs-millis=10000
spring.datasource.primary.min-evictable-idle-time-millis=20000
spring.datasource.primary.test-while-idle=true

workerId=${cfgWorkerId}
spring.application.name=${ARTIFACTID}-service
eureka.instance.prefer-ip-address=true
eureka.instance.instance-id=${cfgEurekaInstanceInstanceId}
eureka.client.serviceUrl.defaultZone=${cfgEurekaClientServiceUrlDefaultZone}

spring.messages.basename=errormessage
spring.messages.cache-seconds=-1

