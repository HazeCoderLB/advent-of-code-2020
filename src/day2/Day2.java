package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {

        int dataLines = 1000;

        String[] inputs = new String[dataLines];

        // Get inputs from data.txt
        try {
            File myFile = new File("src\\day2\\data.txt");
            Scanner myReader = new Scanner(myFile);
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int[] minValues = new int[dataLines];
        int[] maxValues = new int[dataLines];
        char[] chars = new char[dataLines];
        String[] passwords = new String[dataLines];

        // Get minValues, maxValues, chars and passwords in order
        for (int i = 0; i < inputs.length; i++) {
            String[] splitAtColon = inputs[i].split(":");
            minValues[i] = Integer.valueOf(splitAtColon[0].split("-")[0].trim());
            maxValues[i] = Integer.valueOf(splitAtColon[0].split("-")[1].split(" ")[0]);
            chars[i] = splitAtColon[0].split("-")[1].split(" ")[1].trim().charAt(0);
            passwords[i] = splitAtColon[1].trim();
        }

        // Check passwords
        int validPasswords1 = 0;
        for (int i = 0; i < inputs.length; i++) {
            char[] password = passwords[i].toCharArray();
            int matchingChars = 0;
            for (char c : password) {
                if (c == chars[i]) {
                    matchingChars++;
                }
            }
            if (matchingChars >= minValues[i] && matchingChars <= maxValues[i]) {
                validPasswords1++;
            }
        }
        System.out.println("Part 1 - Valid Passwords: " + validPasswords1);

        // Part 2

        // Check passwords
        int validPasswords2 = 0;
        for (int i = 0; i < inputs.length; i++) {
            char[] password = passwords[i].toCharArray();
            int matchingChars = 0;
            if (password.length >= minValues[i]) {
                if (chars[i] == password[minValues[i]-1]) matchingChars++;
            }
            if (password.length >= maxValues[i]) {
                if (chars[i] == password[maxValues[i]-1]) matchingChars++;
            }
            if (matchingChars == 1) validPasswords2++;
        }
        System.out.println("Part 2 - Valid passwords: " + validPasswords2);

    }

}
