import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HistorianHysteria {
    
    public static void main(String[] args) {

        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> RightList = new ArrayList<Integer>();
        int distance = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2021\\day3_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                String[] parts = line.split("   ");
                leftList.add(Integer.parseInt(parts[0]));
                RightList.add(Integer.parseInt(parts[1]));
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        leftList.sort(null);
        RightList.sort(null);

        for (int i = 0; i < leftList.size(); i++) {
            distance += Math.abs(leftList.get(i) - RightList.get(i));
        }

        System.out.println("Total Distance: " + distance);

    }

}
