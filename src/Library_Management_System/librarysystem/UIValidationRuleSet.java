package Library_Management_System.librarysystem;

import java.util.List;
import java.util.regex.Pattern;

import Library_Management_System.business.Address;
import Library_Management_System.business.Author;


public class UIValidationRuleSet {

	private static StringBuilder msg;
	
	public static String loginValidation(String userName,String password) {
		msg=new StringBuilder("");
		if(isNullOrEmpty(userName))
			msg.append("User name is required!!\n");
		
		if(isNullOrEmpty(password))
			msg.append("Password is required!!\n");
		
		return msg.toString();
	}
	
	public static String checkoutValidation(String memberId,String isbn) {
		msg=new StringBuilder("");
		
		if(isNullOrEmpty(memberId))
			msg.append("Member ID is required!!\n");
		
		if(isNullOrEmpty(isbn))
			msg.append("Book ISBN is required!!\n");
		
		return msg.toString();
	}
	
	public static String addbookValidation(String isbn, String title,
			String copyNum, List<Author> authors) {
		msg=new StringBuilder("");
		
		if(isNullOrEmpty(isbn))
			msg.append("ISBN is required!!\n");
		
		if(isNullOrEmpty(title))
			msg.append("Book title is required!!\n");
		
		if(isNullOrEmpty(copyNum) || copyNum=="0")
			msg.append("Copy Num is required!!\n");
		
		if(authors.size()==0)
			msg.append("Author detail is required!");
				
		return msg.toString();
	}
	public static String addAuthorValidation(String firstName,String lastName,String contactNumber, 
			String state,String city,String street,String zip) {
		msg=new StringBuilder("");
		msg.append(alphabetValidation(firstName,"First Name"));
		msg.append(alphabetValidation(lastName,"Last Name"));
		msg.append(mobileNumValidation(contactNumber,"Contact Number"));
		msg.append(addressValidation(state,city,street,zip));
		
		return msg.toString();
	}
	
	public static String addBookCopyValidation(String isbn,String noOfCopy) {
		msg=new StringBuilder("");
		if(isNullOrEmpty(isbn))
			msg.append("ISBN is required!!\n");
		
		if(isNullOrEmpty(noOfCopy)|| noOfCopy.trim()=="0")
			msg.append("No. of copies is required!!\n");
		
		return msg.toString();
	}
	
	public static String addMemberValidation(String firstName, String lastName,
			  String tel, String street, String state, String city,String zip) {
		
		msg=new StringBuilder("");
		msg.append(alphabetValidation(firstName,"First Name"));
		msg.append(alphabetValidation(lastName,"Last Name"));
		msg.append(mobileNumValidation(tel,"Contact Number"));
		msg.append(addressValidation(state,city,street,zip));
		
		return msg.toString();
	}
	
	public static String addressValidation(String state,String city,String street,String zip) {
		StringBuilder msg1=new StringBuilder("");
		msg1.append(alphabetValidation(state,"State"));
		msg1.append(alphabetValidation(city,"City"));
		msg1.append(alphabetValidation(street,"Street"));
		msg1.append(zipCodeValidation(zip));
        return msg1.toString();
	}
	
	private static String alphabetValidation(String s,String fieldName) {
		if(isNullOrEmpty(s)) {
			return fieldName+" is required\n";
		}
		
		String regex = "^[a-zA-Z\\s-]*$";
        Pattern pattern = Pattern.compile(regex);
        if(!pattern.matcher(s).matches()) {
        	return "Invalid " +fieldName + "\n";
        }
        
		return "";
	}
	
	public static String mobileNumValidation(String phoneNo,String fieldName) {
		if(isNullOrEmpty(phoneNo)) {
			return fieldName+" is required\n";
		}
		
		 String regex = "^\\+?[0-9]{10}$";
		 phoneNo = phoneNo.replaceAll("\\+", "");
	        
        Pattern pattern = Pattern.compile(regex);
	        
        if(!pattern.matcher(phoneNo).matches()) {
        	return "Invalid "+fieldName+"\n";
        }
        return "";
	}
	
	public static boolean isNullOrEmpty(String s) {
		if(s==null||s.isEmpty()||s.trim()=="")
			return true;
		
		return false;
	}
	
	public static String zipCodeValidation(String zip) {
		String msg="";
		if(isNullOrEmpty(zip)) {
			msg="Zip Code is required!\n";
		}
		else {
			String regex = "^\\d{5}(?:-\\d{4})?$";
	        Pattern pattern = Pattern.compile(regex);
	        if(!pattern.matcher(zip).matches())
	        	msg = "Invalid Zip Code!\n";
		}        
        return msg;
	}
	
	
}
