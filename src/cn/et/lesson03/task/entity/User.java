package cn.et.lesson03.task.entity;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message = "请输入用户名")
	private String userName;
	
	@NotEmpty(message = "请输入密码")
	private String password;
	
	@NotEmpty(message = "年龄不能为空")
	private String age;
	
	@NotEmpty(message = "请输入二次确认密码")
	private String rePassword;
	
	@NotEmpty(message = "手机号码不能为空")
	private String phone;
	
	@Pattern(regexp = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}" , message = "非法邮箱格式")
	private String email;
	
	@NotEmpty(message = "生日不能为空")
	private String birthday;
	
	@NotEmpty(message = "个人网址不能为空")
	private String website;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", age=" + age + ", rePassword=" + rePassword + ", phone="
				+ phone + ", email=" + email + ", birthday=" + birthday
				+ ", website=" + website + "]";
	}
	
}
