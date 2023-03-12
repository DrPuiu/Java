//cream clasa City care mosteneste clasa Location, ii adaugam perimetrul cerut si cream constructorul specific

public class City extends Location {
    private int population;

    public City(String name, int coordonateX, int coordonateY, int population) {
        super(name, coordonateX, coordonateY);
        this.population = population;

    }

}
