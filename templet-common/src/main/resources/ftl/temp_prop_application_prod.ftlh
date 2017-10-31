
server.port=30023

eureka.instance.hostname=129.1.1.214:1111
eureka.client.serviceUrl.defaultZone=http://129.1.1.214:1111/eureka/,http://129.1.1.216:1111/eureka/,http://129.1.1.221:1111/eureka/,http://129.1.1.231:1111/eureka/

logging.level=INFO
logging.level.org.hibernate=ERROR
logging.level.com.apec=debug

spring.datasource.primary.url=jdbc:mysql://129.1.1.214:3000/cncsen?useUnicode=true&characterEncoding=utf8&useSSL=false&useLocalSessionState=true
spring.datasource.primary.username=znw
spring.datasource.primary.password=znw@ap-ec
spring.datasource.primary.initialSize=5
spring.datasource.primary.maxActive=30

redis.database=1
redis.host=129.1.1.214
redis.port=6379
redis.password=foobared
redis.maxActive=8
redis.maxWait=-1
redis.maxIdle=8
redis.minIdle=0
redis.timeout=0

spring.redis.host=129.1.1.214
spring.redis.port=7000
spring.redis.host2=129.1.1.214
spring.redis.port2=7001

spring.rabbitmq.host=129.1.1.214
spring.rabbitmq.port=5672
spring.rabbitmq.username=apec
spring.rabbitmq.password=123456
spring.rabbitmq.virtual-host=/apec

ftp.host=192.168.7.28
ftp.port=21
ftp.username=root
ftp.password=apec!@#$
ftp.workingDir=/data/kt-file/