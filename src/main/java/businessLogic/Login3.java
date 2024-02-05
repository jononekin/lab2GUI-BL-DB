package businessLogic;

import dataAccess.DataAccess;

public class Login3 implements Login {
	public boolean loginEgin(String login, String password, String type){
		DataAccess da=new DataAccess();
		da.open();
		
		System.out.println(type);
		boolean b=da.existInDB(login, password, type);
		da.close();
		return b;
		
	}
}
