注意:
1.该项目是maven项目,通过导入maven的方式导入
2.运行SignatureDemo.java类生成公私钥,公钥提供给存管,私钥替换application.properties文件中privateKey
3.application.properties替换platformNo为存管提供值
4.直连接口ServiceController.java，已实现用户信息查询接口
5.直连接口GatewayController.java，已实现充值接口
6.异步通知接口NotifyController.java，实现存管异步通知接收并进行业务逻辑处理

目录结构图
.
|____pom.xml --------------------------------Maven配置文件
|____readme.txt -----------------------------产品说明
|____src ------------------------------------类文件夹
| |____main
| | |____java
| | | |____demo -----------------------------接入事例代码
| | | | |____GatewayController.java ---------网关类接口
| | | | |____NotifyController.java ----------异步通知接收类接口
| | | | |____ServiceController.java ---------直连类接口，已实现用户信息查询接口
| | | |____common ------------------------------SDK工具类
| | | | |____AppConfig.java ---------------配置变量 从application.properties读取
| | | | |____AppUtil.java ---------------生成参数，加密请求参数
| | | | |____HttpUtils.java ---------------HTTP发送请求工具类公共类
| | | | |____SignatureAlgorithm.java ------加密的方式
| | | | |____SignatureUtils.java ----------加密的工具类
| | |____resources
| | | |____application.properties ---------------多个配置信息
| | | |____log4j.properties -----------------log4j配置信息
| | | |____spring
| | | | |____applicationContext.xml ---------Spring配置文件
| | | | |____springmvc-servlet.xml ----------SpringMvc配置文件
| | |____webapp
| | | |____index.jsp ------------------------导航页面
| | | |____pages
| | | | |____checkFileConfirm.jsp -----------对账确认接口
| | | | |____checkFileDownload.jsp ----------对账文件下载接口
| | | | |____checkFileUpload.jsp ------------对账文件上传接口 该接口和确认接口根据银行不同调用的接口不同
| | | | |____error.jsp ----------------------错误页面
| | | | |____establiShproject.jsp -----------新建标的
| | | | |____head.jsp -----------------------公共头信息
| | | | |____personalRegister.jsp -----------个人注册绑卡
| | | | |____queryUser.jsp ------------------用户查询
| | | | |____recharge.jsp -------------------充值
| | | | |____reqeust ------------------------请求文件夹
| | | | | |____downloadPost.jsp -------------下载请求页面
| | | | | |____gatewayPost.jsp --------------网关请求页面
| | | | | |____servicePost.jsp --------------直连请求页面
| | | | | |____uploadPost.jsp ---------------上传接口页面
| | | | |____transactionQuery.jsp -----------交易查询页面
| | | | |____withdraw.jsp -------------------提现
| | | |____static ---------------------------各种静态资源 包括js,css
| | | |____WEB-INF
|___________web.xml -------------------------WEB.xml
