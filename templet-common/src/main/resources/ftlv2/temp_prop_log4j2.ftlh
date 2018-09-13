<?xml version="1.0" encoding="UTF-8"?>
<configuration status="error" monitorInterval="30">

    <properties>
        <Property name="fileName">logs</Property>
        <Property name="serverName">${MODEL_CLASSNAME?lower_case}-server</Property>
        <Property name="LOG_PATTERN">%d{yyyy-MM-dd HH:mm:ss,SSS} %t %5p %c{1}:%L - %m%n</Property>
    </properties>

    <Appenders>
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout pattern="${r'${LOG_PATTERN}'}"/>
        </Console>

        <RollingRandomAccessFile name="infoFile" fileName="${r'${fileName}'}/${r'${serverName}'}-info.log"
                                 filePattern="${r'${fileName}'}/%d{yyyy-MM-dd}-%i.${r'${serverName}'}-info.log">
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="${r'${LOG_PATTERN}'}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true"/>
                <!--<SizeBasedTriggeringPolicy size="512 MB"/>-->
            </Policies>
            <DefaultRolloverStrategy max="50"/>
        </RollingRandomAccessFile>

        <RollingRandomAccessFile name="errorFile" fileName="${r'${fileName}'}/${r'${serverName}'}-error.log" immediateFlush="false"
                                 filePattern="${r'${fileName}'}/%d{yyyy-MM-dd}-%i.${r'${serverName}'}-error.log">
            <PatternLayout pattern="${r'${LOG_PATTERN}'}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true"/>
                <!--<SizeBasedTriggeringPolicy size="512 MB"/>-->
            </Policies>
            <ThresholdFilter level="error" onMatch="ACCEPT" onMismatch="DENY"/>
            <DefaultRolloverStrategy max="100"/>
        </RollingRandomAccessFile>
    </Appenders>

    <Loggers>
        <Logger name="com.apec" level="debug" additivity="false">
            <AppenderRef ref="infoFile"/>
            <AppenderRef ref="console"/>
            <AppenderRef ref="errorFile"/>
        </Logger>
        <Logger name="org.springframework" level="error" additivity="false"/>
        <Logger name="org.apache" level="error" additivity="false"/>
        <Logger name="org.quartz" level="error" additivity="false"/>
        <Logger name="org.hibernate" level="info" additivity="false"/>
        <Logger name="org.hibernate.SQL" level="debug" additivity="false">
            <AppenderRef ref="console" />
            <AppenderRef ref="infoFile"/>
            <AppenderRef ref="errorFile"/>
        </Logger>
        <Logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="trace" additivity="false">
            <AppenderRef ref="console" />
            <AppenderRef ref="infoFile"/>
            <AppenderRef ref="errorFile"/>
        </Logger>

        <Root level="info" includeLocation="true">
            <AppenderRef ref="console"/>
            <AppenderRef ref="infoFile"/>
            <AppenderRef ref="errorFile"/>
        </Root>
    </Loggers>


</configuration>
