package com.cyberup.framework.model;

import java.util.Date;

public interface LoginInfo {
	void save(LoginUser loginUser);
	void remove();
	boolean isLoggedIn();
	LoginUser currentUser();
	Date getLoginTime();
}
