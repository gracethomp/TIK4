package com.kpi;

public class Main {

    public static void main(String[] args) {
        HammingCode hammingCode = new HammingCode();
        String s = "a h";
        byte[] bytes = s.getBytes();

        StringBuilder binaryCode = HammingCode.convertByteArraysToBinary(bytes);
        System.out.println("Binary code: " + binaryCode);

        binaryCode = hammingCode.insertBits(binaryCode);
        StringBuilder bits = hammingCode.findBits(binaryCode);
        System.out.println(bits);
        binaryCode = hammingCode.setBits(binaryCode, bits);
        System.out.println("Hamming Code: " + binaryCode);

        int place = 1;
        binaryCode = hammingCode.reverseValue(binaryCode, place - 1);
        bits = hammingCode.findBits(binaryCode);
        binaryCode = hammingCode.removeMistake(bits, binaryCode);
        System.out.println("Hamming Code (mistake is removed): " + binaryCode);
        binaryCode = hammingCode.deleteBits(binaryCode);
        System.out.println("Decoded message: " + binaryCode);
    }
}
