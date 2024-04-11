package Library_Management_System.business;

import java.io.Serializable;
import java.time.LocalDate;

import Library_Management_System.dataaccess.User;

final public class CheckoutEntry implements Serializable{
	private static final long serialVersionUID = -891229800414574888L;
	
	private String recordId;
	private LibraryMember member;
	private User user;
	private Book book;
	private LocalDate chekoutDate;
	private LocalDate dueDate;
	private Penality penality;
	
	public CheckoutEntry( String recordId,
			               LibraryMember member,
					       User user,
					       Book book, 
					       LocalDate checkoutDate,
					       LocalDate dueDate){
		this.recordId = recordId;
		this.member = member;
		this.user = user;
		this.book = book;
		this.chekoutDate = checkoutDate;
		this.dueDate = dueDate;
		member.addCheckoutRecord(this);
	}
	
	public String getReocordId() {
		return recordId;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	
	public User getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public Penality getPenality() {
		return penality;
	}
	
}
