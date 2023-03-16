import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodeList;
    public static Integer getDegree(Node node){
        return node.getRelationships().size();
    }

    public List<Node> getNodeList() {
        return nodeList;
    }
    public static int compareByDegree(Node node1, Node node2)
    {
        return -getDegree(node1).compareTo(getDegree(node2));
    }

    public void addNode(Node node){
        nodeList.add(node);
    }
    Network()
    {
        nodeList = new ArrayList<>();
    }

    @Override
    public String toString() {

        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }
}
