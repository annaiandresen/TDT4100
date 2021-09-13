package interfaces;

/**
 * An interface with methods for managing the content of a String grid. 
 * The grid has a number of rows (height) and columns (width).
 * In each cell in the grid there is a String that can be set with the setElement method
 * and read with the getElement method
 * @author annai
 *
 */
public interface StringGrid {
 
    /**
     * 
     * @return the number of rows in this StringGrid
     */
	public int getRowCount();
   
	
	/**
	 * 
	 * @return the number of columns in this StringGrid
	 */
    public int getColumnCount();

    /**
     * 
     * @param row
     * @param column
     * @return The String at the given row and column
     * @throws IllegalArgumentException if the row or column is out of range
     */
    public String getElement(int row, int column) throws IllegalArgumentException;
    
    /**
     * Sets a String element at the given row and column
     * @param row
     * @param column
     * @param element 
     * @throws IllegalArgumentException if the row or column is out of range
     */
    public void setElement(int row, int column, String element) throws IllegalArgumentException;
    
    

}
