package cc.wanforme.munkblog.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wanne
 * 2020年10月24日
 */
public class SealCodeUtil {

	/** 检查密码是否正确
	 * @param password 传入的密码
	 * @param savedPwd 存储的密码
	 * @return
	 */
	public static boolean verifyPassword(String password, String savedPwd) {
		return StringUtils.equals(password, savedPwd);
	}
	
	
}
