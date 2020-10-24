package cc.wanforme.munkblog.vo.login;

/**
 * @author wanne
 * 2020年10月24日
 */
public class LoginVo {

	private String username;
	private String password;
	private Boolean rememberMe;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
}
