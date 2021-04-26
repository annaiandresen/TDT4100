package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	
	//må ha et objekt som lagrer printhistory til en employee
	//dictionary-lignende object => HASHMAP
	private Map<Employee, List<String>> employeeHistory = new HashMap<>();
	
	public void printDocument(String document, Employee employee) {
		if (!employeeHistory.containsKey(employee)) {
			
			//må først generere en liste, da dette er spesifisert i hashmappen
			List<String> docs = new ArrayList<>();
			docs.add(document);
			
			
			employeeHistory.put(employee, docs);
			System.out.println(document);
		}
		else {
			employeeHistory.get(employee).add(document);
			System.out.println(document);
		}
	}
	
	public List<String> getPrintHistory(Employee employee){
		/*
		returnerer en List med alle dokumentene som har blitt printet av 
		employee av denne printeren i rekkefølgen de har blitt printet. 
		Om employee ikke har printet noen dokumenter ved denne printeren 
		skal en tom liste returneres.
		*/
		
		if (!employeeHistory.containsKey(employee)) {
			//skal returnere en tom liste dersom denne employeen ikke har en printhistory
			List<String> emptyList = new ArrayList<>();
			return emptyList;
		}
		
		//lag heller en kopi av det man returnerer!! ellers kan noen endre på objektet. 
		return new ArrayList<>(employeeHistory.get(employee));
	}
}
