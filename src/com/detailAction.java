package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;
import com.showWroteBookAction.book;

public class detailAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public author getTheauthor() {
		return theauthor;
	}
	public void setTheauthor(author theauthor) {
		this.theauthor = theauthor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public class author{
		String authorid;
		int age;
		String country;
		String name;
		public String getAuthorid() {
			return authorid;
		}
		public void setAuthorid(String authorid) {
			this.authorid = authorid;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	public class book{
		private String bookname;
		private String bookISBN;
		private String bookauthorid;
		private String bookpublisher;
		private String bookpublishdate;
		private float bookprice;
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getBookISBN() {
			return bookISBN;
		}
		public void setBookISBN(String bookISBN) {
			this.bookISBN = bookISBN;
		}
		public String getBookauthorid() {
			return bookauthorid;
		}
		public void setBookauthorid(String bookauthorid) {
			this.bookauthorid = bookauthorid;
		}
		public String getBookpublisher() {
			return bookpublisher;
		}
		public void setBookpublisher(String bookpublisher) {
			this.bookpublisher = bookpublisher;
		}
		public String getBookpublishdate() {
			return bookpublishdate;
		}
		public void setBookpublishdate(String bookpublishdate) {
			this.bookpublishdate = bookpublishdate;
		}
		public float getBookprice() {
			return bookprice;
		}
		public void setBookprice(float bookprice) {
			this.bookprice = bookprice;
		}
	}
	private book thebook;
	private author theauthor;
	private String isbn;
	private Connection conn = null;
    private Statement stmt = null;
   // private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
	public book getThebook() {
		return thebook;
	}
	public void setThebook(book thebook) {
		this.thebook = thebook;
	}
	
	public String execute() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String tid=null;
			String url="jdbc:mysql://localhost:3306/图书数据库bookdb?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象
			String sql= "select * from book";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("ISBN").equals(getIsbn())) {
					book tbook=new book();
					tbook.setBookauthorid(rs.getString("authorid"));
					tbook.setBookISBN(rs.getString("ISBN"));
					tbook.setBookname(rs.getString("title"));
					tbook.setBookprice(rs.getFloat("price"));
					tbook.setBookpublishdate(rs.getString("publishdate"));
					tbook.setBookpublisher(rs.getString("publisher"));
					this.setThebook(tbook);
					tid=rs.getString("authorid");
					break;
				}
			}
			
			sql= "select * from author";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("authorid").equals(tid)){
					author tauthor=new author();
					tauthor.setAge(rs.getInt("age"));
					tauthor.setCountry(rs.getString("country"));
					tauthor.setName(rs.getString("name"));
					tauthor.setAuthorid(rs.getString("authorid"));
					this.setTheauthor(tauthor);
				}
			}
			try {
	            if (rs!= null) {
	              rs.close();
	            }

	            if (stmt != null) {
	              stmt.close();
	            }

	            if (conn != null) {
	              conn.close();
	            }
	          } catch (Exception e) {
	        	  System.out.print("get data error1!");
	          }
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
			return ERROR;
		}
	}

}