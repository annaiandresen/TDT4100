package inheritance;

public class TrainCar {
	
	private int deadWeight;
	
	public TrainCar(int n) {
		deadWeight = n;
	}
	
	public int getTotalWeight() {
		return deadWeight;
	}
	
	public void setDeadWeight(int n){
		deadWeight = n;
		
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	
}
