package cc.wanforme.munkblog.base.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 用户实体类
 * @author wanne
 * 2019年10月02日
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private long id;
	/** 用户名*/
	private String name; 
	/** 密码*/
	private String password;
	/** 注册时间*/
	private Date regTime;
	/** 用户类型*/
	private int type;
	
	public User() {}
	
	public User(String name, String password, Date regTime, int type) {
		this.name = name;
		this.password = password;
		this.regTime = regTime;
		this.type = type;
	}
	
	public User(String name, String password, int type) {
		this(name, password, new Date(), type);
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getRegTime() {
		return regTime;
	}


	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", regTime=" + regTime + ", type="
				+ type + "]";
	}
	
}
