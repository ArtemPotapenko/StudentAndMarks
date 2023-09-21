package commands;

import entity.Student;
import utils.ConsoleReader;

import java.util.HashMap;

public class AddMarkCommand extends StudentCommand{
    public AddMarkCommand(HashMap<String, Student> students) {
        super("addMark", students);
    }

    @Override
    public void execute() {
        ConsoleReader.getStudentFromMap(students).addMarks(ConsoleReader.readMark());
    }

    @Override
    public String option() {
        return "Добавить оценку ученику";
    }
}
