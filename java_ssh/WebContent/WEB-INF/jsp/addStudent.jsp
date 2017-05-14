<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<body>
	<!-- <h1 align="center">添加学生信息</h1> -->
    <!--  <hr> -->
    <form action="${pageContext.request.contextPath }/StudentServlet?select=add" method="post">
        <table align="center" border="0.5">
            <tr>
                <td align="right" width="40%">姓名</td>
                <td align="left"><input type="text" name="name" value="${user.name}"></td>
                <td ><font color="red">${user.errors.name}</font></td>
            </tr>
            <tr>
                <td align="right" width="40%">性别</td>
                <td align="left"><input type="radio" name="sex" value="man" checked>男<input type="radio" name="sex" value="women">女</td>
            </tr>
            <tr>
                <td align="right" width="40%">电话:</td>
                <td align="left"><input type="text" name="cellPhone"></td>
            </tr>
            <tr>
                <td align="right" width="40%">邮箱：</td>
                <td align="left"><input type="text" name="email"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</body>
</html>