import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Author Justin Babineau jbabine1
public class SonarSweep {
    
    public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		int prev = 0;
        int curr = 0;
        int next = 0;
		int currSum = 0;
		int nextSum = 0;
		
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

		answer = 0;

		prev = list.get(0);
        curr = list.get(1);
		next = list.get(2);
		currSum = prev + curr + next;
        for (int i = 3; i < list.size(); i++) {
            prev = curr;
			curr = next;
			next = list.get(i);
			nextSum = prev + curr + next;
            if (nextSum > currSum) {
                answer++;
            }
            currSum = nextSum;
        }

        System.out.println("Answer: " + answer);
    }
}