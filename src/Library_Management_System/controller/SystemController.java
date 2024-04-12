package Library_Management_System.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import Library_Management_System.business.Address;
import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.BookCopy;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.dataaccess.Auth;
import Library_Management_System.dataaccess.DataAccess;
import Library_Management_System.dataaccess.DataAccessFacade;
import Library_Management_System.dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	Random rand = new Random();
	
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
	
	public String addCheckoutEntry(String memberId, String bookIsbn, User user) {
		String ret = "";
		
		//check if memberID exists
		List<LibraryMember> memberList= allMembers();
		LibraryMember member=null;
        for(LibraryMember mem: memberList) {
        	if(mem.getMemberId().equals(memberId)) {
        		member = mem;
        		ret += "MemberId doesn't exist!";
        		break;
        	}
        }
		
		//check if bookISBN exists and copy is available
        List<Book> bookList = allBooks();
		Book book=null;
		for(Book bk: bookList) {
			if(bk.getIsbn().equals(bookIsbn)){
				if(bk.getNextAvailableCopy() != null) {
					BookCopy bc = bk.getNextAvailableCopy();
					bc.changeAvailability();
					System.out.println("BookCopy num:" + bc.getCopyNum());
					addCheckoutEntry(
							Integer.toString(rand.nextInt(1000)),
							member,
							user,
							bc,
							LocalDate.now(),
							LocalDate.now().plusDays(bk.getMaxCheckoutLength())
							);
					addBook(bookList);
					ret += "Successfuly checkedout!";
					break;
				}else {
					System.out.println("No available copy!");
					ret += "and copy isn't available!";
				}
			}
			
		}
			
		return ret;
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
	public boolean addBookCopy(String isbn,int totolCopy) {
		List<Book> bookList = allBooks();
		Book book = null;
		for(Book b: bookList) {
			if(b.getIsbn().equals(isbn)) {
				book = b;
			}
		}
		
		if(book==null) {
			return false;
		}
		book.addCopy(totolCopy);
		
		//load
		DataAccessFacade.loadBookMap(bookList);
		return true;
	}
	
	public List<CheckoutEntry> allCheckoutEntry(){
		DataAccess da = new DataAccessFacade();
		List<CheckoutEntry> retval = new ArrayList<>();
		retval.addAll(da.readCheckoutRecordMap().values());
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
	
	public void addCheckoutEntry( String recordId,
            LibraryMember member,
		       User user,
		       BookCopy bookCopy, 
		       LocalDate checkoutDate,
		       LocalDate dueDate) {
		List<CheckoutEntry> lr = new ArrayList<>(){
			{
				add(new CheckoutEntry(recordId, member, user, bookCopy, checkoutDate, dueDate));
			}
		};
		DataAccessFacade.loadCheckoutRecordMap(lr);
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
	
	public void addBook(List<Book> books) {
		DataAccessFacade.loadBookMap(books);
	}
}

