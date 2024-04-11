package Library_Management_System.controller;

import java.util.List;

import Library_Management_System.business.Book;
import Library_Management_System.business.LibraryMember;


public interface ControllerInterface {
	public boolean login(String id, String password);
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public List<Book> allBooks();
	public void addMember(LibraryMember meber);
}

