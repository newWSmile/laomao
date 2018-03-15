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
				<h3>用户预处理</h3>
				<form id="form"
					action="${contextPath}/gateway/user_pre_transaction.do"
					method="post" target="_blank">
					<input type="hidden" id="host" name="host">
					<!--           <div class="form-group"> -->
					<!--             <label for="requestNo">requestNo</label><input type="text" -->
					<!--               class="form-control" id="requestNo" name="requestNo"  value="" /> -->
					<!--           </div> -->
					<div class="form-group">
						<label for="platformUserNo">platformUserNo</label><input
							type="text" class="form-control" id="platformUserNo"
							name="platformUserNo" value="7000002954" />
					</div>
					<div class="form-group">
						<label for="bizType">bizType</label><input
							type="text" class="form-control" id="bizType"
							name="bizType" value="TENDER" />
					</div>
					<div class="form-group">
						<label for="Amount">Amount</label><input
							type="text" class="form-control" id="Amount"
							name="Amount" value="1000.00" />
					</div>
					<div class="form-group">
						<label for="preMarketingAmount">preMarketingAmount</label><input
							type="text" class="form-control" id="preMarketingAmount"
							name="preMarketingAmount" value="0.00" />
					</div>
					<div class="form-group">
						<label for="Remark">Remark</label><input
							type="text" class="form-control" id="Remark"
							name="Remark" value="" />
					</div>
					<div class="form-group">
						<label for="redirectUrl">redirectUrl</label><input type="text"
							class="form-control" id="redirectUrl" name="redirectUrl"
							value="https://callback-ub-dev.taikongma.com/notify/notify.do" />
					</div>
					
					<div class="form-group">
						<label for="projectNo">projectNo</label><input type="text"
							class="form-control" id="projectNo" name="projectNo"
							value="1001" />
					</div>
					<div class="form-group">
						<label for="Share">Share</label><input type="text"
							class="form-control" id="Share" name="Share"
							value="" />
					</div>
					<div class="form-group">
						<label for="creditsaleRequestNo">creditsaleRequestNo</label><input type="text"
							class="form-control" id="creditsaleRequestNo" name="creditsaleRequestNo"
							value="" />
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>