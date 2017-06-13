<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<%
/*
读取cookie，如果不为空，显示用户名，如果为空，则不显示
*/
String uname = "";
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie c: cookies){
		if("uname".equals(c.getName())){
			uname = c.getValue();
			break;
		}
	}
}
%>
	<%
	/*
	读取错误信息
	*/
		String error = "";
	    String msg = (String)request.getAttribute("error");
		if(msg != null){
			error = msg;
		}
	%>
	<font color="red"><b><%=error %></b></font>
	<form action="/LoginExp/LoginServlet" method="post">
		用户名：<input type="text" name="username" value="<%=uname%>"><br />
		密     码：<input type="password" name="pwd"><br />
		<input type="submit" value="登录"><br/> 		
	</form>
</body>
</html>