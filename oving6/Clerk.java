package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
	
	private Printer printer;
	private int taskCount = 0;
	
	//konstruktør
	public Clerk (Printer printer) {
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		//regner ut resultatet av å utføre operation med argumentene value1 og value2.
		
		taskCount++;
		//BinaryOperator tar to values og kalkulerer verdien deres, i.e.:
		//(value1, value2) -> value1 + value2
		return operation.apply(value1, value2);
		
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
		taskCount++;
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}

}
