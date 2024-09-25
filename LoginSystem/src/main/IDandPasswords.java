package main;

import java.util.HashMap;

public class IDandPasswords {
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords(){
		loginInfo.put("Bro", "Code");
		loginInfo.put("Prometheus", "Password");
		loginInfo.put("Alkaly", "alkaly02");
	}
	
	protected HashMap getLoginInfo(){
		return loginInfo;
	}
}
