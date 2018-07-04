import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;

import java.util.Scanner;

public class Main {

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

        Goal win = new Goal(Math.random() * 1000);

        main.list = new TreasureList();

        main.list.add(win);
        main.list.add(gold);
        main.list.add(gold1);
        main.list.add(gold2);
        main.list.add(trap);
        main.list.add(trap1);

        System.out.println("You've woken up to a mysterious, unfamiliar landscape. The distance illuminated by the moonlight.");
        System.out.println("You notice you're wearing a watch like compass that points in a direction.");
        System.out.print("A number appears on the bottom. ");

        double lowest = 1000;

        //CAN'T RUN THIS SECTION OUTSIDE THIS DUMB CLASS
        System.out.println("");
        for (int x = 1;x < main.list.listOfTreasure.size();x++){
            if (main.list.listOfTreasure.get(x-1).getDistance() < lowest){
                lowest = main.list.listOfTreasure.get(x-1).getDistance();
            }
            System.out.println(main.list.listOfTreasure.get(x-1).getClass() + " " + main.list.listOfTreasure.get(x-1).getDistance() );
        }

        System.out.println("Lowest: " + lowest);

        boolean continu = true;
        Compass player = new Compass(lowest);
        /*player.setDistance(win.getDistance());*/

        do {
            System.out.println("The compass indicates " + (int)lowest);
            System.out.println("There are multiple chests throughout the game. The compass automatically points to the closest chest to you.");
            System.out.print("Enter a direction. 'North', 'South', 'East', 'West': ");
            String direction = sc.next();

            System.out.print("Enter a distance (Meters): ");
            double distance = sc.nextDouble();

            //Changes distance based on direction met and meters.
            win.travel(direction.toLowerCase(), distance);
            /*gold.travel(direction.toLowerCase(), distance);
            gold1.travel(direction.toLowerCase(), distance);
            gold2.travel(direction.toLowerCase(), distance);
            trap.travel(direction.toLowerCase(), distance);
            trap1.travel(direction.toLowerCase(), distance);*/

            //updates the distance to the nearest chest once calculates the travel.
            player.setDistance(win.getDistance());
            continu = win.checkWin(player.getDistance());
            continu = trap.checkWin(player.getDistance());
            continu = trap1.checkWin(player.getDistance());

        } while (continu);
    }
}
