public class Gold extends Treasure {

    private double dropAmount;

    Gold(double distance, int dropAmount) {
        super(distance);
        this.dropAmount = dropAmount;
    }

    public double getDropAmount() {
        return dropAmount;
    }

    public void setDropAmount(double dropAmount) {
        this.dropAmount = dropAmount;
    }
}
