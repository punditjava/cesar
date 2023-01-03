package com.company;

import java.io.*;
import java.util.ArrayList;

import static com.company.Cesar.*;

public class Main {
    private static int k;

    public static void main(String[] args) throws IOException {

        k = Integer.parseInt(args[3]);
        String mode = args[0];
        if (!(mode.equals("-e") || mode.equals("-d"))) return;
        File file = new File(args[1]);
        System.out.println(file);
        if (mode.equals("-e")) {
            try ( FileReader read = new FileReader(file);
                  BufferedReader reader = new BufferedReader(read);
                  FileWriter fileWriter = new FileWriter(args[2])) {
                String line = reader.readLine();
                while (line != null) {
                    StringBuffer buffer = new StringBuffer(line);
                    String s = CesarEn(buffer);
                    fileWriter.write(s);
                    fileWriter.write("\n");
                    line = reader.readLine();
                }
            }
        } else {
            try ( FileReader read = new FileReader(file);
                  BufferedReader reader = new BufferedReader(read);
                  FileWriter fileWriter = new FileWriter(args[2])) {
                String line = reader.readLine();
                while (line != null) {
                    StringBuffer buffer = new StringBuffer(line);
                    String s = CesarDec(buffer);
                    fileWriter.write(s);
                    fileWriter.write("\n");
                    line = reader.readLine();
                }
            }
        }
    }
    static String CesarEn(StringBuffer sb) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (isEnglish(c)) {
                int y = (findInEnglish(c) + k) % nEng;

                if (Character.isUpperCase(c)) {
                    output.append(engslish[y]);
                } else {
                    output.append(Character.toLowerCase(engslish[y]));
                }

                continue;
            }

            if (isRussian(c)) {
                int y = (findInRussian(c) + k) % nRus;

                if (Character.isUpperCase(c)) {
                    output.append(russian[y]);
                } else {
                    output.append(Character.toLowerCase(russian[y]));
                }

                continue;
            }

            if (!isEnglish(c) && !isRussian(c)) {
                output.append(c);
            }
        }
        return output.toString();
    }
    static String CesarDec(StringBuffer sb) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (isEnglish(c)) {
                int y = (findInEnglish(c) - k + nEng) % nEng;

                if (Character.isUpperCase(c)) {
                    output.append(engslish[y]);
                } else {
                    output.append(Character.toLowerCase(engslish[y]));
                }

                continue;
            }

            if (isRussian(c)) {
                int y = (findInRussian(c) - k + nEng) % nRus;

                if (Character.isUpperCase(c)) {
                    output.append(russian[y]);
                } else {
                    output.append(Character.toLowerCase(russian[y]));
                }

                continue;
            }

            if (!isEnglish(c) && !isRussian(c)) {
                output.append(c);
            }
        }
        return output.toString();
    }
}
