public class Location {
    private String name;
    public int CoordonateX;
    public int CoordonateY;
    private LocationType locationType;


    public Location(String name, int coordonateX, int coordonateY, LocationType locationType) {
        this.name = name;
        CoordonateX = coordonateX;
        CoordonateY = coordonateY;
        this.locationType = locationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordonateX() {
        return CoordonateX;
    }

    public void setCoordonateX(int coordonateX) {
        CoordonateX = coordonateX;
    }

    public int getCoordonateY() {
        return CoordonateY;
    }

    public void setCoordonateY(int coordonateY) {
        CoordonateY = coordonateY;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", CoordonateX=" + CoordonateX +
                ", CoordonateY=" + CoordonateY +
                ", locationType=" + locationType +
                '}';
    }
}
