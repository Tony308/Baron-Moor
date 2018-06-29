import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;

import java.util.Scanner;

public class Main {

    static double goalDistance = Math.random() * 1000;
    public TreasureList list;
    public static Main main;

    public static void main(String[] args) {
        main = new Main();

        Scanner sc = new Scanner(System.in);

        Gold gold = new Gold(Math.random() * 1000, (int) Math.random() * 1000);
        Gold gold1 = new Gold(Math.random() * 1000, (int) Math.random() * 1000);
        Gold gold2 = new Gold(Math.random() * 1000, (int) Math.random() * 1000);

        Trap trap = new Trap(Math.random() * 1000);
        Trap trap1 = new Trap(Math.random() * 1000);


        Goal win = new Goal(goalDistance);
        Compass player = new Compass(goalDistance);

        System.out.println("You've woken up to a mysterious, unfamiliar landscape. The distance illuminated by the moonlight.");
        System.out.println("You notice you're wearing a watch like compass that points in a direction.");
        System.out.print("A number appears on the bottom. ");

        /*double goalDistance = Math.random() * 1000;*/
        main.list = new TreasureList();

        main.list.add(win);
        main.list.add(gold);
        main.list.add(gold1);

        //CAN'T RUN THIS SECTION OUTSIDE THIS DUMB CLASS
        double[] compare = new double[3];
        int counter = 0;
        //puts all values inside double array
        for (Treasure item : main.list.listOfTreasure) {
            compare[counter] = item.getDistance();
            counter++;
        }
        //stores the lowest value hopefully
        double lowest = 1;

        counter = 0;
        if (compare[counter] > compare[counter + 1]) {
            lowest = compare[counter + 1];
        } else {
            lowest  = compare[counter];
        }

        counter = 1;

        do {
            if (compare[counter] < lowest) {
                lowest = compare[counter];
            }
            counter++;
        } while (counter < compare.length);
        //

        player.setDistance(lowest);
        boolean continu = true;

        do {
            System.out.println("The compass indicates " + (int) player.getDistance());

            System.out.print("Enter a direction. 'North', 'South', 'East', 'West': ");
            String direction = sc.next();
            direction.toLowerCase();

            System.out.print("Enter a distance (Meters): ");
            double distance = sc.nextDouble();

            //Changes distance based on direction met and meters.
            win.travel(direction, distance);
            //updates distance of player from goal.
            player.setDistance(win.getDistance());

            continu = win.checkWin(player.getDistance());
            gold.checkWin(player.getDistance());
            gold1.checkWin(player.getDistance());
            gold2.checkWin(player.getDistance());

            //While true execute
        } while (continu);
    }
}
