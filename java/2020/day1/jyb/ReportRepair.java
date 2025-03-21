import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class ReportRepair {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		
		try {
			File data = new File("C:\\SWE\\AdventOfCode\\resources\\2020\\day1_input.txt");
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

		for (int numberCompare1: list) {
			for (int numberCompare2: list) {
				if ((numberCompare1 + numberCompare2) == 2020) {
						answer = numberCompare1 * numberCompare2;
				}
			}
		}

		System.out.println("Answer: " + answer);
		
		for (int numberBase: list) {
			for (int numberCompare1: list) {
				for (int numberCompare2: list) {
					if ((numberBase + numberCompare1 + numberCompare2) == 2020) {
						answer = numberBase * numberCompare1 * numberCompare2;
					}
				}
			}
		}
		
		System.out.println("Answer: " + answer);

	}

}
