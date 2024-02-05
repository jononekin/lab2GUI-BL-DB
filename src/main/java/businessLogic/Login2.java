package businessLogic;

public class Login2 implements Login{
	public boolean loginEgin(String login, String password, String type){
		 if (type.equals("ikaslea")) return true;
		 else
		  return login.length()==password.length();
	}

}