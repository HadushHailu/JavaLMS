package Library_Management_System.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Library_Management_System.dataaccess.Auth;
import Library_Management_System.dataaccess.DataAccess;
import Library_Management_System.dataaccess.DataAccessFacade;
import Library_Management_System.dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public boolean login(String id, String password){
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		
		if(!map.containsKey(id)) {
			return false;
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			return false;
		}
		currentAuth = map.get(id).getAuthorization();
		return true;
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	
}

