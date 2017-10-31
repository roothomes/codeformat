eureka.instance.hostname=${cfgDevEurekaInstanceHostname}
server.port=${cfgServerPort}

logging.level=INFO
logging.level.org.hibernate=ERROR
logging.level.com.apec=debug

spring.datasource.primary.url=${cfgDevJdbcUrl}
spring.datasource.primary.username=${cfgDevJdbcUserName}
spring.datasource.primary.password=${cfgDevJdbcUserPwd}
spring.datasource.primary.initialSize=2
spring.datasource.primary.maxActive=10

spring.jpa.properties.hibernate.show_sql=true

redis.database=6
redis.host=192.168.7.203
redis.port=6379
redis.password=foobared
redis.maxActive=8
redis.maxWait=-1
redis.maxIdle=8
redis.minIdle=0
redis.timeout=0

spring.redis.host=192.168.7.203
spring.redis.port=7000
spring.redis.host2=192.168.7.203
spring.redis.port2=7001
spring.redis.timeout=5000
spring.redis.maxRedirections=5

ftp.host=192.168.7.28
ftp.port=21
ftp.username=root
ftp.password=apec!@#$
ftp.workingDir=/data/kt-file/
