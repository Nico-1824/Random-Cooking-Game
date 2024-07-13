import java.util.ArrayList;
import java.util.Random;
public class RandomCuisine {
    FileIO fio = new FileIO();
    Random r = new Random();
    ArrayList<String> nations = new ArrayList<>();

    public String[] cookingArea() {
        int pick = r.nextInt(100);
        String[] arr = new String[2];

        if(pick % 2 == 0) {
            arr[0] = "Grill";
            arr[1] = "Stove";
        } else {
            arr[0] = "Stove";
            arr[1] = "Grill";
        }
        return arr;
    }

    public String nation() {
        nations = fio.convertToArr();
        StringBuilder nation = new StringBuilder();

        int pick = r.nextInt(nations.size());

        return nations.get(pick);
    }

}
