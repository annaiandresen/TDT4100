package interfaces;

/**
 * @author annai
 *
 */
public interface Named {
	
	String getGivenName();
	
	String getFamilyName();
	
	String getFullName();
	
	void setGivenName(String name);
	
	void setFamilyName(String familyName);
	
	/**
	 * Sets full name
	 * @param fullName name + " " + "familyName"
	 */
	void setFullName(String fullName);
}
