<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<title>测试入口</title>
  <jsp:include page="/pages/head.jsp"></jsp:include>
</head>
<body>
  <div class="container">
    <h6 style="color:red">注意该页面只是作为一个展示页面,针对测试比较直观.在商户环境下建议把参数拼接放在后台</h6>
    <div class="row clearfix">
      <div class="col-md-12 column">
<!--         	<a href="toQueryUser.do">个人绑卡注册</a> -->
        	<a href="toQueryUser.do">用户信息查询</a>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  $(function() {
   		
  })
</script>
</html>