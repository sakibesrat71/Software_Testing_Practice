package Production;

import Production.Trip2;

public class Trip_decider {
//Production.Vehicle vehicle;
Trip2 trip2;
//	public Production.Trip_decider(Production.Vehicle vehicle, Production.Trip2 trip2) {
//		this.vehicle = vehicle;
//		this.trip2 = trip2;
//	}
	public String tripDecider;
	public Trip_decider(String tripDecider) {
		this.tripDecider = tripDecider;
	}
	public boolean canTakeTrip(Vehicle vehicle, Trip2 trip2) throws Exception {
		if (trip2.numberOfPassenger < 1)
			throw new Exception("Invalid number for passenger");
		
		switch (vehicle.name) {
			case "SEDAN":
				return trip2.numberOfPassenger <= vehicle.minimum_number_of_passenger && trip2.distance <= vehicle.minimum_distance;
			case "SEVEN_SEATER":
				return trip2.numberOfPassenger <= vehicle.minimum_number_of_passenger && trip2.distance >= vehicle.minimum_distance;
			default:
				return trip2.numberOfPassenger<= vehicle.minimum_number_of_passenger && trip2.distance <= 10;
		}
	}
}
