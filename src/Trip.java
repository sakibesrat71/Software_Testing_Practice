public class Trip {
	private String rideType;
	private int dist;
	private int minutes;
	private int noPass;
	
	public Trip(String rideType,
	            int dist,
	            int minutes,
	            int noPass) {
		this.rideType = rideType;
		this.dist = dist;
		this.minutes = minutes;
		this.noPass = noPass;
	}
	
	public void requestTrip() {
		if (rideType == "MOTOR_BIKE") {
			System.out.println("== Ride Swift in Bike ==");
		} else if (rideType == "SEVEN_SEATER") {
			System.out.println("== Ride with Friends and Family in Seven-Seater ==");
		} else {
			System.out.println("== Comfortable Sedan Ride ==");
		}
		
		if (canTakeTrip()) {
			System.out.println(dist + " KM");
			System.out.println(minutes + " Minutes");
			System.out.println(perHeadFare() + " Taka Per Person");
		} else {
			System.out.println("Invalid Trip Request");
		}
	}
	
	public int perHeadFare() {
		int fare = -1;
		switch (rideType) {
			case "SEDAN":
				fare = (50 + dist * 30 + minutes * 2) / noPass;
				break;
			case "MOTOR_BIKE":
				fare = Math.max(25, dist * 20) / noPass;
				break;
			default:
				if (dist < 10)
					fare = 300 / noPass;
				else
					fare = (dist * 30) / noPass;
				
				break;
		}
		
		return fare - (fare % 5);
	}
	
	public boolean canTakeTrip() {
		if (noPass < 1)
			return false;
		
		switch (rideType) {
			case "SEDAN":
				return noPass <= 4 && dist <= 25;
			case "SEVEN_SEATER":
				return noPass <= 7 && dist >= 10;
			default:
				return noPass <= 1 && dist <= 10;
		}
	}
}
