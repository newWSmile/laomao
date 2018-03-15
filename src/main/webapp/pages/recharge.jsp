<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<title>Insert title here</title>
<jsp:include page="/pages/head.jsp"></jsp:include>
</head>
<body>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <h3>充值</h3>
        <form id="form" action="${contextPath}/gateway/doRecharge.do" method="post"
          target="_blank">
          <input type="hidden" id="host" name="host">  
<!--           <div class="form-group"> -->
<!--             <label for="requestNo">requestNo</label><input type="text" -->
<!--               class="form-control" id="requestNo" name="requestNo"  value="" /> -->
<!--           </div> -->
          <div class="form-group">
            <label for="platformUserNo">platformUserNo</label><input
              type="text" class="form-control" id="platformUserNo" name="platformUserNo" value="tender0" />
          </div>
                   <div class="form-group">
            <label for="amount">amount</label><input
              type="text" class="form-control" id="amount" name="amount" value="0.01"/>
          </div>
          		<div class="form-group">
					<label for="commission">commission</label><input type="text"
						class="form-control" id="commission" name="commission" value="1" />
				</div>
          <div class="form-group">
            <label for="expectPayCompany">expectPayCompany</label><input type="text"
              class="form-control" id="expectPayCompany" name="expectPayCompany" value="FUIOU" />
          </div>
          <div class="form-group">
          <label for="rechargeWay">rechargeWay</label><input type="text"
            class="form-control" id="rechargeWay" name="rechargeWay" value="WEB" />
        </div>
          <div class="form-group">
			<label for="bankcode">bankcode</label><input type="text" 
			class="form-control" id="bankcode"	name="bankcode" value="CMBC" />
		 </div>	
      	 <div class="form-group">
		  <label for="expired">expired</label><input type="text"
			class="form-control" id="expired" name="expired" value="20181210120000" />
	     </div> 
		     <div class="form-group">
          <label for="callbackMode">callbackMode</label><input
            type="text" class="form-control" id="callbackMode" name="callbackMode"
            value="DIRECT_CALLBACK" />
        </div>
          <div class="form-group">
            <label for="redirectUrl">redirectUrl</label><input
              type="text" class="form-control" id="redirectUrl" name="redirectUrl"
              value="http://172.19.62.196:8080/demo/notify/notify.do" />
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
          </form>
      </div>
    </div>
  </div>
</body>
</html>