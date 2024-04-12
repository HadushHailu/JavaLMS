package Library_Management_System.controller;

import java.util.List;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.LibraryMember;


public interface ControllerInterface {
	public boolean login(String id, String password);
	public List<String> allMemberIds();
	public List<LibraryMember> allMembers();
	public List<String> allBookIds();
	public List<Book> allBooks();
	public boolean addBookCopy(String isbn,int totolCopy);
	public void addMember(String memberID,
						  String firstName, String lastName,
						  String tel, String street, String state, String city,
						  String zip);
	
	public void addBook(String isbn, String title,
			int copyNum, int maxLength, List<Author> authors);
	
}

