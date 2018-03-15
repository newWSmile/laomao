package com.lanmao.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.lanmao.common.AppConfig;
import com.lanmao.common.SignatureAlgorithm;
import com.lanmao.common.SignatureUtils;

/**
 * 异步通知接口
 * 
 * @author Iren08
 * @date 2017年3月8日 下午9:28:41
 * @version 1.0
 */
@Controller
@RequestMapping("/notify")
public class NotifyController {
	
	private final static Logger logger = LoggerFactory
			.getLogger(NotifyController.class);

	@RequestMapping(value = "/notify.do")
	public String notify(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		AppConfig config = AppConfig.getConfig();
		String respData = request.getParameter("respData");
		logger.info("receive notify content : " + respData);
		try {
			// 验签
			PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64
					.decodeBase64(config.getLmPublicKey()));
			boolean verify = SignatureUtils.verify(
					SignatureAlgorithm.SHA1WithRSA, publicKey, respData,
					Base64.decodeBase64(request.getParameter("sign")));
			if (verify) {
				logger.info("sign success !!");
				Map<String, Object> respMap = JSON.parseObject(respData);
				String code = (String) respMap.get("code");
				if (("0").equals(code)
						&& "SUCCESS".equals((String) respMap.get("status"))) {
					// 请求受理或处理成功，根据不同接口处理
					
					// 备注：：：：：需判断金额是否相同 amount与请求是否相等
					//异步进行业务处理 线程处理 OR Rabbitmq
					new Thread(new Runnable() {
						public void run() {
							//do business ...
						}
					});
					//回调类型，用来区分是浏览器返还服务端异步通知
					if ("NOTIFY".equals(request.getParameter("responseType"))) {
						// 异步通知返回SUCCESS
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().write("SUCCESS");
					} else if ("DIRECT_CALLBACK".equals(request.getParameter("responseType"))) {
						// 同步通知 返回页面
						// 设置返回的参数
						model.addAttribute("message", "支付成功");
						return "success";
					}
				}
			} else {
				// 验签失败
				return null;
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * 个人绑卡注册回调<br>
	 * <功能详细描述>
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @return String [返回类型说明]
	 * @throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @version [版本号, 2018年3月14日]
	 * @author Smile.wang
	 */
	@RequestMapping(value = "/personal_register_notify.do")
    public String personalRegisterNotify(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        
        AppConfig config = AppConfig.getConfig();
        String respData = request.getParameter("respData");
        logger.info("receive notify content : " + respData);
        try {
            // 验签
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64
                    .decodeBase64(config.getLmPublicKey()));
            boolean verify = SignatureUtils.verify(
                    SignatureAlgorithm.SHA1WithRSA, publicKey, respData,
                    Base64.decodeBase64(request.getParameter("sign")));
            if (verify) {
                logger.info("sign success !!");
                Map<String, Object> respMap = JSON.parseObject(respData);
                String code = (String) respMap.get("code");
                if (("0").equals(code)
                        && "SUCCESS".equals((String) respMap.get("status"))) {
                    // 请求受理或处理成功，根据不同接口处理
                    
                    // 备注：：：：：需判断金额是否相同 amount与请求是否相等
                    //异步进行业务处理 线程处理 OR Rabbitmq
                    new Thread(new Runnable() {
                        public void run() {
                            //do business ...
                        }
                    });
                    
                    if ("NOTIFY".equals(request.getParameter("responseType"))) {
                        // 异步通知返回SUCCESS
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("SUCCESS");
                    } else if ("DIRECT_CALLBACK".equals(request.getParameter("responseType"))) {
                        // 同步通知 返回页面
                        // 设置返回的参数
                        model.addAttribute("message", "个人开户成功");
                        return "success";
                    }
                }
            } else {
                // 验签失败
                return null;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	
	/**
	 * 
	 * 个人绑卡回调<br>
	 * <功能详细描述>
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @return String [返回类型说明]
	 * @throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @version [版本号, 2018年3月14日]
	 * @author Smile.wang
	 */
	@RequestMapping(value = "/personal_bind_bankCard_notify.do")
    public String personalBindBankCardNotify(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        
        AppConfig config = AppConfig.getConfig();
        String respData = request.getParameter("respData");
        logger.info("receive notify content : " + respData);
        try {
            // 验签
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64
                    .decodeBase64(config.getLmPublicKey()));
            boolean verify = SignatureUtils.verify(
                    SignatureAlgorithm.SHA1WithRSA, publicKey, respData,
                    Base64.decodeBase64(request.getParameter("sign")));
            if (verify) {
                logger.info("sign success !!");
                Map<String, Object> respMap = JSON.parseObject(respData);
                String code = (String) respMap.get("code");
                if (("0").equals(code)
                        && "SUCCESS".equals((String) respMap.get("status"))) {
                    // 请求受理或处理成功，根据不同接口处理
                    
                    // 备注：：：：：需判断金额是否相同 amount与请求是否相等
                    //异步进行业务处理 线程处理 OR Rabbitmq
                    new Thread(new Runnable() {
                        public void run() {
                            //do business ...
                        }
                    });
                    
                    if ("NOTIFY".equals(request.getParameter("responseType"))) {
                        // 异步通知返回SUCCESS
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("SUCCESS");
                    } else if ("DIRECT_CALLBACK".equals(request.getParameter("responseType"))) {
                        // 同步通知 返回页面
                        // 设置返回的参数
                        model.addAttribute("message", "个人开户成功");
                        return "success";
                    }
                }
            } else {
                // 验签失败
                return null;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 
	 * 个人解绑银行卡回调<br>
	 * <功能详细描述>
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @return String [返回类型说明]
	 * @throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @version [版本号, 2018年3月14日]
	 * @author Smile.wang
	 */
	@RequestMapping(value = "/unbind_bankCard_notify.do")
    public String unbindBankCardNotify(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        
        AppConfig config = AppConfig.getConfig();
        String respData = request.getParameter("respData");
        logger.info("receive notify content : " + respData);
        try {
            // 验签
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64
                    .decodeBase64(config.getLmPublicKey()));
            boolean verify = SignatureUtils.verify(
                    SignatureAlgorithm.SHA1WithRSA, publicKey, respData,
                    Base64.decodeBase64(request.getParameter("sign")));
            if (verify) {
                logger.info("sign success !!");
                Map<String, Object> respMap = JSON.parseObject(respData);
                String code = (String) respMap.get("code");
                if (("0").equals(code)
                        && "SUCCESS".equals((String) respMap.get("status"))) {
                    // 请求受理或处理成功，根据不同接口处理
                    
                    // 备注：：：：：需判断金额是否相同 amount与请求是否相等
                    //异步进行业务处理 线程处理 OR Rabbitmq
                    new Thread(new Runnable() {
                        public void run() {
                            //do business ...
                        }
                    });
                    
                    if ("NOTIFY".equals(request.getParameter("responseType"))) {
                        // 异步通知返回SUCCESS
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("SUCCESS");
                    } else if ("DIRECT_CALLBACK".equals(request.getParameter("responseType"))) {
                        // 同步通知 返回页面
                        // 设置返回的参数
                        model.addAttribute("message", "个人开户成功");
                        return "success";
                    }
                }
            } else {
                // 验签失败
                return null;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	/**
	 * 
	 * 预留手机号更新回调<br>
	 * <功能详细描述>
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @return String [返回类型说明]
	 * @throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @version [版本号, 2018年3月14日]
	 * @author Smile.wang
	 */
	@RequestMapping(value = "/modify_mobile_expand_notify.do")
    public String modifyMobileExpandNotify(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        
        AppConfig config = AppConfig.getConfig();
        String respData = request.getParameter("respData");
        logger.info("receive notify content : " + respData);
        try {
            // 验签
            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64
                    .decodeBase64(config.getLmPublicKey()));
            boolean verify = SignatureUtils.verify(
                    SignatureAlgorithm.SHA1WithRSA, publicKey, respData,
                    Base64.decodeBase64(request.getParameter("sign")));
            if (verify) {
                logger.info("sign success !!");
                Map<String, Object> respMap = JSON.parseObject(respData);
                String code = (String) respMap.get("code");
                if (("0").equals(code)
                        && "SUCCESS".equals((String) respMap.get("status"))) {
                    // 请求受理或处理成功，根据不同接口处理
                    
                    // 备注：：：：：需判断金额是否相同 amount与请求是否相等
                    //异步进行业务处理 线程处理 OR Rabbitmq
                    new Thread(new Runnable() {
                        public void run() {
                            //do business ...
                        }
                    });
                    
                    if ("NOTIFY".equals(request.getParameter("responseType"))) {
                        // 异步通知返回SUCCESS
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("SUCCESS");
                    } else if ("DIRECT_CALLBACK".equals(request.getParameter("responseType"))) {
                        // 同步通知 返回页面
                        // 设置返回的参数
                        model.addAttribute("message", "个人开户成功");
                        return "success";
                    }
                }
            } else {
                // 验签失败
                return null;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
