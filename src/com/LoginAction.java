package com;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String execute() throws Exception{
		System.out.print(username);
		if(username.equals("Áõ¼ÎÎý") && password.equals("123456")) {
		//	ActionContext.getContext().getSession().put("user",getUsername());	
			//setPassword("288829");
			return SUCCESS;
		}
		else {
			return ERROR;
		}
			
	}
     
}
