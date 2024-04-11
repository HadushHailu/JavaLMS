package Library_Management_System.librarysystem;

import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

public class WTF {
	public static void main(String[] argv) {
		ControllerInterface ci = new SystemController();
		ci.allMembers();
		System.out.println(ci.allMembers().size());
	}

}
