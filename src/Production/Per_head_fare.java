package Production;

public class Per_head_fare {
	
	public static int perHeadFare(Vehicle vehicle, Trip2 trip2) {
		int fare = -1;
		switch (vehicle.name) {
			case "SEDAN":
				fare = (vehicle.minimum_fare + trip2.distance * vehicle.per_km_fare + trip2.minutes * 2) ;
				break;
			case "MOTOR_BIKE":
				fare = Math.max(vehicle.minimum_fare, trip2.distance * vehicle.per_km_fare) ;
				break;
			default:
				if (trip2.distance < 10)
					fare = trip2.minimumFarefortrip;
				else
					fare = (trip2.distance * 30) / trip2.numberOfPassenger;
				
				break;
		}
		
		return fare - (fare % 5);
	}
}
