<%@page import="spring.struct2.bean.Person"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 1.從Application域對象中得到IOC容器的實例
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		// 2.從IOC容器中得到Bean
		Person person = ctx.getBean(Person.class);
		// 3.使用bean
		person.hello();
	%>


</body>
</html>