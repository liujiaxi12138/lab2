<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
<form action=back.action>
<center>
<h3>书籍信息：</h3>
<font size=3 color=#6A5ACD>
<br>
书名：<s:property value="thebook.bookname" />
<br>
ISBN：<s:property value="thebook.bookISBN" />
<br>
作者id：<s:property value="thebook.bookauthorid" />
<br>
出版社：<s:property value="thebook.bookpublisher" />
<br>
出版日期：<s:property value="thebook.bookpublishdate" />
<br>
价格：<s:property value="thebook.bookprice" />
<br>
<br>
</font>
<h3>作者信息：</h3>
<font size=3 color=#DB7093>
<br>
名字：<s:property value="theauthor.name" />
<br>
id：<s:property value="theauthor.authorid" />
<br>
年龄：<s:property value="theauthor.age" />
<br>
国籍：<s:property value="theauthor.country" />
<br>
<br>
<input type=submit value="返回"/>
</font>
</center>
</form>
</body>
</html>