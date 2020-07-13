package ru.job4j.io.inputoutput;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            Scanner sc = new Scanner(in);
            int read;
            while (sc.hasNext()) {
                read = sc.nextInt();
                if (read % 2 == 0) {
                    System.out.println("Number " + read + " is even.");
                } else {
                    System.out.println("Number " + read + " is odd.");
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
