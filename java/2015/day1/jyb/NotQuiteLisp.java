import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class NotQuiteLisp {
    
    public static void main(String[] args) {

        int floor = 0;
        int position = 0;
        boolean basement = false;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2015\\day1_input.txt");
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
                    if (floor == -1 && !basement) {
                        position = i + 1;
                        basement = true;
                    }
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Floor: " + floor);
        System.out.println("Position: " + position);

    }

}
