import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Location city1 = new City("location1", 50, 50, 100);
        Location city2 = new Airport("location1", 60, 60, 1000);
        Road road1 = new Country(50, 90, city1, city2);

        Problem problem = new Problem();
        problem.addLocation(city1);
        problem.addLocation(city2);
        problem.addRoad(road1);
        Algorithm algorithm = new Dijkstra(problem);
        Solution solution = algorithm.solve();
    }

}