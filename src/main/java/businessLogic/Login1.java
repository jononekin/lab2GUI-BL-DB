package businessLogic;

public class Login1 implements Login{
	public boolean loginEgin(String login, String password, String type){
		 return login.compareTo(password)==0;
	}

}
