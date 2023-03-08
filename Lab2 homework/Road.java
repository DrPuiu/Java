public class Road {

    private int lenght;
    private int speedlimit;
    private Location location1;
    private Location location2;

    public Road(int lenght, int speedlimit, Location location1, Location location2) {
        this.lenght = lenght;
        this.speedlimit = speedlimit;
        this.location1 = location1;
        this.location2 = location2;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getSpeedlimit() {
        return speedlimit;
    }

    public void setSpeedlimit(int speedlimit) {
        this.speedlimit = speedlimit;
    }

    public Location getLocation1() {
        return location1;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }


    @Override
    public String toString() {
        return "Road{" +
                "lenght=" + lenght +
                ", speedlimit=" + speedlimit +
                ", location1=" + location1 +
                ", location2=" + location2 +
                '}';
    }
}
