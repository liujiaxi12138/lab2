<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者作品目录</title>
</head>
<body>
<center>
<h3>作者作品查询</h3> 
<br>
<blink>
<font size=4 color=6A5ACD>
<form action="back.action">
<s:iterator value="booklist" var='i'>
    <a href="show?isbn=<s:property value="bookISBN"/>"><s:property value="bookname"/></a>
    <a href="delete?isbn=<s:property value="bookISBN"/>">删除</a>
	<br>
</s:iterator>
<input type=submit value="返回"/>
</form>
</font>
</blink>
 </center>

</body>
</html>