<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path =request.getContextPath();
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet"  href="<%=path %>/css/list.css"/>
    <script type="text/javascript">
        window.onload = function() {
            doubleBgColor(document.getElementById("secTB"),"#f8fbfc","#e5f1f4");
        }
        function doubleBgColor(Table,Bg1,Bg2) {
            for (var i=0;i<Table.rows.length;i++) Table.rows[i].bgColor=i%2?Bg2:Bg1;
        }
    </script>
    <title>List</title>
</head>
<body>
    <table class="totalTB">
  <%--       <tr>
            <td>
                <a href="${pageContext.request.contextPath }/add">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:delmore()">删除</a>
            </td>
        </tr> --%>
        <tr>
            <td>
                <table class="secTB">
                    <tr class="tableHeader">
                        <th class="selectTh"><input type="checkbox"></th>
                        <th class="nameTh">姓名</th>
                        <th class="sexTh">性别</th>
                        <th class="emailTh">邮箱</th>
                        <th class="cellPhoneTh">电话</th>
                        <th class="managerTh">操作</th>
                    </tr>
                    <c:choose>
                        <c:when test="${empty list}">
                            <tr>
                                <td colspan="10" align = "center">暂时没有数据</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${list}" var="c" varStatus="status">
                           		<c:if test="${status.index %2==0}">
	                           		 <tr class="tableBodyS">
	                                    <td class="selectTd"><input type="checkbox" name="ids" value="${c.id }"></td>
	                                    <td class="nameTd">${c.name }</td>
	                                    <td class="sexTd">${c.sex == "man" ? "男" : "女"}</td>
	                                    <td class="emailTd">${c.email }</td>
	                                    <td class="cellPhoneTd">${c.cellPhone }</td>
	                                    <td class="managerTd"><a href="${pageContext.request.contextPath}/update">更新</a>|<a href="${pageContext.request.contextPath}/StudentServlet?select=delete&id=${c.id}">删除</a></td>
	                               	 </tr>
                           		</c:if>
                                <c:if test="${status.index%2==1}">
	                           		 <tr class="tableBodyD">
	                                    <td class="selectTd"><input type="checkbox" name="ids" value="${c.id }"></td>
	                                    <td class="nameTd">${c.name }</td>
	                                    <td class="sexTd">${c.sex == "man" ? "男" : "女"}</td>
	                                    <td class="emailTd">${c.email }</td>
	                                    <td class="cellPhoneTd">${c.cellPhone }</td>
	                                    <td class="managerTd"><a href="${pageContext.request.contextPath}/update">更新</a>|<a href="${pageContext.request.contextPath}/StudentServlet?select=delete&id=${c.id}">删除</a></td>
	                               	 </tr>
                           		</c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>