package com.kpi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileManager {
    private static final String FILE = "src/main/resources/text.txt";

    public static StringBuilder readFileData() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        FileReader fileReader = new FileReader(FILE);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine())
            result.append(scanner.nextLine());
        return result;
    }
}
