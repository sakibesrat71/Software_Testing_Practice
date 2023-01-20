package Production;

import Production.Per_head_fare;

import java.util.Date;

public class RequestTrip {
	Date date;
	Vehicle vehicle;
	Trip2 trip2;
	Trip_decider trip_decider;

	User user;
	public enum STATUS {
		ACCEPTED,
		REJECTED,
		PENDING
	}
	private STATUS tripStatus = null;
	public RequestTrip(Date date, Vehicle vehicle, Trip2 trip2, Trip_decider trip_decider,User user) {
		this.date = date;
		this.vehicle = vehicle;
		this.trip2 = trip2;
		this.trip_decider = trip_decider;
		this.user = user;
	}
	public void setStatus(STATUS status ){
		tripStatus = status;
	}
	public STATUS getStatus() { return tripStatus; }
	public void requestTrip( ) {
		vehicle.msgAfterChoosingVehicle();
		user.addRequestTrip(this);
		try {
			if (trip_decider.canTakeTrip(vehicle, trip2)) {
				System.out.println("Thanks " + trip2.user);
				System.out.println("trip distance: " + trip2.distance + " KM");
				System.out.println(trip2.minutes + " Minutes");
				tripStatus = STATUS.ACCEPTED;
				//System.out.println(perHeadFare() + " Taka Per Person");
			} else {
				System.out.println("Sorry Trip Request rejected");
				System.out.println("Yoour Production.Vehicle " + vehicle.name + " needs atleast " +
						vehicle.minimum_number_of_passenger + " of passenger or atleast " +
						vehicle.minimum_distance + " km of distance");
				tripStatus = STATUS.REJECTED;
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public int calculateFare() {
		return Per_head_fare.perHeadFare(vehicle, trip2);
	}
}
