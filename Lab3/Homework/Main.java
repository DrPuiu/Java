import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Person John = new Person("John");
        Person Cristi = new Person("Cristi");
        Company Google = new Company("Google");
        Company Apple = new Company("Apple");
        John.addRelationship(Cristi, "friendship");
        John.addRelationship(Apple, "employee");
        network.addNode(John);
        network.addNode(Cristi);
        network.addNode(Google);
        network.addNode(Apple);
        network.getNodeList().sort(Network::compareByDegree);

        System.out.println(network);
    }
}