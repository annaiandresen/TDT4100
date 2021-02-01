package stateandbehavior;

public class Location {
	//states
	private int x;
	private int y;
	
//	//constructor
//	public Location(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
	
	//getters
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	//methods
	public void up() {
		y--; //skal ikke denne være +? men testfilen sier at man skal trekke ifra. 
	}
	
	public void down() {
		y++; //skal ikke denne være -? men testfilen sier at man skal trekke ifra.
	}
	
	public void left() {
		x--;
	}
	
	public void right() {
		x++;
	}
	
	@Override
	public String toString() {
		return "Du befinner deg nå på: [" + x + "," + y + "]";
	}
	
	public static void main(String[] args) {
		//Location loc = new Location(0,0);
		System.out.println(loc);
		loc.up();
		loc.right();
		System.out.println(loc);
	}
}