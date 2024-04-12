package Library_Management_System.librarysystem;

import java.util.List;

import Library_Management_System.business.Book;
import Library_Management_System.business.BookCopy;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

public class WTF {
	public static void main(String[] argv) {
		ControllerInterface ci = new SystemController();
		ci.allMembers();
		System.out.println(ci.allMembers().size());
		
		ci.allBooks();
		System.out.println("books: " + ci.allBooks().size());
		
		ci.allCheckoutEntry();
		System.out.println("cehckout: " + ci.allCheckoutEntry().size());
		
		List<Book> bookList=ci.allBooks();
		for(Book book: bookList) {
			for(BookCopy bc: book.getCopies()) {
				System.out.println("Book info: " + book.getTitle()+ " "+bc.getCopyNum() +" " + bc.isAvailable());
			}
		}
				
	}

}
