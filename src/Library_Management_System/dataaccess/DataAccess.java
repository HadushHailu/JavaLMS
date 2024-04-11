package Library_Management_System.dataaccess;

import java.util.HashMap;

import Library_Management_System.business.Book;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;


public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member); 
	
	public HashMap<String,CheckoutEntry> readCheckoutRecordMap();
}
