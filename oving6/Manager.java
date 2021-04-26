package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	private List<Employee> employees;
	
	private int taskCount;
	private int nextDelegateIndex;
	
	
	public Manager(Collection<Employee> employees) {
		if (employees.size() == 0) {
			throw new IllegalArgumentException("No employees in this list");
		}
		this.taskCount = 0;
		this.nextDelegateIndex = 1;
		
		ArrayList<Employee> newList = new ArrayList<>(employees);
		this.employees = newList;
		
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		if (nextDelegateIndex< employees.size()) {
			nextDelegateIndex++;
		}
		else {
			nextDelegateIndex = 1;
		}
		return employees.get(nextDelegateIndex-1).doCalculations(operation, value1, value2);
	}
	

	@Override
	public void printDocument(String document) {
		taskCount++;
		if (nextDelegateIndex < employees.size()) {
			nextDelegateIndex++;
		} else {
			nextDelegateIndex = 1;
		}
		employees.get(nextDelegateIndex-1).printDocument(document);		
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		int count = 1;
		for (Employee employee: employees) {
			count += employee.getResourceCount();
		}
		return count;
	}

	public static void main(String[] args) {
		Printer printer = new Printer();
		Clerk c1 = new Clerk(printer);
		Clerk c2 = new Clerk(printer);
		Clerk c3 = new Clerk(printer);
		List<Employee> clerks = new ArrayList<>();
		clerks.add(c1);
		clerks.add(c2);
		clerks.add(c3);
		
		Manager managerLow = new Manager(clerks);
		System.out.println("Assistant manager resources: "+managerLow.getResourceCount());
		System.out.println("Assistant manager tasks: "+managerLow.getTaskCount());
		
		
		List<Employee> managerList = new ArrayList<>();
		managerList.add(managerLow);
		
		Manager managerHigh = new Manager(managerList);
		System.out.println("Top manager resources: "+managerHigh.getResourceCount());
		System.out.println("Top manager tasks: "+managerHigh.getTaskCount());
		
		managerHigh.printDocument("Hey");
		System.out.println("Top manager resources: "+managerHigh.getResourceCount());
		System.out.println("Top manager tasks: "+managerHigh.getTaskCount());
		System.out.println("Assistant manager resources: "+managerLow.getResourceCount());
		System.out.println("Assistant manager tasks: "+managerLow.getTaskCount());
		
		BinaryOperator<Double> func = (x1, x2) -> x1 + x2;
		
		managerLow.doCalculations(func, 1, 3);
		managerHigh.doCalculations(((x1,  x2) -> x1 + x2), 1, 3);
		
		System.out.println("Top manager resources: "+managerHigh.getResourceCount());
		System.out.println("Top manager tasks: "+managerHigh.getTaskCount());
		System.out.println("Assistant manager resources: "+managerLow.getResourceCount());
		System.out.println("Assistant manager tasks: "+managerLow.getTaskCount());
		
		managerLow.doCalculations(func, 1, 3);
		managerHigh.doCalculations(((x1,  x2) -> x1 + x2), 1, 3);
		
		System.out.println("Top manager resources: "+managerHigh.getResourceCount());
		System.out.println("Top manager tasks: "+managerHigh.getTaskCount());
		System.out.println("Assistant manager resources: "+managerLow.getResourceCount());
		System.out.println("Assistant manager tasks: "+managerLow.getTaskCount());
		
	}
}
