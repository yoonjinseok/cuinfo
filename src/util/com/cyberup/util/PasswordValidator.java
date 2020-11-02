package com.cyberup.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	
	private static final String PASSWORD_PATTERN = 
        "((?=.*\\d)(?=.*[a-zA-Z]).{4,15})";
	
	/*
	 * "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,15})"
	(			# Start of group
			  (?=.*\d)		#   must contains one digit from 0-9
			  (?=.*[a-z])		#   must contains one lowercase characters
			  (?=.*[A-Z])		#   must contains one uppercase characters
			  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
			              .		#     match anything with previous condition checking
			                {4,15}	#        length at least 4 characters and maximum of 15	
	)			# End of group
	*/

	  public static boolean isValid(String password){
		  Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		  
		  Matcher matcher = pattern.matcher(password);
		  return matcher.matches();
	  }
	  
	  public static void main(String[] args) {
		System.out.println("result : " + isValid("s1234"));
	}
}
