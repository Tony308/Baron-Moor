public class Compass {
    //Compass is essentially the player.
    private double distance;

    Compass(double dist) {
        this.distance = dist;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return Math.round(distance);
    }
}
