package ${PACKAGE};


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
public class ${CLASSNAME} extends BaseController
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
        if(dto.getPageSize() > 0 && dto.getPageSize() < ${CONTANT_CLASSNAME}.MAX_NUMBER_ONE_PAGE)
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
