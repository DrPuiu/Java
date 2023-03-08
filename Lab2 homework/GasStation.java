public class GasStation extends Location{

    private int gasPrice;

    public GasStation(String name, int coordonateX, int coordonateY, int gasPrice) {
        super(name, coordonateX, coordonateY);
        this.gasPrice= gasPrice;
    }
}
