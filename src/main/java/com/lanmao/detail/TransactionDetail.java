/*
 * 描述： <描述>
 * 修改人： Smile.wang
 * 修改时间： 2018年3月14日
 * 项目： demo
 */
package com.lanmao.detail;

/**
 * <功能简述><br>
 * <功能详细描述>
 * 
 * @author Smile.wang
 * @version [版本号, 2018年3月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TransactionDetail {
    /**业务类型*/
    private String bizType;
    /**预处理请求流水号；若出款方为平台账户，不进行预处理冻结金额，直接从平台账户划拨资金到收款方用户，则不传该参数。*/
    private String freezeRequestNo;
    /**出款方用户编号*/
    private String sourcePlatformUserNo;
    /** 收款方用户编号*/
    private String targetPlatformUserNo;
    /** 交易金额 （有利息时为本息和， amount为本金和利息之和）*/
    private String amount;
    /** 利息 （income为利息， 本金= amount — income）*/
    private String income;
    /** 债权份额（债权认购且需校验债权关系的必传）*/
    private String share;
    
    /**网贷平台自定义参数，平台交易时传入的自定义参数*/
    private String customDefine;
    
    /** 备注*/
    private String remark;
    /**业务类型*/
    public String getBizType() {
        return bizType;
    }
    /**业务类型*/
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    /**预处理请求流水号；若出款方为平台账户，不进行预处理冻结金额，直接从平台账户划拨资金到收款方用户，则不传该参数。*/
    public String getFreezeRequestNo() {
        return freezeRequestNo;
    }
    /**预处理请求流水号；若出款方为平台账户，不进行预处理冻结金额，直接从平台账户划拨资金到收款方用户，则不传该参数。*/
    public void setFreezeRequestNo(String freezeRequestNo) {
        this.freezeRequestNo = freezeRequestNo;
    }
    /**出款方用户编号*/
    public String getSourcePlatformUserNo() {
        return sourcePlatformUserNo;
    }
    /**出款方用户编号*/
    public void setSourcePlatformUserNo(String sourcePlatformUserNo) {
        this.sourcePlatformUserNo = sourcePlatformUserNo;
    }
    /** 收款方用户编号*/
    public String getTargetPlatformUserNo() {
        return targetPlatformUserNo;
    }
    /** 收款方用户编号*/
    public void setTargetPlatformUserNo(String targetPlatformUserNo) {
        this.targetPlatformUserNo = targetPlatformUserNo;
    }
    /** 交易金额 （有利息时为本息和， amount为本金和利息之和）*/
    public String getAmount() {
        return amount;
    }
    /** 交易金额 （有利息时为本息和， amount为本金和利息之和）*/
    public void setAmount(String amount) {
        this.amount = amount;
    }
    /** 利息 （income为利息， 本金= amount — income）*/
    public String getIncome() {
        return income;
    }
    /** 利息 （income为利息， 本金= amount — income）*/
    public void setIncome(String income) {
        this.income = income;
    }
    /** 债权份额（债权认购且需校验债权关系的必传）*/
    public String getShare() {
        return share;
    }
    /** 债权份额（债权认购且需校验债权关系的必传）*/
    public void setShare(String share) {
        this.share = share;
    }
    /**网贷平台自定义参数，平台交易时传入的自定义参数*/
    public String getCustomDefine() {
        return customDefine;
    }
    /**网贷平台自定义参数，平台交易时传入的自定义参数*/
    public void setCustomDefine(String customDefine) {
        this.customDefine = customDefine;
    }
    /** 备注*/
    public String getRemark() {
        return remark;
    }
    /** 备注*/
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((bizType == null) ? 0 : bizType.hashCode());
        result = prime * result + ((customDefine == null) ? 0 : customDefine.hashCode());
        result = prime * result + ((freezeRequestNo == null) ? 0 : freezeRequestNo.hashCode());
        result = prime * result + ((income == null) ? 0 : income.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
        result = prime * result + ((share == null) ? 0 : share.hashCode());
        result = prime * result + ((sourcePlatformUserNo == null) ? 0 : sourcePlatformUserNo.hashCode());
        result = prime * result + ((targetPlatformUserNo == null) ? 0 : targetPlatformUserNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionDetail other = (TransactionDetail) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (bizType == null) {
            if (other.bizType != null)
                return false;
        } else if (!bizType.equals(other.bizType))
            return false;
        if (customDefine == null) {
            if (other.customDefine != null)
                return false;
        } else if (!customDefine.equals(other.customDefine))
            return false;
        if (freezeRequestNo == null) {
            if (other.freezeRequestNo != null)
                return false;
        } else if (!freezeRequestNo.equals(other.freezeRequestNo))
            return false;
        if (income == null) {
            if (other.income != null)
                return false;
        } else if (!income.equals(other.income))
            return false;
        if (remark == null) {
            if (other.remark != null)
                return false;
        } else if (!remark.equals(other.remark))
            return false;
        if (share == null) {
            if (other.share != null)
                return false;
        } else if (!share.equals(other.share))
            return false;
        if (sourcePlatformUserNo == null) {
            if (other.sourcePlatformUserNo != null)
                return false;
        } else if (!sourcePlatformUserNo.equals(other.sourcePlatformUserNo))
            return false;
        if (targetPlatformUserNo == null) {
            if (other.targetPlatformUserNo != null)
                return false;
        } else if (!targetPlatformUserNo.equals(other.targetPlatformUserNo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TransactionDetail [bizType=" + bizType + ", freezeRequestNo=" + freezeRequestNo + ", sourcePlatformUserNo=" + sourcePlatformUserNo + ", targetPlatformUserNo=" + targetPlatformUserNo + ", amount=" + amount + ", income=" + income + ", share=" + share + ", customDefine=" + customDefine + ", remark=" + remark + "]";
    }
    
    
    
    
}
