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
      <form id="form" role="form" method="post" action="${contextPath}/service/establish_project.do">
        <div class="form-group">
          <label for="platformUserNo">platformUserNo</label>
          <input type="text" class="form-control" id="platformUserNo"
            name="platformUserNo" value="7000002955"/>
        </div>
         <div class="form-group">
          <label for="projectNo">projectNo</label>
          <input type="text" class="form-control" id="projectNo"
            name="projectNo" value="1001"/>
        </div>
         <div class="form-group">
          <label for="projectAmount">projectAmount</label>
          <input type="text" class="form-control" id="projectAmount"
            name="projectAmount" value="1000.00"/>
        </div>
         <div class="form-group">
          <label for="projectName">projectName</label>
          <input type="text" class="form-control" id="projectName"
            name="projectName" value="测试标的001"/>
        </div>
         <div class="form-group">
          <label for="projectDescription">projectDescription</label>
          <input type="text" class="form-control" id="projectDescription"
            name="projectDescription" value="用于测试标的登记"/>
        </div>
         <div class="form-group">
          <label for="projectType">projectType</label>
          <input type="text" class="form-control" id="projectType"
            name="projectType" value="STANDARDPOWDER"/>
        </div>
         <div class="form-group">
          <label for="projectPeriod">projectPeriod</label>
          <input type="text" class="form-control" id="projectPeriod"
            name="projectPeriod" value="20"/>
        </div>
         <div class="form-group">
          <label for="annualInterestRate">annualInterestRate</label>
          <input type="text" class="form-control" id="annualInterestRate"
            name="annualInterestRate" value="0.03"/>
        </div>
         <div class="form-group">
          <label for="repaymentWay">repaymentWay</label>
          <input type="text" class="form-control" id="repaymentWay"
            name="repaymentWay" value="FIXED_PAYMENT_MORTGAGE"/>
        </div>
         <div class="form-group">
          <label for="extend">extend</label>
          <input type="text" class="form-control" id="extend"
            name="extend" value=""/>
        </div>
         <div class="form-group">
          <label for="productType">productType</label>
          <input type="text" class="form-control" id="productType"
            name="productType" value="COMMONPRODUCT"/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
