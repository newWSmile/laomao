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
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3>个人绑卡页面</h3>
				<form id="form"
					action="${contextPath}/gateway/personal_bind_bankcard_expand.do"
					method="post" target="_blank">
					<input type="hidden" id="host" name="host">
					<div class="form-group">
						<label for="platformUserNo">platformUserNo</label><input
							type="text" class="form-control" id="platformUserNo"
							name="platformUserNo" value="7000002954" />
					</div>
					<div class="form-group">
						<label for="mobile">mobile</label><input type="text"
							class="form-control" id="mobile" name="mobile" value="13844692675" />
					</div>
					<div class="form-group">
						<label for="bankcardNo">bankcardNo</label><input type="text"
							class="form-control" id="bankcardNo" name="bankcardNo"
							value="6222035599820461493" />
					</div>
					<div class="form-group">
						<label for="checkType">checkType</label><input type="text"
							class="form-control" id="checkType" name="checkType"
							value="LIMIT" />
					</div>
					<div class="form-group">
						<label for="redirectUrl">redirectUrl</label><input type="text"
							class="form-control" id="redirectUrl" name="redirectUrl"
							value="https://callback-ub-dev.taikongma.com/notify/personal_bind_bankCard_notify.do" />
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>