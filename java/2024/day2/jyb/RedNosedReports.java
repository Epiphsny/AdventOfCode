package day2.jyb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedNosedReports {
    
    public static void main(String[] args) {

        String direction;
        int difference;
        int removedLevel;
        int totalSafe = 0;
        int previous;
        boolean safe;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2024\\day2_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                String[] parts = line.split(" ");
                if (Integer.parseInt(parts[0]) < Integer.parseInt(parts[1])) {
                    direction = "increasing";
                }
                else {
                    direction = "decreasing";
                }
                previous = Integer.parseInt(parts[0]);
                safe = true;
                for (int i = 1; i < parts.length; i++) {
                    if (direction.equals("increasing") && previous > Integer.parseInt(parts[i])) {
                        safe = false;
                    }
                    else if (direction.equals("decreasing") && previous < Integer.parseInt(parts[i])) {
                        safe = false;
                    }
                    else {
                        difference = Math.abs(Integer.parseInt(parts[i]) - previous);
                        if (difference < 1 || difference > 3) {
                            safe = false;
                        }
                    }
                    previous = Integer.parseInt(parts[i]);
                }
                if (safe) {
                    totalSafe++;
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Total Safe: " + totalSafe);

        totalSafe = 0;
        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2024\\day2_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                String[] parts = line.split(" ");
                if (Integer.parseInt(parts[0]) < Integer.parseInt(parts[1])) {
                    direction = "increasing";
                }
                else {
                    direction = "decreasing";
                }
                previous = Integer.parseInt(parts[0]);
                safe = true;
                removedLevel = 0;
                for (int i = 1; i < parts.length; i++) {
                    if (direction.equals("increasing") && previous > Integer.parseInt(parts[i])) {
                        if (removedLevel == 0) {
                            removedLevel++;
                        }
                        else {
                            safe = false;
                        }
                    }
                    else if (direction.equals("decreasing") && previous < Integer.parseInt(parts[i])) {
                        if (removedLevel == 0) {
                            removedLevel++;
                        }
                        else {
                            safe = false;
                        }
                    }
                    else {
                        difference = Math.abs(Integer.parseInt(parts[i]) - previous);
                        if (difference < 1 || difference > 3) {
                            if (removedLevel == 0) {
                                removedLevel++;
                            }
                            else {
                                safe = false;
                            }
                        }
                    }
                    if (removedLevel == 1) {
                        removedLevel++;
                    }
                    else {
                        previous = Integer.parseInt(parts[i]);
                    }
                }
                if (safe) {
                    totalSafe++;
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("New Total Safe: " + totalSafe);

    }

}
