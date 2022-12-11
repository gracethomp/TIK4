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
    }
}
