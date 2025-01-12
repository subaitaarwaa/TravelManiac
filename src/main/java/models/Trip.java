

package models;

import java.util.ArrayList;

public class Trip {
    public String tripName;     
    public String destination;   
    public String startDate;     
    public String endDate;       
    public ArrayList<Activity> activities;

    public Trip(String tripName, String destination, String startDate, String endDate) {
        this.tripName = tripName;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = new ArrayList<>();
    }
}