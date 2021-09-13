package inheritance;

import java.util.ArrayList;
import java.util.Collection;

public class Train {
	private Collection<TrainCar> cars;
	private int totalWeight;
	private int passengerCount;
	private int cargoWeight;
	
	
	public Train() {
		cars = new ArrayList<>();
		totalWeight = getTotalWeight();
		passengerCount = getPassengerCount();
		cargoWeight = getCargoWeight();
	}
	public void addTrainCar(TrainCar car) {
		cars.add(car);
	}
	
	public boolean contains(TrainCar car) {
		return cars.contains(car);
	}
	
	public int getTotalWeight() {
		totalWeight = 0;
		cars.stream().forEach(c -> totalWeight += c.getTotalWeight());
		return totalWeight;
	}
	
	public int getPassengerCount() {
		passengerCount = 0;
		for (TrainCar car : cars) {
			if (car instanceof PassengerCar) {
				passengerCount += ((PassengerCar) car).getPassengerCount();
			}
		}
		return passengerCount;
	}
	
	public int getCargoWeight() {
		cargoWeight = 0;
		cars.stream().filter(car -> car instanceof CargoCar).forEach(c -> cargoWeight += ((CargoCar) c).getCargoWeight());
		return cargoWeight;
	}
}
