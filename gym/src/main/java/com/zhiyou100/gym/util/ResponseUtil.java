package com.zhiyou100.gym.util;

import lombok.Data;

@Data
public class ResponseUtil {
	private Integer code;
	private String msg;
	private Object data;
	
	public static final int SUCCESS_CODE = 0;
	public static final int ERROR_CODE = 1;
	public static final String SUCCESS_MSG = "请求成功";
	public static final String ERROR_MSG = "请求错误";
	public static final String ERROR_MSG1 = "请求格式错误";
	public static final String ERROR_MSG2 = "数据不存在";
	
	public static ResponseUtil success(Object data) {
		ResponseUtil response = new ResponseUtil();
		response.setCode(SUCCESS_CODE);
		response.setMsg(SUCCESS_MSG);
		response.setData(data);
		return response;
	}

	public static ResponseUtil error(String msg) {
		ResponseUtil response = new ResponseUtil();
		response.setCode(ERROR_CODE);
		response.setMsg(msg);
		return response;
	}
}
