package encapsulation;
import java.util.Date;
import java.util.Arrays;

public class Person {
	public String name;
	private String email;
	private char gender;
	private Date date;

	//A string array with country codes
	public String[] countryCodes = new String[] {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	public void setName(String firstName, String lastName) {
		if (firstName.length() < 2 || lastName.length() < 2){
			throw new IllegalArgumentException("The length of both names need to be greater than two");
		}
		name = firstName + lastName;
	}
	
	public void setEmail(String str) {
		String[] parts = str.split("@");
		
		//name:
		String whole_name = parts[0];
		String[] whole_name_array = whole_name.split("\\.");
		String first_name = whole_name_array[0];
		String last_name = whole_name_array[1];
		String wholeName = first_name + last_name;
		
		//email:
		String email1 = parts[1];
		String[] email_array = email1.split("\\.");
		String domain = email_array[0];
		String cCode = email_array[1];
		if (str.length() == 0) {
			throw new IllegalArgumentException("Email address is too short");
		}
		else if (wholeName.toLowerCase() != name.toLowerCase()) {
			throw new IllegalArgumentException("Name does not match");
		}
		else if (!checkCountryCode(cCode)) {
			throw new IllegalArgumentException("Invalid country code");
		}
		else {
			this.email = str;
		}
	}
	
	public boolean checkCountryCode(String countryCode) {
		boolean test = Arrays.asList(countryCodes).contains(countryCode);
		if (test)
			return true;
		else {
			return false;
		}
		
	}
	public void setBirthday(Date date) {
		//something to validate
		this.date = date;
	}
	
	public void setGender(char chr) {
		String[] genders = {"M", "F", "\0"};
		boolean test = Arrays.asList(genders).contains(chr);
		if (!test) {
			throw new IllegalArgumentException("Invalid country code");
		}
		gender = chr;
	}
	
	public static void main(String[] args) {
		}
}
