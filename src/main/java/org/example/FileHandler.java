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

    public void updateFile(String filename, List<String[]> updatedData){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(filename))) {
            for (String[] row : updatedData){
                writer.write(String.join(",",row));
                writer.newLine(); // Add a new line after each record
            }
            System.out.println("File updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating file: "+ e.getMessage());
        }
    }

    public void renameFile(String oldName, String newName){
        File oldFile= new File(oldName);
        File newFile = new File(newName);
        if(oldFile.renameTo(newFile)){
            System.out.println("File renamed successfully! ");
        }
        else{
            System.out.println("Renaming failed");
        }
    }
}