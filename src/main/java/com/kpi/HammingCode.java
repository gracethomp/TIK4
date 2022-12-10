package com.kpi;

public class HammingCode {
    private int lastBit;

    public static StringBuilder convertByteArraysToBinary(byte[] bytes) {
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary;
    }

    public StringBuilder reverseValue(StringBuilder code, int place) {
        if(code.charAt(place) == '0')
            code.setCharAt(place, '1');
        else if(code.charAt(place) == '1')
            code.setCharAt(place, '0');
        return code;
    }

    public StringBuilder insertBits(StringBuilder code) {
        int number = 1;
        for (int i = 0; i < code.length(); i++){
            if(i == number - 1) {
                code.insert(i, "0");
                number *= 2;
            }
        }
        lastBit = number/2;
        return code;
    }
    public StringBuilder deleteBits(StringBuilder string) {
        while (lastBit != 0) {
            string.deleteCharAt(lastBit - 1);
            lastBit = lastBit/2;
        }
        return string;
    }
    public Character countXOR(StringBuilder stringBuilder) {
        char c = stringBuilder.charAt(0);
        int q = 1;
        while (q < stringBuilder.length()){
            if(c == stringBuilder.charAt(q))
                c = '0';
            else
                c = '1';
            q++;
        }
        return c;
    }

    public StringBuilder findBits(StringBuilder binaryCode){
        int i;
        int number = 1;
        char c;
        StringBuilder bits = new StringBuilder();
        StringBuilder xor;
        while (number < binaryCode.length()) {
            xor = new StringBuilder();
            for (i = number - 1; i < binaryCode.length(); i += number*2){
                for (int j = 0; j < number && i + j < binaryCode.length(); j++) {
                    c = binaryCode.charAt(i+j);
                    xor.append(c);
                }
            }
            bits.append(countXOR(xor));
            number *= 2;
        }
        return bits;
    }
    public StringBuilder setBits(StringBuilder stringBuilder, StringBuilder bits) {
        int number = 1, i = 0;
        while (i < bits.length()) {
            stringBuilder.setCharAt(number - 1, bits.charAt(i));
            number *= 2;
            i++;
        }
        return stringBuilder;
    }

    public StringBuilder removeMistake(StringBuilder bits, StringBuilder code) {
        int i = 0, index = 0;
        while (i < bits.length()) {
            if(bits.charAt(i) == '1') {
                index = (int) (index + Math.pow(2, i));
            }
            i++;
        }
        System.out.println(index);
        code = reverseValue(code, index - 1);
        return code;
    }
}
