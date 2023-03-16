import java.util.Date;

public class Programmer extends Person {

    protected boolean hasExperience;

    public Programmer(String name, boolean hasExperience) {
        super(name);
        this.hasExperience = hasExperience;
    }

    public Programmer(String name) {
        super(name);
    }
}
