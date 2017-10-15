package com;


import com.opensymphony.xwork2.ActionSupport;
import com.showWroteBookAction.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;

public class deleteAction extends ActionSupport{
	private String isbn;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	private Connection conn = null;
    private Statement stmt = null;
   // private PreparedStatement preparedStatement = null;
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/图书数据库bookdb?characterEncoding=utf8&useSSL=false";
			String i=getIsbn();
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象
			String sql="delete from book where ISBN='"+i+"'";
			stmt.executeUpdate(sql);//执行sql语句	
			try {
	            if (stmt != null) {
	              stmt.close();
	            }

	            if (conn != null) {
	              conn.close();
	            }
	          } catch (Exception e) {
	        	  System.out.print("get data error!");
	          }
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
			return ERROR;
		}

	
		
	}

}
