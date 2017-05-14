<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String path =request.getContextPath();
 	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css"/>
	<script type="text/javascript"  src="<%=path %>/js/index.js"></script>
	<title>index</title>
</head>
<body>
	<div class="header">
 	   <label class="headerLabel">学生管理系统
 	   </label>
	</div>
	
	<!--<div class="content">-->
		<!-- left -->
		<div id="leftNav" class="contentLeft">
			<div class="contentLeftHeader"><p class="leftNavTitle">功能菜单</p></div>
			<hr>
			<div class="contentNav" onclick="showOrHiddenNav('s1')">
				<img class="fNavImg" src="<%=basePath%>/resource/index_list.png">用户管理
			</div>
			<div id ="s1"  class="contentSecNav">
				<ul>
					<li class="contentSecNav"><img class="secNavImg" src="<%=basePath%>/resource/index_arrow.png"><a class="leftNavTitle" href="${pageContext.request.contextPath}/StudentServlet?select=all" target="iframe">学生列表</a></li>
					<li class="contentSecNav"><img class="secNavImg" src="<%=basePath%>/resource/index_arrow.png"><a class="leftNavTitle"  href="${pageContext.request.contextPath}/StudentServlet?select=add" target="iframe">添加学生</a></li>
				</ul>
			</div>
		</div>
		
		<!-- right -->
		<div class="contentRight">
			<div class="contentRightHeader"><p class="rightNavTitle">您所在的位置->用户管理->学生列表</p></div>
				<hr>
            <div><iframe id="iframe" class="contentIFrame" name="iframe"></iframe></div>
		</div>
	<div class="footer">
   	 	<label>Copyright@2017 kk 版权所有</label>
	</div> 
</body>
</html>