package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

/**
 * An iterator which implements Iterator<Double>
 * @author annai
 *
 */
public class BinaryComputingIterator implements Iterator<Double> {
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private BinaryOperator<Double> operator;
	private Double default1;
	private Double default2;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		default1 = null;
		default2 = null;
		
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this(iterator1, iterator2, operator);
		this.default1 = default1;
		this.default2 = default2;
		
	}

	@Override
	public boolean hasNext() {
		if (iterator1.hasNext() && iterator2.hasNext()) {
			return true;
		} else if (!iterator1.hasNext() && iterator2.hasNext() && default1 != null) {
			return true;
		} else if (!iterator2.hasNext() && iterator1.hasNext() && default2 != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Double next() {
		while (hasNext()) {
			if (iterator1.hasNext() && iterator2.hasNext()) {
				return operator.apply(iterator1.next(), iterator2.next());

			} else if (!iterator1.hasNext() && iterator2.hasNext() && default1 != null) {
				return operator.apply(default1, iterator2.next());

			} else if (!iterator2.hasNext() && iterator1.hasNext() && default2 != null) {
				return operator.apply(iterator1.next(), default2);
			}
		}return null;
	}
	
	/**
	 * Fra LF
	 * 
	 * 	public BinaryComputingIterator(final Iterator<Double> iterator1, final Iterator<Double> iterator2, final BinaryOperator<Double> operator) {
		this(iterator1, iterator2, null, null, operator);
	}

	@Override
	public boolean hasNext() {
		return (iterator1.hasNext() || default1 != null) && (iterator2.hasNext() || default2 != null) && (iterator1.hasNext() || iterator2.hasNext());
	}

	@Override
	public Double next() {
		final Double next1 = (iterator1.hasNext() ? iterator1.next() : default1);
		final Double next2 = (iterator2.hasNext() ? iterator2.next() : default2);
		return operator.apply(next1, next2);
	}

	 */

}
