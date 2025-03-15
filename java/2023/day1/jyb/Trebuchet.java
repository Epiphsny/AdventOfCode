import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class Trebuchet {
    
    public static void main(String[] args) {

        int sum = 0;
        int digit1;
        int digit2;
        boolean foundDigit1;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2024\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                foundDigit1 = false;
                digit1 = 0;
                digit2 = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        if (!foundDigit1) {
                            digit1 = Character.getNumericValue(line.charAt(i));
                            foundDigit1 = true;
                        }
                        else {
                            digit2 = Character.getNumericValue(line.charAt(i));
                        }
                    }
                }
                sum += digit1 + digit2;
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Sum: " + sum);

    }

}
