import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class InventoryManagementSystem {
    
    public static void main(String[] args) {

        int checksum = 0;
        int count2 = 0;
        int count3 = 0;
        int[] alphabet = new int[26];
        int letterPos = 0;
        boolean found2;
        boolean found3;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2018\\day1_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                found2 = false;
                found3 = false;
                for (int i = 0; i < line.length(); i++) {
                    letterPos = line.charAt(i) - 97;
                    alphabet[letterPos]++;
                }
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == 2 && !found2) {
                        count2++;
                        found2 = true;
                    }
                    if (alphabet[i] == 3 && !found3) {
                        count3++;
                        found3 = true;
                    }
                    if (found2 && found3) {
                        break;
                    }
                }
                alphabet = new int[26];
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        checksum = count2 * count3;

        System.out.println("Checksum: " + checksum);

    }

}
