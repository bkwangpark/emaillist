
<%@page import="com.sds.icto.eamillist.dao.EmailListDao"%>
<%@ page import="com.sds.icto.eamillist.vo.EmailListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
//이메일을 등록합니다.
String firstName=request.getParameter("fn");
String lastName=request.getParameter("ln");
String email=request.getParameter("email");

EmailListVo vo=new EmailListVo();
vo.setFirstName(firstName);
vo.setLastName(lastName);
vo.setEmail(email);

EmailListDao dao=new EmailListDao();
dao.insert(vo);
response.sendRedirect("/emaillist");
%>


<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이메일을 등록합니다.</h1>
</body>
</html> -->