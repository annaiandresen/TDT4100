package patterns.observable;

import java.util.Scanner;

public class HighscoreProgram implements HighscoreListListener{
	
	public HighscoreList highscoreList;
	Scanner reader = new Scanner(System.in);
	
	
	@Override
	public void listChanged(HighscoreList highscoreList, int position) {
		System.out.println(highscoreList);
		System.out.println("Position " + position+1 + " has changed to " + (highscoreList.getElement(position)));
		
	}
	
	public void init() {
		//void init() - oppretter en ny HighscoreList og registrerer seg selv (altså HighscoreListProgram-instansen) som lytter
		HighscoreList list = new HighscoreList(5);
		list.addHighscoreListListener(this);
	}
	
	public void run() {
		//leser inn tall (resultater) fra konsollet og legger dem til i listen
		System.out.println("Input results here: \nWrite 'Quit' to quit");
		String str = "";
		
		while (!str.equals("Quit")) {
			str = reader.nextLine();
			
			try {
				int result = Integer.valueOf(str);
				highscoreList.addResult(result);
				
			} catch(Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		HighscoreProgram prog = new HighscoreProgram();
		prog.init();
		prog.run();
	}
	

}
