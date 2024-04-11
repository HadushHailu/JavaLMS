package Library_Management_System.controller;

import java.util.List;


public interface ControllerInterface {
	public boolean login(String id, String password);
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}

