public class Airport extends Location {
    private int noTerminals;

    public Airport(String name, int coordonateX, int coordonateY, int noTerminals) {
        super(name, coordonateX, coordonateY);
        this.noTerminals = noTerminals;
    }
}
