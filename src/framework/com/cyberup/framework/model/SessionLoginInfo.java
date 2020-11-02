package com.cyberup.framework.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionLoginInfo extends BaseObject implements LoginInfo {
	/**
	 *
	 */
	private static final long serialVersionUID = 2953837840704143836L;
	private LoginUser currentUser;
	private Date loginTime;
	
	public LoginUser currentUser() {
		return this.currentUser;
	}

	public boolean isLoggedIn() {
		return (this.currentUser != null);
	}

	public void remove() {
		if (this.currentUser == null) throw new IllegalStateException();
		this.currentUser = null;
		this.loginTime = null;
	}

	public void save(LoginUser user) {
		this.currentUser = user;
		this.loginTime = new Date();
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

}
