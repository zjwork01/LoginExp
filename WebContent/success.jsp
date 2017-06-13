<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
		request.setAttribute("error", "请登录");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return;
	}
%>
用户<%=session.getAttribute("username") %>登录成功... ...
</body>
</html>