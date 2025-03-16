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
        int oxygenRating = 0;
        int co2Rating = 0;
        int dataLength = 0;

        try {
            File data = new File("C:\\SWE\\AdventOfCode\\resources\\2021\\day3_input.txt");
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
            	String line = reader.nextLine();
                dataLength = line.length();
                list.add(line);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
        }

        int[] array = new int[dataLength];

        for (int i = 0; i < dataLength; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).charAt(i) == '1') {
                    array[i]++;
                }
            }
        }

        for (int i = 0; i < dataLength; i++) {
            if (array[i] > (list.size() / 2)) {
                gammaRateBin += "1";
                epsilonRateBin += "0";
            }
            else {
                gammaRateBin += "0";
                epsilonRateBin += "1";
            }
        }

        gammaRate = Integer.parseInt(gammaRateBin, 2);
        epsilonRate = Integer.parseInt(epsilonRateBin, 2);

        answer = gammaRate * epsilonRate;

        System.out.println("Answer: " + answer);

        // Part 2
        ArrayList<String> listOxygen = new ArrayList<String>();
        listOxygen.addAll(list);

        for (int i = 0; i < dataLength; i++) {
            for (int j = 0; j < listOxygen.size(); j++) {
                if (listOxygen.get(j).charAt(i) != gammaRateBin.charAt(i)) {
                    listOxygen.remove(j--);
                }
                if (listOxygen.size() == 1) {
                    break;
                }
            }
            if (listOxygen.size() == 1) {
                break;
            }
            array = new int[dataLength];
            for (int j = 0; j < dataLength; j++) {
                for (int k = 0; k < listOxygen.size(); k++) {
                    if (listOxygen.get(k).charAt(j) == '1') {
                        array[j]++;
                    }
                }
            }
            gammaRateBin = "";
            for (int j = 0; j < dataLength; j++) {
                if (array[j] >= (listOxygen.size() / 2)) {
                    gammaRateBin += "1";
                }
                else {
                    gammaRateBin += "0";
                }
            }
        }

        oxygenRating = Integer.parseInt(listOxygen.get(0), 2);

        ArrayList<String> listCO2 = new ArrayList<String>();
        listCO2.addAll(list);

        for (int i = 0; i < dataLength; i++) {
            for (int j = 0; j < listCO2.size(); j++) {
                if (listCO2.get(j).charAt(i) == gammaRateBin.charAt(i)) {
                    listCO2.remove(j--);
                }
                if (listCO2.size() == 1) {
                    break;
                }
            }
            if (listCO2.size() == 1) {
                break;
            }
            array = new int[dataLength];
            for (int j = 0; j < dataLength; j++) {
                for (int k = 0; k < listCO2.size(); k++) {
                    if (listCO2.get(k).charAt(j) == '1') {
                        array[j]++;
                    }
                }
            }
            gammaRateBin = "";
            for (int j = 0; j < dataLength; j++) {
                if (array[j] > (listCO2.size() / 2)) {
                    gammaRateBin += "1";
                }
                else {
                    gammaRateBin += "0";
                }
            }
        }

        co2Rating = Integer.parseInt(listCO2.get(0), 2);

        answer = oxygenRating * co2Rating;

        System.out.println("Answer: " + answer);

    }
    
}
