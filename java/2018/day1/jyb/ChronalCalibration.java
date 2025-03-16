import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class ChronalCalibration {
    
    public static void main(String[] args) {

        ArrayList<String> frequencyChanges = new ArrayList<String>();
        ArrayList<Integer> previousFrequencies = new ArrayList<Integer>();
        int frequency = 0;
        int frequencyTwice = 0;
        boolean found = false;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2018\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                if (line.charAt(0) == '+') {
                    frequency += Integer.parseInt(line.substring(1));
                }
                else {
                    frequency -= Integer.parseInt(line.substring(1));
                }
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Final frequency: " + frequency);

        frequency = 0;
        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2018\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine() && !found) {
            	String line = reader.nextLine();
                if (frequencyChanges.contains(line)) {
                    for (int i = 0; i < frequencyChanges.size(); i++) {
                        if (frequencyChanges.get(i).charAt(0) == '+') {
                            frequency += Integer.parseInt(frequencyChanges.get(i).substring(1));
                        }
                        else {
                            frequency -= Integer.parseInt(frequencyChanges.get(i).substring(1));
                        } 
                        if (previousFrequencies.contains(frequency)) {
                            frequencyTwice = frequency;
                            found = true;
                            break;
                        }
                        previousFrequencies.add(frequency);
                    }
                }
                if (found) {
                    break;
                }
                frequencyChanges.add(line);
                if (line.charAt(0) == '+') {
                    frequency += Integer.parseInt(line.substring(1));
                }
                else {
                    frequency -= Integer.parseInt(line.substring(1));
                }
                if (previousFrequencies.contains(frequency)) {
                    frequencyTwice = frequency;
                    found = true;
                    break;
                }
                previousFrequencies.add(frequency);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        System.out.println("Frequancy Found Twice: " + frequencyTwice);

    }

}
