public class Designer extends Person{
    private boolean isWealthy;
    public Designer(String name) {
        super(name);
    }

    public Designer(String name, boolean isWealthy) {
        super(name);
        this.isWealthy = isWealthy;
    }
}
