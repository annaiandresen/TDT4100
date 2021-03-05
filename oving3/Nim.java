package encapsulation;

public class Nim {
	private int[] pile;
	
	//Constructors
	public Nim(int pileSize) {
		int[] pile = {pileSize, pileSize, pileSize};
		this.pile = pile;
	}
	
	public Nim() {
		int[] pile = {10, 10, 10};
		this.pile = pile;
	}
	
	//Getter
	public int getPile(int targetPile) {
		if (targetPile < 0 || targetPile > 2) {
			throw new IllegalArgumentException("Invalid target pile: Out of bounds");
		}
		return pile[targetPile];
	}
	
	public void removePieces(int number, int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException("Game is already over!");
		}else if (!isValidMove(number, targetPile)) {
			throw new IllegalArgumentException("Invalid move!");
		}
		pile[targetPile] -= number;
	}
	
	//validators
	public boolean isValidMove(int number, int targetPile) {
		if (isGameOver() || targetPile < 0 || targetPile > 2) {
			return false;
		}else if (number < 1 || number > getPile(targetPile)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isGameOver() {
		for (int i=0; i<3; i++) {
			if (pile[i] == 0) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("Pile 1: %d cards \nPile 2: %d cards\nPile 3: %d cards\n",
				pile[0], pile[1], pile[2]);
	}
	
	public static void main(String[] args) {
		Nim game = new Nim(6);
		game.removePieces(2, 1);
		System.out.println(game);
		game.removePieces(1, 0);
		System.out.println(game);
	}
}