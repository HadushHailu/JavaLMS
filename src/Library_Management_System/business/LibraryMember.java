package Library_Management_System.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<CheckoutEntry> checkoutRecord;
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
		checkoutRecord = new ArrayList();
	}
	
	public void addCheckoutRecord(CheckoutEntry checkoutEntry) {
		checkoutRecord.add(checkoutEntry);
	}
	
	public String getMemberId() {
		return memberId;
	}

	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
