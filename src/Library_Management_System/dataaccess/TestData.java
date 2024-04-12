package Library_Management_System.dataaccess;

import Library_Management_System.business.Book;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.Address;
import Library_Management_System.business.Author;
import Library_Management_System.business.LibraryMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

;


/**
 * This class loads data into the data repository and also
 * sets up the storage units that are used in the application.
 * The main method in this class must be run once (and only
 * once) before the rest of the application can work properly.
 * It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
		td.libraryMemberData();
		td.userData();
		td.checkoutRecordData();
		DataAccess da = new Library_Management_System.dataaccess.DataAccessFacade();
		System.out.println(da.readBooksMap());
		System.out.println(da.readUserMap());
		
		System.out.println("Dumy checkout record data: ");
		System.out.println(da.readCheckoutRecordMap());
	}
	///create books
	public void bookData() {
		allBooks.get(0).addCopy(1);
		allBooks.get(0).addCopy(1);
		allBooks.get(1).addCopy(1);
		allBooks.get(3).addCopy(1);
		allBooks.get(2).addCopy(1);
		allBooks.get(2).addCopy(1);
		DataAccessFacade.loadBookMap(allBooks);
	}
	
	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}
	
	
	//create library members
	public void libraryMemberData() {
		LibraryMember libraryMember = new LibraryMember("1001", "Andy", "Rogers", "641-223-2211", addresses.get(4));
		members.add(libraryMember);
		libraryMember = new LibraryMember("1002", "Drew", "Stevens", "702-998-2414", addresses.get(5));
		members.add(libraryMember);
		
		libraryMember = new LibraryMember("1003", "Sarah", "Eagleton", "451-234-8811", addresses.get(6));
		members.add(libraryMember);
		
		libraryMember = new LibraryMember("1004", "Ricardo", "Montalbahn", "641-472-2871", addresses.get(7));
		members.add(libraryMember);
		
		DataAccessFacade.loadMemberMap(members);	
	}
	
	///////////// DATA //////////////
	List<LibraryMember> members = new ArrayList<LibraryMember>();
	List<CheckoutEntry> allCheckoutRecords = new ArrayList<CheckoutEntry>();
	
	@SuppressWarnings("serial")
	public void checkoutRecordData(){
			System.out.println(members.size());
			allCheckoutRecords.add(new CheckoutEntry("123",members.get(0), allUsers.get(0),allBooks.get(0),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("124",members.get(1), allUsers.get(2),allBooks.get(1),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("125",members.get(2), allUsers.get(2),allBooks.get(2),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("126",members.get(2), allUsers.get(0),allBooks.get(3),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("127",members.get(2), allUsers.get(0),allBooks.get(0),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("128",members.get(1), allUsers.get(2),allBooks.get(2),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("129",members.get(0), allUsers.get(0),allBooks.get(1),LocalDate.now(), LocalDate.now()));
			allCheckoutRecords.add(new CheckoutEntry("143",members.get(2), allUsers.get(2),allBooks.get(1),LocalDate.now(), LocalDate.now()));
			DataAccessFacade.loadCheckoutRecordMap(allCheckoutRecords);
	};
	@SuppressWarnings("serial")
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
			add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
			add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
			add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
			add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
		}
	};
	
	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11451", "The Big Fish", 1, 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12331", "Antartica", 1, 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("99-22223", "Thinking Java", 1,  21, Arrays.asList(allAuthors.get(3))));
			add(new Book("48-56882", "Jimmy's First Day of School", 1, 7, Arrays.asList(allAuthors.get(4))));		
		}
	};
	
	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("abc", "abc", Auth.BOTH));
			add(new User("def", "def", Auth.ADMIN));
			add(new User("ghi", "ghi", Auth.LIBRARIAN));
		}
	};
	
}
