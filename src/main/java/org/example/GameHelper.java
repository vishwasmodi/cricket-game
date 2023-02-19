package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    public Integer randomResultGenerator() {
        int run = (int) (Math.random() * 8);
        return run;
    }

    public Integer randomSkillGenerator() {
        int skill = (int) (Math.random() * 11);
        return skill;
    }

    public Integer randomTossGenerator() {
        return ((int) Math.random() % 2 + 1);
    }
}
