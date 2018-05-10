package com.pibigstar.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pibigstar.common.Constant;
import com.pibigstar.domain.User;
import com.pibigstar.domain.result.ExceptionMsg;
import com.pibigstar.domain.result.MyResponse;

@Controller
@RequestMapping(value="/admin")
public class SystemBaseController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected HttpServletRequest request;
	
	@Value("${admin.address}")
	protected String adminAdress;
	@Value("${admin.name}")
	protected String adminName;
	@Value("${admin.author}")
	protected String adminAuthor;
	@Value("${admin.defaultImg}")
	protected String defaultImg;
	
	
	
	
	
	
	/**
	 * 返回成功
	 * @param msg
	 * @return
	 */
	protected MyResponse success() {
		return new MyResponse(ExceptionMsg.SUCCESS.getCode());
	}
	protected MyResponse success(Object data) {
		return new MyResponse(ExceptionMsg.SUCCESS.getCode(),data);
	}
	protected MyResponse success(String msg) {
		return new MyResponse(ExceptionMsg.SUCCESS.getCode(), msg);
	}
	protected MyResponse success(String msg,Object data) {
		return new MyResponse(ExceptionMsg.SUCCESS.getCode(), msg,data);
	}
	/**
	 * 返回异常
	 * @param e
	 * @return
	 */
	protected MyResponse error(ExceptionMsg e) {
		return new MyResponse(e);
	}
	
	
	/**
	 * 得到Seesion对象
	 */
	protected HttpSession getSession() {
		return request.getSession();
	}
	
	/**
	 * 得到session中的用户对象
	 */
	protected User getUser() {
		return (User) getSession().getAttribute(Constant.LOGIN_USER_SESSION_KEY);
	}
	
	protected void setAttribute() {
		request.setAttribute("adminAddress", adminAdress);
		request.setAttribute("adminName", adminName);
		request.setAttribute("adminAuthor", adminAuthor);
		request.setAttribute("defaultImg", defaultImg);
	}

}