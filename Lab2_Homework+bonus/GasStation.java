//cream clasa GasStation care mosteneste clasa Location, ii adaugam perimetrul cerut si cream constructorul specific

public class GasStation extends Location {

    private int gasPrice;

    public GasStation(String name, int coordonateX, int coordonateY, int gasPrice) {
        super(name, coordonateX, coordonateY);
        this.gasPrice = gasPrice;
    }
}
