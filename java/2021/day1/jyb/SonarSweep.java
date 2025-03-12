import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Author Justin Babineau jbabine1
public class SonarSweep {
    
    public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		int answer = 0;
        int curr = 0;
        int next = 0;
		
		try {
			File data = new File("C:\\SWE\\AdventOfCode\\resources\\2021\\day1_input.txt");
		    Scanner reader = new Scanner(data);
		    while (reader.hasNextLine()) {
		    	String line = reader.nextLine();
		        list.add(Integer.parseInt(line));
		    }
		    reader.close();
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		}

        curr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            next = list.get(i);
            if (next > curr) {
                answer++;
            }
            curr = next;
        }

        System.out.println("Answer: " + answer);

    }

}
