package cc.wanforme.munkblog.authen.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.wanforme.munkblog.base.entity.RoleAuth;
import cc.wanforme.munkblog.base.entity.User;
import cc.wanforme.munkblog.base.entity.UserRole;

/**
 * @author wanne
 * 2020年10月23日
 */
public class UserRoleAuth {

	private User user;
	private Map<UserRole, List<RoleAuth>> roleAuth = new HashMap<>(10);
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<UserRole, List<RoleAuth>> getRoleAuth() {
		return roleAuth;
	}
	
}
