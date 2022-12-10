package com.kpi;

import org.apache.log4j.Logger;

import java.io.IOException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Menu.showMenu();
        } catch (IOException e) {
            LOGGER.error("FileReader works incorrect");
        }
        /*String s = "Бабій Олена Олексіївна";
        HammingCode hammingCode = new HammingCode();
        byte[] bytes = s.getBytes();

        StringBuilder binaryCode = HammingCode.convertByteArraysToBinary(bytes);
        System.out.println("Binary code: " + binaryCode);

        binaryCode = hammingCode.insertBits(binaryCode);
        StringBuilder bits = hammingCode.findBits(binaryCode);
        binaryCode = hammingCode.setBits(binaryCode, bits);

        Character c = hammingCode.countXOR(binaryCode);
        binaryCode.insert(0, c);
        System.out.println("Hamming Code: " + binaryCode);

        //binaryCode = hammingCode.reverseValue(binaryCode, 0);
        //binaryCode = hammingCode.reverseValue(binaryCode, 4);
        binaryCode = hammingCode.reverseValue(binaryCode, 20);

        System.out.println("Message with mistakes: " + binaryCode);

        c = hammingCode.countXOR(binaryCode);
        binaryCode.deleteCharAt(0);
        bits = hammingCode.findBits(binaryCode);

        char mistake = hammingCode.checkMistake(bits);

        if(c == '0' && mistake == '0') {
            System.out.println("No mistakes");
            binaryCode = hammingCode.deleteBits(binaryCode);
            System.out.println("Decoded message: " + binaryCode);
        }
        else if (c == '0' && mistake == '1')
            System.out.println("There are two mistakes");
        else if(c == '1' && mistake == '1') {
            System.out.println("There is one mistake");
            binaryCode = hammingCode.removeMistake(bits, binaryCode);
            System.out.println("Hamming Code (mistake is removed): " + binaryCode);
            binaryCode = hammingCode.deleteBits(binaryCode);
            System.out.println("Decoded message: " + binaryCode);
        }*/
    }
}
