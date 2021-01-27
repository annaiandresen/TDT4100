package stateandbehavior;

public class LineEditor {
	private String text;
	private int insertionIndex;
	
	//Getters
	public String getText() {
		return text;
	}
	
	public int getInsertionIndex() {
		return insertionIndex;
	}
	
	//Setters
	public void setText(String text) {
		this.text = text;
	}
	
	public void setInsertionIndex(int insertionIndex) {
		this.insertionIndex = insertionIndex;
	}
	
	//Metoder
	public void left() {
		//flytter tekstinnsettingsposisjonen ett tegn til venstre (tilsvarende bruk av venstre piltast)
		insertionIndex -= insertionIndex;
	}
	
	public void right() {
		//flytter tekstinnsettingsposisjonen ett tegn til h�yre (tilsvarende bruk av h�yre piltast)
		insertionIndex += insertionIndex;
	}
	
	public void insertString(String s) {
		//skyter teksten angitt av argumentet s inn i teksten p� tekstinnsettingsposisjonen og forskyver tekstinnsettingsposisjonen mot h�yre tilsvarende
	}
	
	public void deleteLeft() {
		//fjerner tegnet til venstre for tekstinnsettingsposisjonen
		//charRemoveAt() fjerner tegn
		text = text.substring(0, insertionIndex) + text.substring(insertionIndex, text(-1));
	}
	
	public void deleteRight() {
		//fjerner tegnet til h�yre for tekstinnsettingsposisjonen
	}
	//toString
	@Override
	public String toString() {
		return "";
	}
	//Main
	public static void main(String[] args) {
		  System.out.println("");
		}
}
