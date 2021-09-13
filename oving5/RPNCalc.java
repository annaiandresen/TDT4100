package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * A Reverse Polish Notation calculator which uses postfix notation rather that infix. 
 * I.e. 2+4 is the same as 2 4 + in RPN.
 * @author annai
 *
 */
public class RPNCalc {
	private List<Double> operands;
	private Map<Character, BinaryOperator<Double>> operators;
	private Map<Character, UnaryOperator<Double>> unaryOp;
	private Map<Character, Supplier<Double>> suppliers;
	
	
	public RPNCalc() {
		operands = new ArrayList<>();
		operators = new HashMap<>();
		unaryOp = new HashMap<>();
		suppliers = new HashMap<>();
	}
	/**
	 * Adds a number to the list
	 * @param number
	 */
	public void push(double number) {
		operands.add(0, number);
	}
	
	/**
	 * 
	 * @return The first value in the list
	 */
	public double pop() {
		double element = 0.0;
		try {
			element = operands.get(0);
			operands.remove(0);
		} catch (Exception e){
			element = Double.NaN;
		}
		return element;
	}
	
	public double peek(int i) {
		return i >= operands.size() || i < 0 ? Double.NaN : operands.get(i);
	}
	
	public int getSize() {
		return operands.size();
	}
	
	public boolean addOperator(char operator, BinaryOperator<Double> binaryOperator) {
		if (operators.containsKey(operator)) return false;
		operators.put(operator, binaryOperator);
		return true;
		
	}
	
	public boolean addOperator(char operator, UnaryOperator<Double> unaryOperator) {
		if (unaryOp.containsKey(operator)) return false;
		unaryOp.put(operator, unaryOperator);
		return true;
	}
	
	public boolean addOperator(char operator, Supplier<Double> supplier) {
		if (suppliers.containsKey(operator)) return false;
		suppliers.put(operator, supplier);
		return true;
	}
	
	public void removeOperator(char operator) {
		if (operators.containsKey(operator)) {
			operators.remove(operator);
		} else if (suppliers.containsKey(operator)) {
			suppliers.remove(operator);
		} else if (unaryOp.containsKey(operator)) {
			unaryOp.remove(operator);
		}
	}
	
	/**
	 * 
	 * @param operator "+", "-", "/", "*", "p", "~"(swap), "|" (absolute value)
	 */
	public void performOperation(char operator) {
		if (operators.containsKey(operator) && getSize() >= 2) {
			double num1 = pop();
			double num2 = pop();
			BinaryOperator<Double> op = operators.get(operator);
			push(op.apply(num2, num1));
		} else if (unaryOp.containsKey(operator) && getSize() >= 1) {
			double num1 = pop();
			UnaryOperator<Double> op = unaryOp.get(operator);
			push(op.apply(num1));
		} else if (suppliers.containsKey(operator)) {
			push(suppliers.get(operator).get());
		} else {
			throw new UnsupportedOperationException();
		}
	}
	

}
