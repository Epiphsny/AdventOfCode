import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class Dive {
    
    public static void main(String[] args) {

        String command;
        int value;
        int index;
        int horizontal = 0;
        int depth = 0;
        int answer;
        int aim = 0;

        try {
			File data = new File("C:\\SWE\\AdventOfCode\\resources\\2021\\day2_input.txt");
		    Scanner reader = new Scanner(data);
		    while (reader.hasNextLine()) {
                command = "";
                index = 0;
		    	String line = reader.nextLine();
                while (line.charAt(index) != ' ') {
                    command += line.charAt(index++);
                }
                value = Integer.parseInt("" + line.charAt(index+1));
                if (command.compareTo("forward") == 0) {
                    horizontal += value;
                    depth += (aim * value);
                }
                else if (command.compareTo("down") == 0) {
                    aim += value;
                }
                else if (command.compareTo("up") == 0) {
                    aim -= value;
                }
		    }
		    reader.close();
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		}

        answer = horizontal * aim;

        System.out.println("Answer: " + answer);

        answer = horizontal * depth;

        System.out.println("Answer: " + answer);

    }
}
