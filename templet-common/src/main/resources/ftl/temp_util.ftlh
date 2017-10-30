package ${PACKAGE};

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

<#list PACKAGES as p>
import ${p.importPackage};
</#list>
/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
public class ${CLASSNAME} implements ${CONTANT_CLASSNAME}{

    private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object bean)
    {
        try
        {
            if(null!=bean)
            {
                return  mapper.writeValueAsString(bean);
            }
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        if(bean instanceof Array || bean instanceof Iterable){
            return "[]";
        }
        return "{}";
    }

    public static <T> T fromJson(String json,Class<T>clz)
    {
        try
        {
            if(null!=json)
            {
                return  mapper.readValue(json, clz);
            }
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> ArrayList<T> fromJsonArray(String json,Class<T>clz)
    {
        try
        {
            if(null!=json)
            {
                return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clz));
            }
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
