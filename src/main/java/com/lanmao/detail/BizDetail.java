/*
 * 描述： <描述>
 * 修改人： Smile.wang
 * 修改时间： 2018年3月14日
 * 项目： demo
 */
package com.lanmao.detail;

import java.util.List;

/**
 * 交易明细<br>
 * <功能详细描述>
 * 
 * @author Smile.wang
 * @version [版本号, 2018年3月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BizDetail {
    /**交易明细订单号*/
    private String requestNo;
    /**【交易类型】*/
    private String tradeType ;
    /**标的编号*/
    private String projectNo;
    /**债权出让请求流水号*/
    private String saleRequestNo;
    /**业务明细*/
    private List<TransactionDetail> details;
    /**业务明细*/
    public List<TransactionDetail> getDetails() {
        return details;
    }
    /**业务明细*/
    public void setDetails(List<TransactionDetail> details) {
        this.details = details;
    }
    /**交易明细订单号*/
    public String getRequestNo() {
        return requestNo;
    }
    /**交易明细订单号*/
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }
    /**【交易类型】*/
    public String getTradeType() {
        return tradeType;
    }
    /**【交易类型】*/
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    /**标的编号*/
    public String getProjectNo() {
        return projectNo;
    }
    /**标的编号*/
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
    /**债权出让请求流水号*/
    public String getSaleRequestNo() {
        return saleRequestNo;
    }
    /**债权出让请求流水号*/
    public void setSaleRequestNo(String saleRequestNo) {
        this.saleRequestNo = saleRequestNo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((projectNo == null) ? 0 : projectNo.hashCode());
        result = prime * result + ((requestNo == null) ? 0 : requestNo.hashCode());
        result = prime * result + ((saleRequestNo == null) ? 0 : saleRequestNo.hashCode());
        result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
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
        BizDetail other = (BizDetail) obj;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (projectNo == null) {
            if (other.projectNo != null)
                return false;
        } else if (!projectNo.equals(other.projectNo))
            return false;
        if (requestNo == null) {
            if (other.requestNo != null)
                return false;
        } else if (!requestNo.equals(other.requestNo))
            return false;
        if (saleRequestNo == null) {
            if (other.saleRequestNo != null)
                return false;
        } else if (!saleRequestNo.equals(other.saleRequestNo))
            return false;
        if (tradeType == null) {
            if (other.tradeType != null)
                return false;
        } else if (!tradeType.equals(other.tradeType))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "BizDetail [requestNo=" + requestNo + ", tradeType=" + tradeType + ", projectNo=" + projectNo + ", saleRequestNo=" + saleRequestNo + ", details=" + details + "]";
    }
   
  
    
    
    
}
