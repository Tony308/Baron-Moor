public class Gold extends Treasure {

    private double dropAmount;
    private boolean proceed;

    Gold(double distance, int dropAmount) {
        super(distance);
        this.dropAmount = dropAmount;
    }
    @Override
    public boolean checkWin(double distance) {

        setProceed(true);
        if (distance < 10) {
            this.setProceed(true);
            System.out.println("You tripped over something.");
            System.out.println("It looks like a treasure chest. You un-asunder it and find gold inside ");
            System.out.println(this.getDropAmount() + " to be exact." );
            System.out.println("But you're stuck in the middle of nowhere ... Where do you think you're gonna spend such dead weight?");
        }

        return this.isProceed();
    }
    public double getDropAmount() {
        return dropAmount;
    }

    public void setDropAmount(double dropAmount) {
        this.dropAmount = dropAmount;
    }

    @Override
    public boolean isProceed() {
        return proceed;
    }

    @Override
    public void setProceed(boolean proceed) {
        this.proceed = proceed;
    }
}
