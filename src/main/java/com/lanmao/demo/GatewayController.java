package com.lanmao.demo;

import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lanmao.common.AppConfig;
import com.lanmao.common.AppUtil;

/**
 * 网关接口DEMO
 * 
 * @author Iren08
 * @date 2017年3月8日 下午8:31:29
 * @version 1.0
 */
@Controller
@RequestMapping("/gateway")
public class GatewayController {
    
    private final static Logger logger = LoggerFactory
            .getLogger(GatewayController.class);
    
    private static final DateFormat format = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    
    /**
     * 网关接口后缀
     */
    private final static String GATEWAY = "/gateway";
    
    /**
     * 充值接口
     * 
     * @param request 前台传输的参数
     * @return 返回post页面进行提交
     */
    @RequestMapping("/doRecharge.do")
    public ModelAndView doRecharge(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String amount = request.getParameter("amount");
        String commission = request.getParameter("commission");
        String expectPayCompany = request.getParameter("expectPayCompany");
        String rechargeWay = request.getParameter("rechargeWay");
        String bankcode = request.getParameter("bankcode");
        String expired = request.getParameter("expired");
        String callbackMode = request.getParameter("callbackMode");
        String redirectUrl = request.getParameter("redirectUrl");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("amount", amount);
        reqData.put("commission", commission);
        reqData.put("expectPayCompany", expectPayCompany);
        reqData.put("rechargeWay", rechargeWay);
        reqData.put("bankcode", bankcode);
        reqData.put("expired", expired);
        reqData.put("callbackMode", callbackMode);
        reqData.put("redirectUrl", redirectUrl);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("RECHARGE", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        String url = config.getUrl() + GatewayController.GATEWAY;
        
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 提现接口<br>
     * <功能详细描述>
     *
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月15日]
     * @author Jane.zhu
     */
    @RequestMapping("/doWithdraw.do")
    public ModelAndView doWithdraw(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();

        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String expired = request.getParameter("expired");
        String redirectUrl = request.getParameter("redirectUrl");
        String withdrawType = request.getParameter("withdrawType");
        String withdrawForm = request.getParameter("withdrawForm");
        String amount = request.getParameter("amount");
        String commission = request.getParameter("commission");

        // 后台生成
        String requestNo = format.format(new Date());

        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("commission", commission);
        reqData.put("expired", expired);
        reqData.put("redirectUrl", redirectUrl);
        reqData.put("withdrawType", withdrawType);
        reqData.put("withdrawForm", withdrawForm);
        reqData.put("amount", amount);
        reqData.put("commission", commission);

        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));

