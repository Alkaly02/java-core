package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDandPasswords idAndPasswords = new IDandPasswords();
		
		LoginPage loginPage = new LoginPage(idAndPasswords.getLoginInfo());
	}

}
