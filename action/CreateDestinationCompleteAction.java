package com.internousdev.earth.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String message;


	public String execute() {
//		sessionがタイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}
		String result = ERROR;
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

		int count = destinationInfoDAO.insert(
//				String型に変換する
				String.valueOf(session.get("loginuserid")),
				String.valueOf(session.get("familyName")),
				String.valueOf(session.get("firstName")),
				String.valueOf(session.get("familyNameKana")),
				String.valueOf(session.get("firstNameKana")),
				String.valueOf(session.get("userAddress")),
				String.valueOf(session.get("email")),
				String.valueOf(session.get("telNumber"))

			);
		if(count > 0) {
			result = SUCCESS;
		}

		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}