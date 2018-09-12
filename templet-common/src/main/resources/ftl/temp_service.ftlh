package ${PACKAGE};

<#list PACKAGES as p>
<#if p.desc??>/** ${p.desc} */</#if>
import ${p.importPackage};
</#list>


/**
 * 类 编 号：${CLASS_SERIALNO}
 * 类 名 称：${CLASSNAME}
 * 内容摘要：${CLASSNAME_DESC}
 * @author ${CREAT_AUTHOR}
 * @date ${CREAT_DATE}
 */
public interface ${CLASSNAME} {
    /**
     * 创建一个对象
     * @param vo 对象
     * @return
	 * @throws Exception
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    ${VO_CLASSNAME} create(${VO_CLASSNAME} vo) throws Exception;
	
    /**
     * 逻辑删除一个对象
     * @param id 主键id
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    void delete(${PK_ID_TYPE} id);
	
    /**
     * 更新排序
     * @param id 主键id
     * @param orderNumber
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    ${MODEL_CLASSNAME} updateOrderNumber(${PK_ID_TYPE} id, Integer orderNumber);
	
    /**
     * 更新状态
     * @param id 主键id
     * @param status 状态
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    ${MODEL_CLASSNAME} updateStatus(${PK_ID_TYPE} id, String status);
	
    /**
     * 更新对象模型
     * @param vo 对象
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    ${MODEL_CLASSNAME} updateObject(${MODEL_CLASSNAME} vo);

    /**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    PageDTO<${DTO_CLASSNAME}> seachPageDto(${VO_CLASSNAME} vo, PageRequest pageRequest);
	
	/**
     * 分页查询数据
     * @param vo 查询模型
     * @param pageRequest 分页请求
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    PageDTO<${MODEL_CLASSNAME}> seachPageModel(${VO_CLASSNAME} vo, PageRequest pageRequest);
	
    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    ${MODEL_CLASSNAME} findOne(${PK_ID_TYPE} id);

    /**
     * 查询数据列表
     * @param vo
     * @return
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    List<${MODEL_CLASSNAME}> queryAll(${VO_CLASSNAME} vo);
	
	/**
     * 后台任务刷新对象模型所有数据
     * @param entity
     * @author ${CREAT_AUTHOR}
     * @date ${CREAT_DATE}
     */
    void flushCacheJob(${MODEL_CLASSNAME} entity);
}
