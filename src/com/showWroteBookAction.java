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

public class showWroteBookAction extends ActionSupport {
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
	private Connection conn = null;
    private Statement stmt = null;
   // private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
	private static final long serialVersionUID = 1L;
	private String writer;
	private String[] authornum=new String[100];
	private List<book> booklist=new ArrayList<book>();

	

	public String[] getAuthornum() {
		return authornum;
	}
	public void setAuthornum(String[] authornum) {
		this.authornum = authornum;
	}
	public List<book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<book> booklist) {
		this.booklist = booklist;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer=writer;
	}
	public String execute() throws Exception{
		System.out.print(writer);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			int flag=0;
			String url="jdbc:mysql://localhost:3306/图书数据库bookdb?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象
			String sql= "select * from author";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("name").equals(writer)) {
					authornum[flag]=rs.getString("authorid");
					flag++;
				}
			}
			sql= "select * from book";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				for(int i=0;i<flag;i++) {
					if(rs.getString("authorid").equals(authornum[i])) {
						book tbook=new book();
						tbook.setBookauthorid(rs.getString("authorid"));
						tbook.setBookISBN(rs.getString("ISBN"));
						tbook.setBookname(rs.getString("title"));
						tbook.setBookprice(rs.getFloat("price"));
						tbook.setBookpublishdate(rs.getString("publishdate"));
						tbook.setBookpublisher(rs.getString("publisher"));
						booklist.add(tbook);	
					}
				}
			}
			if(booklist.size()==0) {
				return ERROR;
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
