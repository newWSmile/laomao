/*
 * 描述： <描述>
 * 修改人： Smile.wang
 * 修改时间： 2018年3月14日
 * 项目： demo
 */
package com.lanmao.enumType;

/**
 * 交易类枚举<br>
 * <功能详细描述>
 * 
 * @author Smile.wang
 * @version [版本号, 2018年3月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum TransactionEnum {
    /** 出借*/
    TENDER,
    /** 还款 */
    REPAYMENT,
    
    /** 债权认购*/
    CREDIT_ASSIGNMENT,
    /** 独立 分润*/
    PLATFORM_INDEPENDENT_PROFIT ,
    
    /** 直接代偿*/
    COMPENSATORYCOMPENSATORY ,
    
    /** 间接代偿*/
    INDIRECT_COMPENSATORY,
    
    /**平台营销款*/
    MARKETING,
    /**收费*/
    PLATFORM_SERVICE_DEDUCT ,
    /**平台资 金划拨*/
    FUNDS_TRANSFER ;
}
