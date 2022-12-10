package com.kpi;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final String FIRST_CHOICE = "File (1) or console (2)? (write number)";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String ENTER_STRING = "Enter your string: ";
    private static final String TRY_AGAIN = "Try again";
    private static final String CODING_DISTANCE_CHOICE = "Select the coding distance(3/4): ";

    public static void showMenu() throws IOException {
        System.out.println(FIRST_CHOICE);
        Scanner sc = new Scanner(System.in);
        StringBuilder string;
        while (true) {
            String number = sc.nextLine();
            if(number.equals(TWO)) {
                System.out.print(ENTER_STRING);
                string = new StringBuilder(sc.nextLine());
                break;
            } else if(number.equals(ONE)) {
                string = FileManager.readFileData();
                break;
            } else System.out.println(TRY_AGAIN);
        }
        chooseHD(string);
    }

    private static void chooseHD(StringBuilder string) {
        System.out.println(CODING_DISTANCE_CHOICE);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String number = sc.nextLine();
            if(number.equals(THREE)) {
                System.out.println("Enter place for mistake (if you don't want to place mistake, enter -1)");
                while (true) {
                    HammingCode hammingCode = new HammingCode();
                    byte[] bytes = string.toString().getBytes();
                    StringBuilder binaryCode = HammingCode.convertByteArraysToBinary(bytes);
                    System.out.println(binaryCode.length());
                    int place = sc.nextInt();
                    if((place != -1 && place < 1) || place > binaryCode.length()) {
                        System.out.println(TRY_AGAIN);
                        continue;
                    }
                    System.out.println("Binary code: " + binaryCode);
                    binaryCode = hammingCode.insertBits(binaryCode);
                    StringBuilder bits = hammingCode.findBits(binaryCode);
                    binaryCode = hammingCode.setBits(binaryCode, bits);
                    HammingCode.doCodingDistanceThree(binaryCode, place, hammingCode);
                    break;
                }
                break;

            } else if(number.equals(FOUR)) {

            } else System.out.println(TRY_AGAIN);
        }


    }
}
