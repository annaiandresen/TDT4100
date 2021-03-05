package objectstructures;

public class Partner {
	private Partner partner;
	private String name;
	
	
	public Partner (String name) {
		this.name = name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	public String getName() {
		return name;
	} 
	
	public void setPartner(Partner partner) {
		if (this.partner == partner) {
			return;
		}
		Partner oldPartner = this.partner;
	    this.partner = partner;
	    if (oldPartner != null && oldPartner.getPartner() == this) {
	        oldPartner.setPartner(null);
	    }
	    
	    if (this.partner != null) {
	        this.partner.setPartner(this);
	    }
	}
	
	@Override
	public String toString() {
		//String partner = String.valueOf(this.partner); hvorfor funker ikke denne?
		//System.out.println(partner);
		return "Name: " + name;
	}

	public static void main(String[] args) {
		Partner anna = new Partner("Anna");
		Partner halvard = new Partner("Halvard");
		anna.setPartner(halvard);
		System.out.println(anna);
		System.out.println(halvard);
		
		
	}
}
