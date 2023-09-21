package utils;


import entity.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FileLoader {
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private File file;
    public FileLoader(String fileName) throws IOException {
        this.file = new File(fileName);
    }
    public FileLoader(){

    }

    public void printAll(HashMap<String, Student> students) {
       try (PrintWriter printWriter = new PrintWriter(file);){
           for (Student st : students.values()) {
               printWriter.println(st);
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException();
       }
    }
    public void readAll(HashMap<String, Student> students){
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                Student student = Student.create(scanner.nextLine());
                students.put(student.getName(),student);
            }
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
                System.out.println("Создан новый файл");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

