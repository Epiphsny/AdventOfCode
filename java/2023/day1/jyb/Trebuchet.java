import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class Trebuchet {
    
    public static void main(String[] args) {

        int sum = 0;
        int Firstdigit;
        int Lastdigit;
        boolean foundFirstDigit;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2023\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                foundFirstDigit = false;
                Firstdigit = 0;
                Lastdigit = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        if (!foundFirstDigit) {
                            Firstdigit = Character.getNumericValue(line.charAt(i));
                            Lastdigit = Firstdigit;
                            foundFirstDigit = true;
                        }
                        else {
                            Lastdigit = Character.getNumericValue(line.charAt(i));
                        }
                    }
                }
                sum += ((Firstdigit * 10) + Lastdigit);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Sum: " + sum);

        sum = 0;
        // Part 2 not finished
        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2023\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                foundFirstDigit = false;
                Firstdigit = 0;
                Lastdigit = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        if (!foundFirstDigit) {
                            Firstdigit = Character.getNumericValue(line.charAt(i));
                            Lastdigit = Firstdigit;
                            foundFirstDigit = true;
                        }
                        else {
                            Lastdigit = Character.getNumericValue(line.charAt(i));
                        }
                    }
                }
                sum += ((Firstdigit * 10) + Lastdigit);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Sum: " + sum);

    }

}
