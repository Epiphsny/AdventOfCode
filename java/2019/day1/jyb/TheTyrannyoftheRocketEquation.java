import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class TheTyrannyoftheRocketEquation {
    
    public static void main(String[] args) {

        int fuel = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2019\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	int line = Integer.parseInt(reader.nextLine());
                fuel += (line / 3) - 2;
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Total Fuel: " + fuel);

    }

}
