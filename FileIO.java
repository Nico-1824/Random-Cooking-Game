import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FileIO {
    String nationsPath = "/Users/nicobrizuela/Downloads/CookingApp/Cooking.txt";
    String pointsPath = "/Users/nicobrizuela/Downloads/CookingApp/Points.txt";

    public void createFile() {
        try {
            File f = new File("Cooking.txt");
            File points = new File("Points.txt");
            if(points.createNewFile()) {
                System.out.println("Points Created");
            } else {
                System.out.println("Exists");
            }
            if(f.createNewFile()) {
                System.out.println("File Created!");
            } else {
                System.out.println("Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePoints(String text) {
        try {
            FileWriter writer = new FileWriter(pointsPath);
            writer.write(text);
            writer.close();
            System.out.println("Wrote");
        } catch (IOException e) {

        }
    }

    public void writeToFile(String path, String text) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.close();
            System.out.println("Wrote");
        } catch (IOException e) {

        }
    }

    public String readFile(String path) {
        StringBuilder data = new StringBuilder();
        try {
            File f = new File(path);
            Scanner reader = new Scanner(f);
            while(reader.hasNextLine()) {
                data.append(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new String(data);
    }

    public ArrayList<String> convertToArr() {
        ArrayList<String> arr = new ArrayList<>();
        try {
            File f = new File(nationsPath);
            Scanner sc = new Scanner(f);
            while(sc.hasNext()) {
                arr.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
