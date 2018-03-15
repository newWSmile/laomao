/*
 * 描述： <描述>
 * 修改人： Smile.wang
 * 修改时间： 2018年3月15日
 * 项目： demo
 */
package com.lanmao.enumType;

/**
 * 标的类型<br>
 * 
 * @author Smile.wang
 * @version [版本号, 2018年3月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum LoanEnum {
    
    普通标的("STANDARDPOWDER"), 受托支付标的("FIDUCIARYPOWDER");
    
    private String name;
    
    private LoanEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
