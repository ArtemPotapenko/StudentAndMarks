package utils;

import entity.Student;

import java.io.Console;
import java.io.File;
import java.util.*;

public class ConsoleReader {
    private static final Scanner in = new Scanner(System.in);
    private static final HashSet<String> allMarks = new HashSet<>(List.of("A","B","C","D","E","F"));
    public static Student readStudent(){
        System.out.println("Введите имя студента:");
        return new Student(in.nextLine().trim());
    }
    public static Student getStudentFromMap(HashMap<String,Student> students) {
        System.out.println("Введите имя студента:");
        String studentName = in.nextLine().trim();
        while (!students.containsKey(studentName)) {
            System.out.println("Такого имени нет в списке студентов.");
            studentName = in.nextLine().trim();
        }
        return students.get(studentName);
    }
    public static char readMark(){
        System.out.println("Введите оценку A-F:");
        String mark =  in.next().trim();
        while (!allMarks.contains(mark)){
            System.out.println("Оценка должна быть от A до F");
            mark = in.nextLine().trim();
        }
        return mark.charAt(0);
    }
    public static String readString(){
        return in.nextLine().trim();
    }
    public static File readFile(){
        System.out.println("Введите имя файла.");
        return new File(in.nextLine().trim());
    }
}
