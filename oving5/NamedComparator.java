package interfaces;

import java.util.Comparator;

/**
 * Comparator that compares Named objects.
 * The comparator first compares family names, then given names.
 * @author annai
 *
 */
public class NamedComparator implements Comparator<Named>{
	
	
	@Override
	public int compare(Named named1, Named named2) {
		if (!named1.getFamilyName().equals(named2.getFamilyName())) {
			return named1.getFamilyName().compareTo(named2.getFamilyName());
		} else {
			return named1.getGivenName().compareTo(named2.getGivenName());
		}
	}

}
