package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<String[]> readFile(String filename) {
        List<String[]> data = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File does not exist: " + filename);
            return data;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        }
        return data;
    }


    public void writeFile(String filename, String data, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error Writing File: " + e.getMessage());
        }
    }
}
