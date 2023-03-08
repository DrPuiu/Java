import java.sql.SQLOutput;

public class    Main {
    public static void main(String[] args) {
        Location location1= new Location("location1", 50, 50, LocationType.CITY);
        Location location2= new Location("location1", 60, 60, LocationType.CITY);
        Road road1 = new Road(50, 90, location1, location2, RoadType.EXPRESS );
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(road1);
    }

}