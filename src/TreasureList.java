import java.util.ArrayList;

public class TreasureList {
    ArrayList<Treasure> listOfTreasure;

    TreasureList() {
        listOfTreasure = new ArrayList<>();
    }

    public void add(Treasure item){
        listOfTreasure.add(item);
    }

}