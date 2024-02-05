package dataAccess;


import java.io.File;
import java.net.NoRouteToHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.User;


/**
 * It implements the data access to the objectDb database
 */
public class DataAccess  {
	private  EntityManager  db;
	private  EntityManagerFactory emf;
	private boolean initialize=false;
	String fileName="users.temp";

	
	//only execute to create the DataBase with initialize=true;
    public static void main(String args[]) {
    	new DataAccess();
    }
    
    
     public DataAccess()  {
		if (initialize) {
			

			File fileToDelete= new File(fileName);
			if(fileToDelete.delete()){
				File fileToDeleteTemp= new File(fileName+"$");
				fileToDeleteTemp.delete();

				  System.out.println("File deleted");
				} else {
				  System.out.println("Operation failed");
				}
		}
		open();
		if  (initialize)initializeDB();
		
		System.out.println("DataAccess created => isDatabaseLocal: ");

		close();

	}
    public boolean existInDB(String login, String password, String type) {
    	TypedQuery<String> query = db.createQuery("SELECT  u FROM User u WHERE u.login=?1 AND u.password=?2 AND u.type=?3",String.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		query.setParameter(3, type);

		List<String> users = query.getResultList(); 
		return !users.isEmpty();
    	
    }
    
    public DataAccess(EntityManager db) {
    	this.db=db;
    }

	
	public void initializeDB(){
		
		db.getTransaction().begin();

		try {
		   
		    //Create users 
			User user1=new User("jon","iturrioz","irakasle");
			User user2=new User("ikasle","aurrera","ikasle");
			User user3=new User("ikasle2","aurrera","ikasle");
			
			db.persist(user1);
			db.persist(user2);
			db.persist(user3);

	
			db.getTransaction().commit();
			System.out.println("Db initialized");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
public void open(){
		
		emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db = emf.createEntityManager();
		System.out.println("DataAccess opened ");
		
	}

	public void close(){
		db.close();
		System.out.println("DataAcess closed");
	}
	
}

