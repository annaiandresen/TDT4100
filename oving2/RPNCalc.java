package encapsulation;

import java.util.ArrayList;
import java.util.List;

/**
 * A Reverse Polish Notation calculator which uses postfix notation rather that infix. 
 * I.e. 2+4 is the same as 2 4 + in RPN.
 * @author annai
 *
 */
public class RPNCalc {
	private List<Double> list = new ArrayList<>();
	
	/**
	 * Adds a number to the list
	 * @param number
	 */
	public void push(double number) {
		list.add(0, number);
	}
	
	/**
	 * 
	 * @return The first value in the list
	 */
	public double pop() {
		double element = 0.0;
		try {
			element = list.get(0);
			list.remove(0);
		} catch (Exception e){
			element = Double.NaN;
		}
		return element;
	}
	
	public double peek(int i) {
		return i >= list.size() || i < 0 ? Double.NaN : list.get(i);
	}
	
	public int getSize() {
		return list.size();
	}
	
	/**
	 * 
	 * @param operator "+", "-", "/", "*", "p", "~"(swap), "|" (absolute value)
	 */
	public void performOperation(char operator) {
		double num1 = pop();
		double num2 = pop();
		double result = 0.0;
		
		switch (operator) {
		case '+':
			result = num1 + num2;
			push(result);
			break;
		case '-':
			result = num2 - num1;
			push(result);
			break;
		case '/':
			result = num2 / num1;
			push(result);
			break;
		case '*':
			result = num1 * num2;
			push(result);
			break;
		case 'p':
			push(Math.PI);
			break;
		case '~':
			double el1 = pop();
			double el2 = pop();
			push(el1);
			push(el2);
			break;
		case '|':
			double d = pop();
			push(Math.abs(d));
			break;
		}
	}
	

}