        // 必须添加的参数
        reqData.put("timestamp", requestNo);

        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("WITHDRAW", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        String url = config.getUrl() + GatewayController.GATEWAY;

        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    
    
    /**
     * 
     * 个人绑卡注册<br>
     * 用户在网贷平台注册完成后，网贷平台引导个人用户 跳转到存管系统页面填写四要素信息、设置交易密码、进行银行卡及身份鉴权， 
     * 认证成功后开通存管账户。（也支持平台透传用户四要素信息，但在存管系统页面不支持修改）
     *
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/personal_register_expand.do")
    public ModelAndView personalRegisterExpand(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String realName = request.getParameter("realName");
        String idCardType = request.getParameter("idCardType");
        String userRole = request.getParameter("userRole");
        String idCardNo = request.getParameter("idCardNo");
        String mobile = request.getParameter("mobile");
        String bankcardNo = request.getParameter("bankcardNo");
        String checkType = request.getParameter("checkType");
        String redirectUrl = request.getParameter("redirectUrl");
        String userLimitType = request.getParameter("userLimitType");
        String authList = request.getParameter("authList");
        String amount = request.getParameter("amount");
        String failTime = request.getParameter("failTime");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("realName", realName);
        reqData.put("idCardType", idCardType);
        reqData.put("userRole", userRole);
        reqData.put("idCardNo", idCardNo);
        reqData.put("mobile", mobile);
        reqData.put("bankcardNo", bankcardNo);
        reqData.put("checkType", checkType);
        reqData.put("redirectUrl", redirectUrl);
        reqData.put("userLimitType", userLimitType);
        reqData.put("authList", authList);
        reqData.put("amount", amount);
        reqData.put("failTime", failTime);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("PERSONAL_REGISTER_EXPAND", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 
     * 个人绑卡<br>
     * 操作过 解绑的个人用户通操作过 解绑的个人用户通网贷平台发起绑卡请求， 网贷 平台调用此接口引导户跳转进入存管个人绑卡页 
     * 平台调用此接口引导户跳转进入存管个人绑卡页 平台调用此接口引导户跳转进入存管个人绑卡页 平台调用此接口引导户跳转进入存管个人绑卡页 面， 
     * 输入新的银行卡号、预留手机验证码； 短信验证通过且四要素鉴权通过则绑卡成功
     *  attention: 
     *  R1. 只有已解绑用户允许发起卡； 
     *  R2. 只允许绑定用户本人名下的借记卡； 
     *  R3.只支持身份证个人用户绑卡； 
     *  R4. 非身份证个人用户需要发邮件申请绑卡 ，由银行存管的运营人员工审核 ；
     *
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/personal_bind_bankcard_expand.do")
    public ModelAndView personalBindBankCardExpand(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String mobile = request.getParameter("mobile");
        String bankcardNo = request.getParameter("bankcardNo");
        String checkType = request.getParameter("checkType");
        String redirectUrl = request.getParameter("redirectUrl");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("mobile", mobile);
        reqData.put("bankcardNo", bankcardNo);
        reqData.put("checkType", checkType);
        reqData.put("redirectUrl", redirectUrl);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("PERSONAL_BIND_BANKCARD_EXPAND", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 
     * 解绑银行卡<br>
     * 平台调用该接口引导用户跳转至存管页面，输入交易密码、手机验证码，验证通过以后解绑成功。 
     * attention: 
     *   R1.用户账户激活可用；
     *   R2.用户已经绑卡；
     *   R3.该接口只验证用户交易密码与手机验证码，平台针对用户解绑需要主动设置审核机制； 
     *   R4.若为平台功能账户解绑，则只需在页面上输入联系人手机验证码，验证通过则解绑成功；
     *
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/personal_unbind_bankcard_expand.do")
    public ModelAndView personalUnBindBankCardExpand(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String redirectUrl = request.getParameter("redirectUrl");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("redirectUrl", redirectUrl);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("UNBIND_BANKCARD", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 
     * 预留手机号更新<br>
     * 用户通过此接口进行 银行 预留手 机号修改，平台调用此接口引导户跳转至存管系统页面填写新预留手 机号修改，
     * 平台调用此接口引导户跳转至存管系统页面填写新预留手 机号修改， 平台调用此接口引导户跳转至存管系统页面填写新机 号，
     * 输入手验证码通过，存管 系统 做四要素鉴权，通过则手机号修改成功；
     *  attention: 
     *   R1. 用户存在且已激活，手机号 需要对应绑定卡片的银行预留；
     *   R2.只支持个人身份证用户 ； 
     *   R3. 预留手机号 更新会做四要素鉴权，通过才能成功修改。
     * 
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/modify_mobile_expand.do")
    public ModelAndView modifyMobileExpand(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String checkType = request.getParameter("checkType");
        String redirectUrl = request.getParameter("redirectUrl");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("checkType", checkType);
        reqData.put("redirectUrl", redirectUrl);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("MODIFY_MOBILE_EXPAND", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 
     * 用户预处理<br>
     * 1.预先冻结用户部分资金，用于出借、还款、代偿、债权认购、还代偿款； 2.平台发起上述5个业务前，需要先调用本接口提交预处理请求，用户将跳转至存管系统预处理页面，验证交易密码后，冻结预处理金额 
     * R1. 对于新创建的标的，【预处理业务类型】可使用枚举值： 出借 、还款、 债权认购 、代偿、还代偿 款 ； 
     * R2. 出借 预处理时，冻结金额 + 红包金额≤标的金额 - 累计已 出借 金额；
     * R3.债权认购预处理时，share≤原债权出让订单未被认购份额。
     * 
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月15日]
     * @author Smile.wang
     */
    @RequestMapping("/user_pre_transaction.do")
    public ModelAndView userPreTransaction(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String bizType = request.getParameter("bizType");
        String redirectUrl = request.getParameter("redirectUrl");
        String Amount = request.getParameter("Amount");
        String preMarketingAmount = request.getParameter("preMarketingAmount");
        String Remark = request.getParameter("Remark");
        String projectNo = request.getParameter("projectNo");
        String Share = request.getParameter("Share");
        String creditsaleRequestNo = request.getParameter("creditsaleRequestNo");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("bizType", bizType);
        reqData.put("redirectUrl", redirectUrl);
        reqData.put("amount", Amount);
        reqData.put("preMarketingAmount", null);
        reqData.put("Remark", Remark);
        reqData.put("projectNo", projectNo);
        reqData.put("Share", null);
        reqData.put("creditsaleRequestNo", null);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("USER_PRE_TRANSACTION", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    /**
     * 
     * 重置交易密码<br>
     * 平台调用该接口引导用户跳转至存管页面，输入原交易密码或银行卡信息认证校验身份，校验通过后设置新的交易密码
     * attention: 
     *   R1.用户可以在页面上选择忘记原密码或记得原密码；
     *   R2.如果用户选择记得原密码，则输入原密码验证，并设置新密码，原密码校验通过则新密码设置成功；
     *   R3.已绑卡个人用户选择忘记原密码，若该用户绑定银行卡为四要素鉴权通过，则用户输入完整银行卡号，通过银行预留手机号进行短信验证，验证通过后设置新密码； 
     *   R4.已绑卡企业用户选择忘记密码，则用户输入完整银行对公号，通过企业联系人手机号进行短信验证，验证通过后设置新密码；
     *   R5.如果用户未绑定银行卡或银行对公号，则提示用户未绑定银行卡，平台需引导用户绑定银行卡或银行对公号，然后再进行密码修改；
     *
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/updatePassword.do")
    public ModelAndView resetPassword(HttpServletRequest request) {
        // 获取properties参数
        AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        
        // 前台获取参数
        String platformUserNo = request.getParameter("platformUserNo");
        String redirectUrl = request.getParameter("redirectUrl");
        
        // 后台生成
        String requestNo = format.format(new Date());
        
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("requestNo", requestNo);
        reqData.put("redirectUrl", redirectUrl);
        
        // 计算页面过期时间 当前时间增加30分钟
        DateTime dateTime = new DateTime();
        reqData.put("expired",
                dateTime.plusMinutes(30).toString("yyyyMMddHHmmss"));
        
        // 必须添加的参数
        reqData.put("timestamp", requestNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("RESET_PASSWORD", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String url = config.getUrl() + GatewayController.GATEWAY;
        return new ModelAndView("reqeust/gatewayPost").addObject("result",
                result).addObject("url", url);
    }
    
    
}
