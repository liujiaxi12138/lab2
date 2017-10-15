<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询界面</title>
</head>
<body>
<center>
<h2>图书管理系统查询界面</h2>
<form action="searchAction.action">
<font size=3>
作者:<input type="text" name="writer">
	<input type=submit value="查询"/>
</font>
</form>
</center>
</body>
</html>