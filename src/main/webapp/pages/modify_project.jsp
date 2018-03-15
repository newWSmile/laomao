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
      <h3>测试标的登记</h3>
      <form id="form" role="form" method="post" action="${contextPath}/service/modify_project.do">
         <div class="form-group">
          <label for="projectNo">projectNo</label>
          <input type="text" class="form-control" id="projectNo"
            name="projectNo" value="1001"/>
        </div>
         <div class="form-group">
          <label for="status">status:COLLECTING(募集中),REPAYING(还款中),FINISH(已截标),MISCARRY(流标)</label>
          <input type="text" class="form-control" id="status"
            name="status" value=""/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
