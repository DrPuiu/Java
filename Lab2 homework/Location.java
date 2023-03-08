import java.util.Objects;

public abstract class Location {
    private String name;
    public int CoordonateX;
    public int CoordonateY;

    public Location(String name, int coordonateX, int coordonateY) {
        this.name = name;
        CoordonateX = coordonateX;
        CoordonateY = coordonateY;
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


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", CoordonateX=" + CoordonateX +
                ", CoordonateY=" + CoordonateY +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return CoordonateX == location.CoordonateX && CoordonateY == location.CoordonateY && name.equals(location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CoordonateX, CoordonateY);
    }
}
