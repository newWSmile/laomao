<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<title>Insert title here</title>
<jsp:include page="/pages/head.jsp"></jsp:include>

</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3>测试系统</h3>
				<ul>
					<li><a href="pages/queryUser.jsp">用户信息查询</a></li>
					<li><a href="pages/sync_transaction.jsp">单笔交易测试</a></li>
					<li><a href="pages/async_transaction.jsp">批量交易测试</a></li>
					<li><a href="pages/recharge.jsp">充值</a></li>
					<li><a href="pages/register.jsp">开户</a></li>
					<li><a href="pages/bindCard.jsp">绑卡</a></li>
					<li><a href="pages/unbindCard.jsp">解绑</a></li>
					<li><a href="pages/modifyMobile.jsp">更新预留手机号</a></li>
					<li><a href="pages/establish_project.jsp">登记标的</a></li>
					<li><a href="pages/user_pre_transaction.jsp">用户预处理</a></li>
					<li><a href="pages/modify_project.jsp">变更标的</a></li>
					<li><a href="pages/freeze.jsp">资金冻结处理</a></li>
					<li><a href="pages/unfreeze.jsp">解冻资金处理</a></li>
					<li><a href="pages/unfreeze_trade_password.jsp">交易密码解冻</a></li>
					<span>测试一下</span>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>