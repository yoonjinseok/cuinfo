package com.cyberup.util;

public class PhoneValidator {
	public static boolean isValid(String phone) {
	    boolean retval = false;
	    String phoneNumberPattern = "(\\d{2}|\\d{3}|\\d{4})-(\\d{3}|\\d{4})-\\d{4}";

	    retval = phone.matches(phoneNumberPattern);

	    return retval;
	  }
	
	public static void main(String args[]) {
	    System.out.println(isValid("1-999-585-4009"));
	    System.out.println(isValid("999-585-4009"));
	    System.out.println(isValid("1-585-4009"));
	    System.out.println(isValid("585-4009"));
	    System.out.println(isValid("1.999-585-4009"));
	    System.out.println(isValid("999 585-4009"));
	    System.out.println(isValid("1 585 4009"));
	    System.out.println(isValid("111-Java2s"));
	  }
}
