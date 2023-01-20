package Production;

public class Vehicle{
	String name;
	int minimum_fare = 0;
	int per_km_fare=0;
	int minimum_number_of_passenger;
	int minimum_distance;
	
	public Vehicle(String name, int minimum_fare, int per_km_fare,int minimum_number_of_passenger,int minimum_distance) {
		this.name = name;
		this.minimum_fare = minimum_fare;
		this.per_km_fare = per_km_fare;
		this.minimum_distance=minimum_distance;
		this.minimum_number_of_passenger = minimum_number_of_passenger;
	}
	

	public void msgAfterChoosingVehicle() {
		switch(name) {
			case "SEDAN": {System.out.println("== Comfortable Sedan Ride =="); break;}
			case "SEVEN_SEATER": {System.out.println("== Ride with Friends and Family in Seven-Seater =="); break;}
			case "MOTOR BIKE": {System.out.println("== Ride Swift in Bike =="); break;}
			default: {System.out.println("== Ride Swift in " + name +" =="); break;}
			
			
		}
	}
	
}
