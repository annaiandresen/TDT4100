package interfaces;

public class Person2 implements Named{
	private String fullName;
	
	
	public Person2(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getGivenName() {
		String[] name = fullName.split(" ");
		return name[0];
	}

	@Override
	public String getFamilyName() {
		String[] name = fullName.split(" ");
		return name[1];
	}

	@Override
	public String getFullName() {
		return fullName;
	}

	@Override
	public void setGivenName(String name) {
		String[] names = fullName.split(" ");
		fullName = name + " " + names[1];
		
	}

	@Override
	public void setFamilyName(String familyName) {
		String[] names = fullName.split(" ");
		fullName = names[0] + " " + familyName;
		
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
		
	}

}
