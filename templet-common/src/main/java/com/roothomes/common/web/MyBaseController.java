package com.roothomes.common.web;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.apec.framework.base.BaseController;
import com.apec.framework.common.PageJSON;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.dto.BaseDTO;


public class MyBaseController extends BaseController
{

    protected PageRequest genPageRequest(BaseDTO dto)
    {
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        int pageNumber = 1;
        int pageSize = 10;
        if(dto.getPageNumber() > 0)
        {
                pageNumber = dto.getPageNumber();
        }
        if(dto.getPageSize() > 0 && dto.getPageSize() < 100)
        {
            pageSize = dto.getPageSize();
        }
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return pageRequest;
    }
    
    public <T> T getFormJSON(String json,Class<T> clz)
    {
        Object formJSOn = JsonUtil.getValueBykey(json, "formJSON");
        if(null==formJSOn) //服务调用
        {
            return JsonUtil.parseObject(json, clz);
        }
        else //面面调用
        {
            PageJSON<T> pageJSON = getPageJSON(json, clz);
            return pageJSON.getFormJSON();
        }
    }
    
    public String getUserId(String json)
    {
        Object formJSOn = JsonUtil.getValueBykey(json, "formJSON");
        if(null==formJSOn) //服务调用
        {
            return "0";
        }
        else //面面调用
        {
            PageJSON<Object> pageJSON = getPageJSON(json, Object.class);
            return getUserNo(pageJSON);
        }
    }
}
