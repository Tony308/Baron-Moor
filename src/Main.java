import java.util.ArrayList;
import java.util.Scanner;

public class Main  {

    static double goalDistance = Math.random() * 1000;
    public TreasureList list;
    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        Gold gold = new Gold(Math.random() * 1000, (int)Math.random() * 1000);
        Gold gold1 = new Gold(Math.random() * 1000, (int)Math.random() * 1000);
        Goal win = new Goal(goalDistance);
        Compass player = new Compass(goalDistance);


        System.out.println("You've woken up to a mysterious, unfamiliar landscape. The distance illuminated by the moonlight.");
        System.out.println("You notice you're wearing a watch like compass that points in a direction.");
        System.out.print("A number appears on the bottom. " );

        /*double goalDistance = Math.random() * 1000;*/
        main.list = new TreasureList();
        main.list.add(win);
        main.list.add(gold);
        main.list.add(gold1);


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

            //While true execute
        } while (win.checkWin(player.getDistance()));

    }
}
