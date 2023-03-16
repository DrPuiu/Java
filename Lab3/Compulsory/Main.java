import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> list = new ArrayList<>();

        list.add(new Person("Ana"));
        list.add(new Person("Dana"));
        System.out.println(list);

    }
}