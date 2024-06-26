package Library_Management_System.dataaccess;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Library_Management_System.business.Book;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.business.LibraryMember;


public class DataAccessFacade implements DataAccess {
	
	enum StorageType {
		CHECKOUT, BOOKS, MEMBERS, USERS;
	}
	// Windows user can use
	
	/*public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage";*/
	
	// For Mac Users path can use / 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/Library_Management_System/dataaccess/storage";
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	//implement: other save operations
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		saveToStorage(StorageType.MEMBERS, mems);	
	}
	
	@SuppressWarnings("unchecked")
	public  HashMap<String,Book> readBooksMap() {
		//Returns a Map with name/value pairs being
		//   isbn -> Book
		return (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		//Returns a Map with name/value pairs being
		//   memberId -> LibraryMember
		return (HashMap<String, LibraryMember>) readFromStorage(
				StorageType.MEMBERS);
	}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		//Returns a Map with name/value pairs being
		//   userId -> User
		return (HashMap<String, User>)readFromStorage(StorageType.USERS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, CheckoutEntry> readCheckoutRecordMap() {
		//Returns a Map with name/value pairs being
		//   userId -> User
		return (HashMap<String, CheckoutEntry>)readFromStorage(StorageType.CHECKOUT);
	}
	
	/////load methods - these place test data into the storage area
	///// - used just once at startup  
	
		
	public static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();
		bookList.forEach(book -> books.put(book.getIsbn(), book));
		System.out.println(books);
		saveToStorage(StorageType.BOOKS, books);
	}
	public static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getId(), user));
		saveToStorage(StorageType.USERS, users);
	}
 
	public static void loadMemberMap(List<LibraryMember> memberList) {
		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		memberList.forEach(member -> members.put(member.getMemberId(), member));
		saveToStorage(StorageType.MEMBERS, members);
	}
	
	public static void loadCheckoutRecordMap(List<CheckoutEntry> checkoutEntryList) {
		HashMap<String, CheckoutEntry> checkoutEntries = new HashMap<String, CheckoutEntry>();
		checkoutEntryList.forEach(checkoutEntry -> checkoutEntries.put(checkoutEntry.getReocordId(), checkoutEntry));
		saveToStorage(StorageType.CHECKOUT, checkoutEntries);
	}
	
	static void saveToStorage(StorageType type, Object ob) {
		HashMap<String, LibraryMember> oldvalMember = new HashMap<String, LibraryMember>();
		HashMap<String, User> oldvalUser = new HashMap<String, User>();
		HashMap<String, Book> oldvalBooks = new HashMap<String, Book>();
		HashMap<String, CheckoutEntry> oldvalCheckoutEntries = new HashMap<String, CheckoutEntry>();
		
		if(type == StorageType.MEMBERS) {
		  oldvalMember =  (HashMap<String, LibraryMember>)readFromStorage(StorageType.MEMBERS);
		  if(oldvalMember != null) {
			  oldvalMember.putAll((HashMap<String, LibraryMember>)ob);
			  ob = (Object)oldvalMember;
		  }
		}
		
		if(type == StorageType.USERS) {
		  oldvalUser =  (HashMap<String, User>)readFromStorage(StorageType.USERS);
		  if(oldvalUser != null) {
			  oldvalUser.putAll((HashMap<String, User>) ob);
			  ob = (Object)oldvalUser;
		  }
		}
		
		if(type == StorageType.BOOKS) {
			oldvalBooks =  (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
			if(oldvalBooks != null) {
				oldvalBooks.putAll((HashMap<String,Book>) ob);
				ob = (Object)oldvalBooks;
			}
		}
		
		if(type == StorageType.CHECKOUT) {
			System.out.println("loading checkout");
			oldvalCheckoutEntries =  (HashMap<String, CheckoutEntry>) readFromStorage(StorageType.CHECKOUT);
			if(oldvalCheckoutEntries != null) {
				oldvalCheckoutEntries.putAll((HashMap<String, CheckoutEntry>) ob);
				ob = (Object)oldvalCheckoutEntries;
			}
		}
		
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			boolean pathExists = Files.exists(path);
			if(pathExists) {
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
			}else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
	
}
