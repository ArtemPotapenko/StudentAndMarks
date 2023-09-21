package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private List<Character> marks = new ArrayList<Character>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMarks(Character mark) {
        marks.add(mark);
    }

    public void deleteMarks() {
        marks.clear();
    }

    public List<Character> getMarks() {
        return new ArrayList<Character>(marks);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character mark : marks) {
            stringBuilder.append(mark).append(" ");
        }
        if (stringBuilder.length()==0){
            return name +" : нет оценок";
        }
        return name + " : " + stringBuilder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static Student create(String studentNameAndMarks) {
        String[] strings = studentNameAndMarks.split(" : ");
        String studentName = strings[0];
        Student student = new Student(studentName);
        for (Character mark : strings[1].trim().toCharArray()) {
            if (mark != ' ') {
                student.addMarks(mark);
            }
        }
        return student;
    }
}

