package interfaces;

public class Person1 implements Named{
	private String givenName;
	private String familyName;
	
	public Person1 (String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public String getFullName() {
		return givenName + " " + familyName;
	}

	@Override
	public void setGivenName(String name) {
		this.givenName = name;
		
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
		
	}

	@Override
	public void setFullName(String fullName) {
		String[] names = fullName.split(" ");
		if (names.length == 2) {
			givenName = names[0];
			familyName = names[1];
		}
	}

}
