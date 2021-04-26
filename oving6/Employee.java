package patterns.delegation.office;

import java.util.function.BinaryOperator;

public interface Employee {
	
	//regner ut resultatet av å utføre operation med argumentene value 1 og value 2
	double doCalculations(BinaryOperator<Double> operation, double value1, double value2);
	
	//printer document. Hvordan dette gjøres avhenger av den spesifikke implementasjonen
	void printDocument(String document);
	
	//returnerer hvor mange oppgaver (beregninger og printinger) som har blitt utført av eller på vegne av dette Employee-objektet
	int getTaskCount();
	
	//antallet employees til rådighet, 
	//inkludert Employee-objektet metoden blir kalt på. 
	//En Employee skal altså medregne seg selv i antall ressurser den ansatte har til rådighet. 
	//Dette tallet skal inkludere alle Employee-objekter nedover i hierarkiet.
	
	int getResourceCount();
}
