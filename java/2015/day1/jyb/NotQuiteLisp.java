import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class NotQuiteLisp {
    
    public static void main(String[] args) {

        int floor = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2019\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                for (int i=0; i<line.length(); i++) {
                    if (line.charAt(i) == '(') {
                        floor++;
                    }
                    else if (line.charAt(i) == ')') {
                        floor--;
                    }
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Floor: " + floor);

    }

}
