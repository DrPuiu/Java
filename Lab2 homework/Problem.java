import java.util.ArrayList;

public class Problem {
    private Location[] locations;
    private int locationCount;
    private Road[] roads;
    private int roadCount;

    private boolean isValid(Road road, Location location1, Location location2) {
        if road.getLenght()<(Math.sqrt((location2.CoordonateY - location1.CoordonateY) * (location2.CoordonateY - location1.CoordonateY) + (location2.CoordonateX - location1.CoordonateX) * (location2.CoordonateX - location1.CoordonateX)))
          return false  ;
        return true;
    }

    public Problem() {
        locations= new Location[10];
        roads= new Road[10];
        roadCount=0;
        locationCount=0;
    }
    public void addRoad(Road road){
        roads[roadCount]= road;
        roadCount++;
    }
    public void addLocation (Location location){
        locations[locationCount]= location;
        locationCount++;
    }
}
