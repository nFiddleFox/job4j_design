package ru.job4j.io.inputoutput;

public class FileOutStream {
        public static void main(String[] args) {
            String name = "Vasia";
            String secondName = "Petrov";
            String user = name + " " + secondName;
            try (java.io.FileOutputStream out = new java.io.FileOutputStream("result.txt")) {
                out.write(user.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
