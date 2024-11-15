package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<String[]> readFile(String filename){
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader= new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine())!=null){
                data.add(line.split(","));

            }
        } catch (IOException e) {
            System.out.println("Error Reading File: "+e.getMessage());
        }
        return data;

    }

    public void writeFile(String filename, String data){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(filename,true))) {
            writer.write(data);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error Writing file"+ e.getMessage());
        }
    }
}
