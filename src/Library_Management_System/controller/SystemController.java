package Library_Management_System.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Library_Management_System.business.Address;
import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.dataaccess.Auth;
import Library_Management_System.dataaccess.DataAccess;
import Library_Management_System.dataaccess.DataAccessFacade;
import Library_Management_System.dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	@Override
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
	public List<LibraryMember> allMembers(){
		DataAccess da = new DataAccessFacade();
		List<LibraryMember> retval = new ArrayList();
		System.out.println("allMembers hashmap: " + da.readMemberMap());
		retval.addAll(da.readMemberMap().values());
		System.out.println("allMembers " + retval.size());
		return retval;
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
	
	@Override
	public List<Book> allBooks(){
		DataAccess da = new DataAccessFacade();
		List<Book> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().values());
		return retval;
	}
	@Override
	public void addMember(String memberID,
			  String firstName, String lastName,
			  String tel, String street, String city, String state,
			  String zip){
		List<LibraryMember> lm = new ArrayList<>(){
			{
			add(new LibraryMember(memberID, firstName, lastName, tel, new Address(street, city, state, zip)));
			}
		};
		
		DataAccessFacade.loadMemberMap(lm);
	}
	
	@Override
	public void addBook(String isbn, String title,
			int copyNum, int maxLength, List<Author> authors) {
		List<Book> lb = new ArrayList<>(){
			{
			add(new Book(isbn, title, copyNum, maxLength, authors));
			}
		};
		DataAccessFacade.loadBookMap(lb);
	} 
}

