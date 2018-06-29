public class Trap extends Treasure {

    private boolean proceed;

    Trap (double distance){
        super(distance);
    }

    @Override
    public boolean checkWin(double distance) {

        setProceed(true);
        if (distance < 10) {
            setProceed(true);
            System.out.println("You've reached an ominous chest");
            System.out.println("Oh tiger. You're dead.");
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
