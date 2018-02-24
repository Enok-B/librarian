/**  
* @Title: ResponseCode.java  
* @Package com.eyee.esdata.constant  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Ksewen  
* @date 2017年12月25日  
*/
package com.enokb.librarian.config.constant;

/**
 * @ClassName: ResponseCode
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ksewen
 * @date 2017年12月25日
 * 
 */
public enum ResponseCode {
	SUCCESS(200, "success", true), RESOURCE_NOT_FOUND(404, "resource not found", false), INVALID_PARAMETERS(400,
			"invalid parameter", false), SERVER_ERROR(500, "server error", false), INVALID_SIGN(401, "invalid sign",
					false), ALREADY_EXISTS(403, "resource already exists", false);

	private int code;
	private String msg;
	private boolean flag;

	/**
	 * 创建一个新的实例 ResponseCode.
	 * 
	 */
	private ResponseCode(int code, String msg, boolean flag) {
		this.code = code;
		this.msg = msg;
		this.flag = flag;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public boolean getFlag() {
		return flag;
	}

}
