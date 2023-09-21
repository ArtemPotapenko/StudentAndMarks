package commands;

import entity.Student;
import utils.ConsoleReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AddStudentCommand extends StudentCommand {

    public AddStudentCommand( HashMap<String,Student> students) {
        super("addStudent", students);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        Student student = ConsoleReader.readStudent();
        students.put(student.getName(),student);
    }

    @Override
    public String option() {
        return "Добавить нового ученика";
    }
}
