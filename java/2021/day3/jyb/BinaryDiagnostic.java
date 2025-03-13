import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Author Justin Babineau Epiphsny
public class BinaryDiagnostic {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        int answer;
        String gammaRateBin = "";
        String epsilonRateBin = "";
        int gammaRate = 0;
        int epsilonRate = 0;
        int dataLength = 0;
        int dataLines = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2021\\day3_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                dataLength = line.length();
                list.add(line);
            }
            dataLines = list.size();
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        int[] array = new int[dataLength];

        for (int i = 0; i < dataLength; i++) {
            for (int j = 0; j < dataLines; j++) {
                if (list.get(j).charAt(i) == '1') {
                    array[i]++;
                }
            }
        }

        for (int i = 0; i < dataLength; i++) {
            if (array[i] > (dataLines / 2)) {
                gammaRateBin += "1";
                epsilonRateBin += "0";
            }
            else {
                gammaRateBin += "0";
                epsilonRateBin += "1";
            }
        }

        for (int i = 0; i < dataLength; i++) {
            gammaRate = Integer.parseInt(gammaRateBin, 2);
            epsilonRate = Integer.parseInt(epsilonRateBin, 2);
        }

        answer = gammaRate * epsilonRate;

        System.out.println("Answer: " + answer);

    }
    
}
