import java.util.ArrayList;

public abstract class Treasure implements distance {

    ArrayList<Treasure> treasures;

    private boolean proceed = true;
    private double distance;
    private String heading;

    Treasure(double distance) {
        this.setDistance(distance);
        this.heading = rdmDirection(Math.random()*10);
    }

    @Override
    public void travel(String direction, double playerTravel) {
        //if player goes in right direction
        if (playerTravel > 500){

            System.out.println("You begin to feel tired. You need to rest for a bit.");
            this.setDistance(this.getDistance() - (playerTravel/4));

        } else if (playerTravel > 200){

            System.out.println("You're sweating and it feels like you need a break. Sit down son.");
            this.setDistance(this.getDistance() - (playerTravel/2));

        } else if (playerTravel > 100) {
            System.out.println("You've walked quite a bit. Chillax perhaps?");
            this.setDistance(this.getDistance() - (playerTravel/2));
        } else {
            if (this.heading.equals(direction)) {
                this.setDistance(this.getDistance() - playerTravel);

            } else { //increments if its the wrong direction.
                this.setDistance(this.getDistance() + playerTravel);
            }
        }
    }

    public abstract boolean checkWin(double distance);

    public String rdmDirection(double random) {
        String[] four = {"north", "west", "south", "east"};
        String result = "";

        if (random < 3) {
            result = four[0];
        } else if (random > 2 && random < 6){
            result = four[1];
        } else if (random >=6 && random <= 8) {
            result = four[2];
        } else {
            result = four[3];
        }
        return result;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public abstract boolean isProceed();

    public abstract void setProceed(boolean proceed);

}
