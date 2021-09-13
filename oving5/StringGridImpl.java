package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringGridImpl implements StringGrid{
	private int rows;
	private int columnCount;
	private List<String> grid;
	
	public StringGridImpl(int rows, int columnCount){
		this.rows = rows;
		this.columnCount = columnCount;
		grid = new ArrayList<>();
		
		for(int i = 0; i< (rows*columnCount); i++) {
			grid.add(null);
		}
		
	}

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		if(row>rows || column > columnCount) throw new IllegalArgumentException();
		int index = calcIndex(row, column);
		return grid.get(index);
	}

	@Override
	public void setElement(int row, int column, String element) {
		if(row>rows || column > columnCount) throw new IllegalArgumentException();
		int index = calcIndex(row, column);
		grid.set(index, element);
		
	}
	
	/**
	 * Calculates the list index based on the position (x,y).
	 * @param x
	 * @param y
	 * @return the index
	 */
	public int calcIndex(int x, int y) {
		return y*rows + x;
	}
	
	public Iterator<String> iterator(){
		return grid.iterator();
	}
}
