import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class CalorieCounting {

	public static void main(String[] args) {
		
		int topCal1 = 0;
		int topCal2 = 0;
		int topCal3 = 0;
		int curCal = 0;
		
		try {
			File data = new File("C:\\SWE\\AdventOfCode\\resources\\2022\\day1_input.txt");
		    Scanner reader = new Scanner(data);
		    while (reader.hasNextLine()) {
		    	String line = reader.nextLine();
		        if (line.compareTo("") == 0) {
		        	if (curCal > topCal1) {
		        		topCal3 = topCal2;
		        		topCal2 = topCal1;
		        		topCal1 = curCal;
		        	}
		        	else if (curCal > topCal2) {
		        		topCal3 = topCal2;
		        		topCal2 =  curCal;
		        	}
		        	else if (curCal > topCal3) {
		        		topCal3 =  curCal;
		        	}
		        	curCal = 0;
		        }
		        else {
		        	curCal += Integer.parseInt(line);
		        }
		    }
		    reader.close();
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		}
		
		int sumTopCal = topCal1 + topCal2 + topCal3;
		
		System.out.println("Max Calories: " + topCal1);
		System.out.println("Sum Top Calories: " + sumTopCal);
		
	}

}
