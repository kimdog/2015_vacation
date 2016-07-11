package securityJect1;

import java.io.Serializable;

public class userInfo implements Serializable {

private static final long serialVersionUID = 2L;
	
	String id;
	String pw;
	String email_id;
	String email_pw;
	String isEnable;
/*
	public userInfo(String id, String pw, String email_id, String email_pw, String isEnable) {
		super();
		this.id = id;
		this.pw = pw;
		this.email_id = email_id;
		this.email_pw = email_pw;
		this.isEnable = isEnable;
	}
*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_pw() {
		return email_pw;
	}

	public void setEmail_pw(String email_pw) {
		this.email_pw = email_pw;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	
}
