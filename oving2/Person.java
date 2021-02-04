package encapsulation;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Person {
	private String name;
	private String email;
	private char gender;
	private Date birthday;
	
	
	//name
	public void setName(String name) {
		validateName(name);
		this.name = name;
	}
	
	private void validateName(String name) {
		if (!name.matches("^[A-Za-z]{2,} [A-Za-z]{2,}$"))
			throw new IllegalArgumentException("Invalid name");
	}

	
	//email
	public void setEmail(String email) {
		if (email == null) {
			this.email = null;
		}
		validateEmail(email);
		this.email = email;
	}
	
	//checks country code
	private void checkCountryCode(String countryCode) {
		//A string array with country codes
		String[] countryCodes = new String[] {"com","ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		if (!(Arrays.asList(countryCodes).contains(countryCode)))
			throw new IllegalArgumentException("Invalid country code in email address");
		}

	
	private void validateEmail(String email) {
		if (!(email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"))) {
			throw new IllegalArgumentException("Invalid email");
		}
		//hvis koden over ikke utløser en exception, vil det være mulig å splitte strengen.
		String[] parts = email.split("@");
		String domain = parts[1];
		String[] domainParts = domain.split("\\.");
		String countryCode = domainParts[1];
		
		String name = parts[0];
		String[] nameList = name.split("\\.");
		String wholeName = nameList[0] + " "+ nameList[1];

		//check country code
		checkCountryCode(countryCode.toLowerCase());
		
		//check if name is similar
		if (!wholeName.toLowerCase().equals(this.name.toLowerCase())) {
			throw new IllegalArgumentException("Name in email does not match real name");
		}
	}
	
	//birthday
    public void setBirthday(Date birthday) {
        Date now = new Date();
        if (birthday.before(now)) {
            this.birthday = birthday;
        }
        else {
            throw new IllegalArgumentException("Invalid date");
        }
    }
	
    
    //gender
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
		return "Navn: "+name+"\nE-post: "+email+"\nBursdag: "+birthday+"\nKjønn: "+gender;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		Date bday = parseDate("1996-01-29");
		
		p.setName("Anna Andresen");
		p.setBirthday(bday);
		p.setGender('M');
		p.setEmail("anna.andresen@gmail.com");
		System.out.println(p);
		}
}
