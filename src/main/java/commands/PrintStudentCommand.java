package commands;

import entity.Student;
import utils.ConsoleReader;

import java.util.HashMap;

public class PrintStudentCommand extends StudentCommand{

    public PrintStudentCommand(HashMap<String, Student> students) {
        super("printStudent", students);
    }

    @Override
    public void execute() {
        System.out.println(ConsoleReader.getStudentFromMap(students).getMarks());
    }

    @Override
    public String option() {
        return "Вывести оценки ученика";
    }
}
