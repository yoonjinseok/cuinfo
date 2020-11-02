package com.cyberup.util;

public class EmailValidator {
	public static void main(String[] args) {
	    System.out.println("isValid = " + isValid("user@domain.com"));
	  }

	  public static boolean isValid(String email) {
	    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	    return email.matches(EMAIL_REGEX);
	  }
}
