package encapsulation;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Person {
	private String name;
	private String email;
	private char gender;
	private Date birthday;
	
	public void setName(String name) {
		String [] nameArray = name.split(" ");
		String firstName = nameArray[0];
		String lastName = nameArray[1];
		//mangler sjekk for mellomnavn
		if (!isNameValid(name)) {
			throw new IllegalArgumentException("The string contains illegal characters");
		}
		else if (firstName.length() < 2 || firstName.length() < 2){
			throw new IllegalArgumentException("The length of both names need to be greater than two characters");
		}
		this.name = firstName +" "+ lastName;
	}
	
	public void setEmail(String str) {
		if (str.length() == 0) {
			throw new IllegalArgumentException("Email address is too short");
		}
		
		String[] parts = str.split("@");
		
		//name:
		String whole_name = parts[0];
		String[] whole_name_array = whole_name.split("\\.");
		String first_name = whole_name_array[0];
		String last_name = whole_name_array[1];
		String wholeName = first_name + " "+ last_name;
		System.out.println("Is "+wholeName+" equal to "+name+"?");
		
		//email:
		String email1 = parts[1];
		String[] email_array = email1.split("\\.");
		//String domain = email_array[0];
		String cCode = email_array[1];
		if (!checkName(wholeName)) {
			throw new IllegalArgumentException("Name does not match");
		}
		else if (!checkCountryCode(cCode)) {
			throw new IllegalArgumentException("Invalid country code");
		}
		this.email = str;
	}
	
	//checks country code
	public boolean checkCountryCode(String countryCode) {
		//A string array with country codes
		String[] countryCodes = new String[] {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		boolean test = Arrays.asList(countryCodes).contains(countryCode);
		if (test)
			return true;
		else {
			return false;
		}
		
	}
	
	//checks if name is similar
	public boolean checkName(String wholeName) {
		if(wholeName.toLowerCase() == name.toLowerCase()) {
			return true;
		}else {
			return false;
		}
	}
	
	//checks name
	public boolean isNameValid(String name) {
		String invalidChr = "@-.,:;1234567890";
		boolean test = Arrays.asList(invalidChr).contains(name);
		if (test || name.contains(" ")){
			return true;
		}
		else {
			return false;
		}
	}
	
	
    public void setBirthday(Date birthday) {
        Date now = new Date();
        if (birthday.before(now)) {
            this.birthday = birthday;
        }
        else {
            throw new IllegalArgumentException("Invalid date");
        }
    }
	
    
	public void setGender(char gender) {
		if (gender == 'M' || gender == 'F' || gender == '\0'){
				this.gender = gender;	
		}
		else {
			throw new IllegalArgumentException("Invalid gender; type `M`, `F`, or `\0`");
		}
	}
	
	//Getters
    public Date getBirthday() {
    	return birthday;
    }
	
    public String getName() {
    	return name;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public char getGender() {
    	return gender; 
    }
    
	//funnet på stackoverflow for å formatere date på formen "YYYY-MM-DD"
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	@Override
	public String toString() {
		//overrider den innebygde toString() 
		return "Navn: "+name+"\nE-post: "+email+"\nBursdag: "+birthday+"\nKjønn: "+gender;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		Date bday = parseDate("1996-01-29");
		
		p.setName("Anna Andresen");
		p.setBirthday(bday);
		p.setGender('M');
		System.out.println(p);
		}
}
