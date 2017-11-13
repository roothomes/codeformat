package com.apec.codetemplet.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.apec.codetemplet.model.Codetemplet;
import com.apec.codetemplet.dto.CodetempletDTO;
import com.apec.codetemplet.vo.CodetempletVo;
import com.apec.codetemplet.constants.CodetempletContant;
import com.apec.codetemplet.util.CodetempletUtil;
import com.apec.framework.common.PageDTO;
/**
 * 类 编 号：BL_PU6030202_1000_util
 * 类 名 称：CodetempletUtil
 * 内容摘要：业务模型Util类,里面包含业务常用的方法
 * @author roothomes
 * @date 2017-10-30
 */
public class CodetempletUtil implements CodetempletContant{

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
