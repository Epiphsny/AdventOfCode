import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class ChronalCalibration {
    
    public static void main(String[] args) {

        int frequency = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2018\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                if (line.charAt(0) == '+') {
                    frequency += Integer.parseInt(line.substring(1));
                }
                else {
                    frequency -= Integer.parseInt(line.substring(1));
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Final frequency: " + frequency);

    }

}
