import java.util.Map;

public interface Node extends Comparable {
    public String getName();
    public Map<Node, String> getRelationships();
    public void addRelationship(Node node, String relationship);


}
