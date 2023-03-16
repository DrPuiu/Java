import java.util.HashMap;
import java.util.Map;

public class Company implements  Node{
    private String name;

    protected Map<Node, String> relationships;

    public Company(String name) {
        this.name = name;
        relationships = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addRelationship(Node node, String relationship)
    {
        relationships.put(node, relationship);
        node.getRelationships().put(this, relationship);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<Node, String> getRelationships() {
        return relationships ;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(o.toString());
    }
}
