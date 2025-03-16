import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class IWasToldThereWouldBeNoMath {
    
    public static void main(String[] args) {

        int smallest = 0;
        int sum = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2015\\day2_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                String[] digits = line.split("x");
                int l = Integer.parseInt(digits[0]);
                int w = Integer.parseInt(digits[1]);
                int h = Integer.parseInt(digits[2]);
                int lw = l * w;
                int wh = w * h;
                int hl = h * l;
                smallest = Math.min(lw, Math.min(wh, hl));
                sum += smallest + lw*2 + wh*2 + hl*2;
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Total square feet of wrapping paper: " + sum);

    }

}
