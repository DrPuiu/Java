import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node {
    protected String name;
    protected Date birthDate;
    protected Map<Node, String> relationships;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        relationships= new HashMap<>();
    }
    public void addRelationship(Node node, String relationship)
    {
        relationships.put(node, relationship);
        node.getRelationships().put(this, relationship);
    }
    public Person(String name) {
        this.name = name;
        this.birthDate = null;
        relationships = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(o.toString());
    }
}
