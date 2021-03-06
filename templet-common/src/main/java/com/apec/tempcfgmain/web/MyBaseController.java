package com.apec.tempcfgmain.web;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.apec.tempcfgmain.model.TempCfgMain;
import com.apec.tempcfgmain.dto.TempCfgMainDTO;
import com.apec.tempcfgmain.vo.TempCfgMainVo;
import com.apec.tempcfgmain.constants.TempCfgMainContant;
import com.apec.tempcfgmain.util.TempCfgMainUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.apec.framework.base.BaseController;
import com.apec.framework.common.PageJSON;
import com.apec.framework.common.util.JsonUtil;
import com.apec.framework.dto.BaseDTO;
/**
 * 类 编 号：BL_PU10000_10_basecontroller
 * 类 名 称：MyBase4CodeTempletItemController
 * 内容摘要：业务模型BaseController类
 * @author roothomes
 * @date 2017-10-30
 */
public class MyBaseController extends BaseController
{

    protected PageRequest genPageRequest(BaseDTO dto)
    {
    	 Sort sort4 = new Sort(Sort.Direction.ASC, "cityId");
         Sort sort = new Sort(Sort.Direction.DESC, "orderNumber");
         Sort sort2 = new Sort(Sort.Direction.DESC, "status");
         Sort sort3 = new Sort(Sort.Direction.ASC, "createDate");
        
        int pageNumber = 1;
        int pageSize = 10;
        if(dto.getPageNumber() > 0)
        {
                pageNumber = dto.getPageNumber();
        }
        if(dto.getPageSize() > 0 && dto.getPageSize() < TempCfgMainContant.MAX_NUMBER_ONE_PAGE)
        {
            pageSize = dto.getPageSize();
        }
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, sort);
        return pageRequest;
    }

	@Override
    public <T> T getFormJSON(String json,Class<T> clz)
    {
        Object formJSOn = JsonUtil.getValueBykey(json, "formJSON");
        if(null==formJSOn)
        {
            return JsonUtil.parseObject(json, clz);
        }
        else
        {
            PageJSON<T> pageJSON = getPageJSON(json, clz);
            return pageJSON.getFormJSON();
        }
    }
    
    public String getUserId(String json)
    {
        Object formJSOn = JsonUtil.getValueBykey(json, "formJSON");
        if(null==formJSOn)
        {
            return "0";
        }
        else
        {
            PageJSON<Object> pageJSON = getPageJSON(json, Object.class);
            return getUserNo(pageJSON);
        }
    }
}
