package securityJect1;

import java.io.Serializable;

public class userInfo implements Serializable {

	private static final long serialVersionUID = 2L;
	
	//String userNum;	// 유저번호.	등록 순서 유저 할당번호
	String name;		// 이름.		등록 시에 제한 <<
	String email;		// e-mail.	등록 시에 @로 check
	String phoneNum;	// 핸드폰번호.	등록 시에 조건 제한 << 20자리 이내의 숫자.
	
	String id;			// id.		등록 시에 제한<<
	String password;	// 비밀번호.	등록 시에 제한<<
	
	
	
	public userInfo(String name, String email, String phoneNum, String id, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.id = id;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
