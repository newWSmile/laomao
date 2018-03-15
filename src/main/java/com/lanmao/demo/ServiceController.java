package com.lanmao.demo;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lanmao.common.AppConfig;
import com.lanmao.common.AppUtil;
import com.lanmao.common.HttpUtils;
import com.lanmao.common.SignatureAlgorithm;
import com.lanmao.common.SignatureUtils;
import com.lanmao.detail.BizDetail;
import com.lanmao.detail.TransactionDetail;
import com.lanmao.enumType.TransactionEnum;

/**
 * 直连接口Demo
 * 
 * @author Iren08
 * @date 2017年3月8日 下午3:18:36
 * @version 1.0
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

	private final static Logger logger = LoggerFactory
			.getLogger(ServiceController.class);
	
	private static final DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private AppConfig config = AppConfig.getConfig();

	/**
	 * 直连接口后缀
	 */
	private final static String SERVICE = "/service";

	/**
	 * 用户查询接口
	 * 
	 * @param request
	 *            前台传输的参数
	 * @return 返回post页面进行提交
	 */
	@RequestMapping("/doQueryUser.do")
	public ModelAndView doQueryUser(HttpServletRequest request) {
//		AppConfig config = AppConfig.getConfig();
		// 定义reqData参数集合
		Map<String, Object> reqData = new HashMap<String, Object>();
		String platformUserNo = request.getParameter("platformUserNo");
		reqData.put("platformUserNo", platformUserNo);
		reqData.put("timestamp", format.format(new Date()));

		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam("QUERY_USER_INFORMATION", reqData);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		return new ModelAndView("reqeust/servicePost").addObject("result",
				result);
	}
	

    @RequestMapping("/sync_transaction.do")
    public ModelAndView syncTransaction(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        String platformUserNo = request.getParameter("platformUserNo");
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        //见【交易类型】
        String tradeType = TransactionEnum.TENDER.toString();
        reqData.put("tradeType",tradeType);
        //标的号 可以不传 
        String projectNo = request.getParameter("projectNo");
        reqData.put("projectNo",projectNo);
        //债权出让请求流水号  可以不传 
        String saleRequestNo= "";
        reqData.put("saleRequestNo",null);
        TransactionDetail detailItem_001 = new TransactionDetail();
        detailItem_001.setBizType("TENDER");
        detailItem_001.setAmount("20.00");
        detailItem_001.setFreezeRequestNo("20180314172241");
        detailItem_001.setSourcePlatformUserNo("7000002954");
        detailItem_001.setTargetPlatformUserNo("7000002955");
        List<TransactionDetail> detailList = new ArrayList<>();
        detailList.add(detailItem_001);
        reqData.put("details", detailList);

        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("SYNC_TRANSACTION", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
    
    
    
    
    @RequestMapping("/async_transaction.do")
    public ModelAndView asyncTransaction(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求批次号
        String batchNo = format.format(new Date());
        reqData.put("batchNo",batchNo);
        
        
        
        TransactionDetail detailItem_001 = new TransactionDetail();
        detailItem_001.setBizType("TENDER");
        detailItem_001.setAmount("20.00");
        detailItem_001.setFreezeRequestNo("20180314172241");
        detailItem_001.setSourcePlatformUserNo("7000002954");
        detailItem_001.setTargetPlatformUserNo("7000002955");
        List<TransactionDetail> detailList = new ArrayList<>();
        detailList.add(detailItem_001);
        
        List<BizDetail> bizDetailList = new ArrayList<>();
        BizDetail bizDetail  = new BizDetail();
        bizDetail.setRequestNo(format.format(new Date()));
        bizDetail.setTradeType(TransactionEnum.TENDER.toString());
        bizDetail.setProjectNo("1002");
        bizDetail.setSaleRequestNo(null);
        bizDetail.setDetails(detailList);
        bizDetailList.add(bizDetail);
        
        
        reqData.put("bizDetails", bizDetailList);

        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("ASYNC_TRANSACTION", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
    
    
    /**
     * 标的登记<br>
     * <功能详细描述>
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
    @RequestMapping("/establish_project.do")
    public ModelAndView establishProject(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        String platformUserNo = request.getParameter("platformUserNo");
        reqData.put("platformUserNo", platformUserNo);
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        String projectNo = request.getParameter("projectNo");
        reqData.put("projectNo",projectNo);
        String projectAmount = request.getParameter("projectAmount");
        reqData.put("projectAmount",projectAmount);
        String projectName = request.getParameter("projectName");
        reqData.put("projectName",projectName);
        String projectDescription = request.getParameter("projectDescription");
        reqData.put("projectDescription",projectDescription);
        String projectType = request.getParameter("projectType");
        reqData.put("projectType",projectType);
        String projectPeriod = request.getParameter("projectPeriod");
        reqData.put("projectPeriod",projectPeriod);
        String annualInterestRate = request.getParameter("annualInterestRate");
        reqData.put("annualInterestRate",annualInterestRate);
        String repaymentWay = request.getParameter("repaymentWay");
        reqData.put("repaymentWay",repaymentWay);
        String extend = request.getParameter("extend");
        reqData.put("extend",null);
        String productType = request.getParameter("productType");
        reqData.put("productType",productType);
        
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("ESTABLISH_PROJECT", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
	
    
    
    /**
     * 变更标的<br>
     * 平台通过此接口变更标的状态
     * attention:
     * R1.募集中状态允许用户预处理业务（出借/债权出让/债权认购）、授权预处理业务（出借）、取消出借、放款（出借确认）、债权认购确认；
     * R2.还款中状态允许用户预处理业务（还款/代偿/债权出让/债权认购/还代偿款）、还款确认、代偿确认、债权认购确认、还代偿款确认；
     * R3.标的状态为已截标/流标的标的不允许用户操作任何标的业务；
     * R4.标的状态变更顺序为：募集中→还款中→已截标；或募集中→流标，标的状态不可逆向更改。
     * @param request
     * @return
     * 
     * @return ModelAndView [返回类型说明]
     * @throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @version [版本号, 2018年3月14日]
     * @author Smile.wang
     */
    @RequestMapping("/modify_project.do")
    public ModelAndView modifyProject(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        String projectNo = request.getParameter("projectNo");
        reqData.put("projectNo",projectNo);
        String status = request.getParameter("status");
        reqData.put("status",status);
        
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("MODIFY_PROJECT", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }

    
    /**
     * 
     * 资金冻结<br>
     * 平台调用此接口冻结指定用户账户的资金（用于紧急风险处理）
     * attention:
     * R1.用户可用余额充足
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
    @RequestMapping("/freeze.do")
    public ModelAndView freeze(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        String platformUserNo = request.getParameter("platformUserNo");
        reqData.put("platformUserNo",platformUserNo);
        String amount = request.getParameter("amount");
        reqData.put("amount",amount);
        
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("FREEZE", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
    
    
    
    
    @RequestMapping("/unfreeze.do")
    public ModelAndView unfreeze(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        String originalFreezeRequestNo = request.getParameter("originalFreezeRequestNo");
        reqData.put("originalFreezeRequestNo",originalFreezeRequestNo);
        String amount = request.getParameter("amount");
        reqData.put("amount",amount);
        
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("UNFREEZE", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
    
    /**
     * 
     * 交易密码解冻<br>
     * 用户在存管系统页面累计输入错误密码5次以后交易密码会被冻结，可以调用此接口进行直接解冻；
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
    @RequestMapping("/unfreeze_trade_password.do")
    public ModelAndView unfreezeTradePassword(HttpServletRequest request) {
//      AppConfig config = AppConfig.getConfig();
        // 定义reqData参数集合
        Map<String, Object> reqData = new HashMap<String, Object>();
        reqData.put("timestamp", format.format(new Date()));
        // 后台生成   请求流水号
        String requestNo = format.format(new Date());
        reqData.put("requestNo",requestNo);
        
        String platformUserNo = request.getParameter("platformUserNo");
        reqData.put("platformUserNo",platformUserNo);
        
        Map<String, String> result = null;
        try {
            result = AppUtil.createPostParam("UNFREEZE_TRADE_PASSWORD", reqData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView("reqeust/servicePost").addObject("result",
                result);
    }
    
	/**
	 * 公用的直连接口方法<br>
	 * HTTP请求返回数据然后传回前台显示
	 * 
	 * @param request
	 *            请求参数
	 * @return 接口返回值
	 */
	@ResponseBody
	@RequestMapping(value = "/serviceRequest.do", produces = "application/json; charset=utf-8")
	public String serviceRequest(HttpServletRequest request) {
		String result = "";
		CloseableHttpResponse response = null;
		
		String url = config.getUrl() + ServiceController.SERVICE;

		try {
			List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
			BasicNameValuePair bn2 = new BasicNameValuePair("serviceName",request.getParameter("serviceName"));
			BasicNameValuePair bn5 = new BasicNameValuePair("platformNo",request.getParameter("platformNo"));
			BasicNameValuePair bn3 = new BasicNameValuePair("reqData",request.getParameter("reqData"));
			BasicNameValuePair bn = new BasicNameValuePair("keySerial","1");
			BasicNameValuePair bn4 = new BasicNameValuePair("sign",request.getParameter("sign"));
			formparams.add(bn);formparams.add(bn2);formparams.add(bn3);formparams.add(bn4);formparams.add(bn5);
			
			response = HttpUtils.httpPostWithPAaram(url,formparams);
			result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			logger.info("response : " + result);
			
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(response);
		}
		
		try {
			verifySign(response, result);
			//平台业务处理逻辑，此处省略。。。。。。
			
		} catch (Exception e) {
			logger.error("sign fail..... " + e.getMessage());
			//异常处理
		}
		return result;
	}
	
	private void verifySign(CloseableHttpResponse response, String responseData) throws Exception {
		
		Map<String, Object> respMap = JSON.parseObject(responseData);
		//接口返回code!=0 || status!=SUCCESS时，不做验签处理
		if( !"0".equals(respMap.get("code")) || 
				!"SUCCESS".equals(respMap.get("status"))) {
			
			return;
		}
		
		//校验返回报文
		String returnSign = "";
		Header[] headers = response.getHeaders("sign");
		if (headers != null && headers.length > 0) {
			Header header = headers[0];
			returnSign = header.getValue();
		}
		
		byte[] keyByte = Base64.decodeBase64(config.getLmPublicKey());
		byte[] signByte = Base64.decodeBase64(returnSign);
		try {
			PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(keyByte);

			boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, responseData, signByte);
			if (!b) {
				throw new Exception("验签失败，sign与respData不匹配");
			}
			
			logger.info("sign success ...");
		} catch (InvalidKeySpecException e) {
			throw new InvalidKeySpecException("验签错误，生成商户公钥失败", e);
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException("验签错误" + e.getMessage(), e);
		} catch (GeneralSecurityException e) {
			throw new GeneralSecurityException("验签错误" + e.getMessage(), e);
		}
		
	}
	
}
