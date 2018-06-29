public class Goal extends Treasure implements distance {

    /*private String heading;*/

    Goal (double distance){
        super(distance);
    }

    private boolean proceed;

    @Override
    public boolean checkWin(double distance) {

        setProceed(true);
        if (distance < 10) {
            setProceed(false);
            System.out.println("You've found a box which appears to be a door way home. You leap through hoping it's real.");
        } else {
            setProceed(true);
            System.out.println("You're still here?");
        }
        return this.isProceed();
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