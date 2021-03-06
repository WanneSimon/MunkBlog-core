package cc.wanforme.munkblog.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wanne
 * 2020年10月24日
 */
@Component
public class TokenProperty {

	/** token失效时间，默认一天*/
	@Value("${token.expireDays:1}")
	private int expireDays;
	/** token名*/
	@Value("${token.name:mbhbosT}")
	private String name;	
	
	public int getExpireDays() {
		return expireDays;
	}
	public void setExpireDays(int expireDays) {
		this.expireDays = expireDays;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
