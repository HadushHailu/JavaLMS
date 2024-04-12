package Library_Management_System.business;

import java.io.Serializable;
import java.time.LocalDate;

import Library_Management_System.dataaccess.User;

final public class CheckoutEntry implements Serializable{
	private static final long serialVersionUID = -891229800414574888L;
	
	private String recordId;
	private LibraryMember member;
	private User user;
	private BookCopy bookCopy;
	private LocalDate chekoutDate;
	private LocalDate dueDate;
	private Penality penality;
	
	public CheckoutEntry( String recordId,
			               LibraryMember member,
					       User user,
					       BookCopy bookCopy, 
					       LocalDate checkoutDate,
					       LocalDate dueDate){
		this.recordId = recordId;
		this.member = member;
		this.user = user;
		this.bookCopy = bookCopy;
		this.chekoutDate = checkoutDate;
		this.dueDate = dueDate;
		member.addCheckoutRecord(this);
	}
	
	public LocalDate getCheckoutDate() {
		return chekoutDate;
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
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public Penality getPenality() {
		return penality;
	}
	
}
