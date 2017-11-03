package ${PACKAGE};

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */

@Component
public class KeyGen${MODEL_CLASSNAME} implements EnvironmentAware{

    private static final long WORKER_ID_BITS = 6L;

    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);

    private static final long SEQUENCE_BITS = 6L;

    private static final long WORKER_ID_SHIFT = 6L;

    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    private final long sequenceMask = -1L ^ (-1L << SEQUENCE_BITS);
	
    ${workerId}
    private long workerId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    private final static long TWEPOCH = 1452866247339L;

    public KeyGen${MODEL_CLASSNAME}()
    {
        if(workerId > MAX_WORKER_ID || workerId < 0)
        {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
    }
    
    @Override
    public void setEnvironment(Environment environment)
    {
        workerId=NumberUtils.toLong(environment.getProperty("workerId"));
        if(workerId > MAX_WORKER_ID || workerId < 0)
        {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
    }

    public KeyGen${MODEL_CLASSNAME}(long workerId)
    {
        if(workerId > MAX_WORKER_ID || workerId < 0)
        {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        this.workerId=workerId;
    }

    public synchronized long nextId()
    {
        long timestamp = timeGen();
        if(timestamp < lastTimestamp)
        {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }
        if(lastTimestamp == timestamp)
        {
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0)
            {
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        else
        {
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        return (timestamp - TWEPOCH << TIMESTAMP_LEFT_SHIFT) | (workerId << WORKER_ID_SHIFT) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp)
    {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp)
        {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen()
    {
        return System.currentTimeMillis();
    }
    
    public static long minId(Date date){
        return (date.getTime() - TWEPOCH << TIMESTAMP_LEFT_SHIFT) | (0 << WORKER_ID_SHIFT) | 0;
    }
    
    public static long maxId(Date date){
        int w=(-1 ^ (-1 << WORKER_ID_BITS))<< WORKER_ID_SHIFT;
        int s=(-1 ^ (-1 << SEQUENCE_BITS));
        return (date.getTime() - TWEPOCH << TIMESTAMP_LEFT_SHIFT) | w | s;
    }
    
    public static Date getDate(long id){
        return new Date((id>> TIMESTAMP_LEFT_SHIFT) + TWEPOCH);
    }
	
    public static Date getSimpleDate(long id){
        return new Date(((id>> TIMESTAMP_LEFT_SHIFT) + TWEPOCH)/1000*1000);
    }
	
    public static String getSimpleString(long id){
        java.text.SimpleDateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date(((id>> TIMESTAMP_LEFT_SHIFT) + TWEPOCH)/1000*1000));
    }
}
