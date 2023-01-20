package Production;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    private List<RequestTrip> requestTrips = new LinkedList<>();

    public void addRequestTrip(RequestTrip requestTrip) {
        requestTrips.add(requestTrip);
    }

    public List<RequestTrip> getRequestTrips() {
        return requestTrips;
    }

}
