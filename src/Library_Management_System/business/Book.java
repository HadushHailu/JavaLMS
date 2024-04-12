package Library_Management_System.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 */
final public class Book implements Serializable {
	
	private static final long serialVersionUID = 6110690276685962829L;
	private List<BookCopy> copies;
	private List<Author> authors;
	private String isbn;
	private String title;
	private int maxCheckoutLength;
	public Book(String isbn, String title, int copyNum, int maxCheckoutLength, List<Author> authors) {
		this.isbn = isbn;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.authors = Collections.unmodifiableList(authors);
		
		copies = new ArrayList<>();	
		this.addCopy(copyNum);
	}
	
//	public void updateCopies(BookCopy copy) {
//		for(int i = 0; i < copies.size(); ++i) {
//			BookCopy c = copies.get(i);
//			if(c.equals(copy)) {
//				copies.set(i, copy);	
//			}
//		}
//	}

	public List<Integer> getCopyNums() {
		List<Integer> retVal = new ArrayList<>();
		for(BookCopy c : copies) {
			retVal.add(c.getCopyNum());
		}
		return retVal;
		
	}
	
	public void addCopy(int numCopy) {
		int currentNumCopy = copies.size();
		
		for(int i=0; i < numCopy; i++) {
			BookCopy bc = new BookCopy(this, copies.size() + 1, true);
			copies.add(bc);
		}
	}
	
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Book b = (Book)ob;
		return b.isbn.equals(isbn);
	}
	
	
	public boolean isAvailable() {
		
		BookCopy[] tCopies = copies.toArray(new BookCopy[copies.size()]);
		if(tCopies == null) {
			return false;
		}
		return Arrays.stream(tCopies)
				     .map(l -> l.isAvailable())
				     .reduce(false, (x,y) -> x || y);
	}
	@Override
	public String toString() {
		return "isbn: " + isbn + ", maxLength: " + maxCheckoutLength + ", available: " + isAvailable();
	}
	
	public int getNumCopies() {
		return copies.size();
	}
	
	public String getTitle() {
		return title;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public BookCopy getNextAvailableCopy() {
//		BookCopy[] tCopies = copies.toArray(new BookCopy[copies.size()]);
//		
//		System.out.println("getNextAvailableCopy" + tCopies.length);
//		
//		Optional<BookCopy> optional 
//			= Arrays.stream(tCopies)
//			        .filter(x -> x.isAvailable()).findFirst();
//		
//		System.out.println("getNextAvailableCopy" + optional.isPresent());
//		return optional.isPresent() ? optional.get() : null;
		BookCopy bookcopy = null;
		for(BookCopy bc: copies) {
			if(bc.isAvailable() == true) {
				bookcopy =  bc;
			}
		}
		return bookcopy;
	}
	
	public BookCopy getCopy(int copyNum) {
		for(BookCopy c : copies) {
			if(copyNum == c.getCopyNum()) {
				return c;
			}
		}
		return null;
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	
	
	
	
}
