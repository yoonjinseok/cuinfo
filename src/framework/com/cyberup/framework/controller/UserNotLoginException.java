package com.cyberup.framework.controller;

public class UserNotLoginException extends Exception {
	public UserNotLoginException()
	{
		super("로그인후에 이용하시기 바랍니다.");
	}
	public UserNotLoginException(String errMsg)
	{
		super(errMsg);
	}
}
