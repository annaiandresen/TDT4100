package encapsulation;

public class Test {
    public static void main(String args[]) 
    { 
        String str = "anna.andresen@gmail.com";
        String[] arrOfStr = str.split("@");
		String whole_name = arrOfStr[0];
		String domain = arrOfStr[1];
		String[] name1 = whole_name.split("\\.");
		String first_name = name1[0];
		String last_name = name1[1];
		
	}
} 
