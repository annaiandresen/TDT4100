package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{
	private StringGrid grid;
	private boolean rowMajor;
	private int row;
	private int column;
	
	/**
	 * 
	 * @param grid
	 * @param rowMajor A boolean that says whether the iterator should be row wise (true) or column wise (false)
	 */
	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid;
		this.rowMajor = rowMajor;
		row = 0;
		column = 0;
		
	}

	@Override
	public boolean hasNext() {
		return grid.getColumnCount() > column && grid.getRowCount() > row;
	}

	@Override
	public String next() {
		String element = grid.getElement(row, column);
		if (rowMajor) {
			column++;
			if (column >= grid.getColumnCount()){
				column = 0;
				row++;
			}
		} else {
			row++;
			if (row >= grid.getRowCount()) {
				row = 0;
				column++;
			}
		}
		return element;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
