package cc.wanforme.munkblog.vo;

import cc.wanforme.munkblog.base.constant.ResCode;

/**
 * @author wanne
 * 2020年9月21日
 */
public class ResMessage {
	// 返回码
	private String code;
	// 错误信息
	private String info;
	// 成功数据
	private Object data;

	public ResMessage() {}
	
	public ResMessage(String code, String info, Object data) {
		super();
		this.code = code;
		this.info = info;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getinfo() {
		return info;
	}

	public void setinfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	// 构造者模式改进
	public static ResMessage newMessage(ResCode code, String messasge, Object data) {
		return new ResMessage(code.getCode(), messasge, data);
	}
	public static ResMessage newSuccessMessage(String message,Object data) {
		return new ResMessage(ResCode.SUCCESS.getCode(), message, data);
	}
	public static ResMessage newSuccessMessage(Object data) {
		return new ResMessage(ResCode.SUCCESS.getCode(), ResCode.SUCCESS.getDescription(), data);
	}
	public static ResMessage newFailMessage( String messasge) {
		return new ResMessage(ResCode.FAIL.getCode(), messasge, null);
	}
	public static ResMessage newFailMessage( String messasge, Object data) {
		return new ResMessage(ResCode.FAIL.getCode(), messasge, data);
	}
	
}
