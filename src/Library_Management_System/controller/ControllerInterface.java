package Library_Management_System.controller;

import java.time.LocalDate;
import java.util.List;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.BookCopy;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.dataaccess.User;


public interface ControllerInterface {
	public boolean login(String id, String password);
	public List<String> allMemberIds();
	public List<LibraryMember> allMembers();
	
	/*
	 * Fetching methods
	 */
	public List<String> allBookIds();
	public List<Book> allBooks();
	public List<CheckoutEntry> allCheckoutEntry();
	
	/*
	 * Adding methods
	 */
	public void addCheckoutEntry( String recordId,
               LibraryMember member,
		       User user,
		       BookCopy bookCopy, 
		       LocalDate checkoutDate,
		       LocalDate dueDate);
	
	public String addCheckoutEntry(String memberId, String bookIsbn, User user);
	
	public boolean addBookCopy(String isbn,int totolCopy);
	public void addMember(String memberID,
						  String firstName, String lastName,
						  String tel, String street, String state, String city,
						  String zip);
	
	public void addBook(String isbn, String title,
			int copyNum, int maxLength, List<Author> authors);
	public void addBook(List<Book> books);
	
}

