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
        Scanner sc = new Scanner(System.in);
        HammingCode hammingCode = new HammingCode();
        byte[] bytes = string.toString().getBytes();
        StringBuilder binaryCode = HammingCode.convertByteArraysToBinary(bytes);
        System.out.println("Binary code: " + binaryCode);
        System.out.println(CODING_DISTANCE_CHOICE);
        while (true) {
            String number = sc.nextLine();
            if(number.equals(THREE)) {
                System.out.println("Enter place for mistake (if you don't want to place mistake, enter -1)");
                doEncodeThreeHD(binaryCode, hammingCode);
                break;
            } else if(number.equals(FOUR)) {
                doEncodeFourHD(binaryCode, hammingCode);
                break;
            } else System.out.println(TRY_AGAIN);
        }
    }

    public static void doEncodeThreeHD(StringBuilder binaryCode, HammingCode hammingCode) {
        Scanner sc = new Scanner(System.in);
        binaryCode = hammingCode.insertBits(binaryCode);
        StringBuilder bits = hammingCode.findBits(binaryCode);
        binaryCode = hammingCode.setBits(binaryCode, bits);
        while (true) {
            System.out.println("Max value that can be entered: " + binaryCode.length());
            int place = sc.nextInt();
            if((place != -1 && place < 1) || place > binaryCode.length()) {
                System.out.println(TRY_AGAIN);
                continue;
            }
            HammingCode.doEncodeDecodeDistanceThree(binaryCode, place, hammingCode);
            break;
        }
    }

    public static void doEncodeFourHD(StringBuilder binaryCode, HammingCode hammingCode) {
        boolean value = false;
        Scanner sc = new Scanner(System.in);
        binaryCode = hammingCode.insertBits(binaryCode);
        StringBuilder bits = hammingCode.findBits(binaryCode);
        binaryCode = hammingCode.setBits(binaryCode, bits);
        Character c = hammingCode.countXOR(binaryCode);
        binaryCode.insert(0, c);
        System.out.println("Hamming Code: " + binaryCode);
        System.out.println("Enter place for mistake (if you don't want to place mistake, enter -1)");
        System.out.println("Max value that can be entered: " + binaryCode.length());
        int i = 1;
        while (i < 3) {
            int place = sc.nextInt();
            if((place != -1 && place < 1) || place > binaryCode.length()) {
                System.out.println(TRY_AGAIN);
                continue;
            }
            if(place == -1)
                break;
            value = true;
            binaryCode = hammingCode.reverseValue(binaryCode, place - 1);
            i++;
        }
        if(value)
            System.out.println("Message with mistakes: " + binaryCode);
        HammingCode.doCodingDistanceFour(binaryCode, hammingCode);
    }
}
