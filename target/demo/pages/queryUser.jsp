<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>平台用户查询</title>
  <jsp:include page="/pages/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <h3>平台用户查询</h3>
      <form id="form" role="form" method="post" action="${contextPath}/service/doQueryUser.do">
        <div class="form-group">
          <label for="platformUserNo">platformUserNo</label>
          <input type="text" class="form-control" id="platformUserNo"
            name="platformUserNo" value="sun01"/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
