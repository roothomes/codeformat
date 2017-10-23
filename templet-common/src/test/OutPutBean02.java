package com.apec.notice.model;


/** JPA列注解 */
import javax.persistence.Column;
/** JPA实体注解 */
import javax.persistence.Entity;
/** JPA表注解 */
import javax.persistence.Table;
/** hibernate动态更新 */
import org.hibernate.annotations.DynamicUpdate;
/** hibernate自动生成 */
import org.hibernate.annotations.GenericGenerator;
/** 平台常量类 */
import com.apec.framework.common.Constants;
/** 平台基础模型 */
import com.apec.framework.jpa.model.BaseModel;
import java.lang.String;
import java.lang.Integer;
import java.lang.Double;


/** JPA实体注解 */
@Entity
/** hibernate动态更新 */
@DynamicUpdate
/** hibernate自动生成 */
@GenericGenerator(name = Constants.SYSTEM_GENERATOR, strategy = Constants.ASSIGNED)
/** JPA表注解 */
@Table(name = "notice", catalog = "cncsen")
public class Notice extends BaseModel<String>
{
    private static final long serialVersionUID = 1L;


    /** 属性1名称 */
    @Column(name = "t_x_01")
    private String name;

    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    /** 属性2名称 */
    @Column(name = "t_x_02")
    private Integer key;

    public void setkey(Integer key) {
        this.key = key;
    }

    public Integer getkey() {
        return key;
    }

    /** 属性3名称 */
    @Column(name = "t_x_03")
    private Double val;

    public void setval(Double val) {
        this.val = val;
    }

    public Double getval() {
        return val;
    }




}
