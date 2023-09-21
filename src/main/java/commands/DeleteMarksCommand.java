package commands;

import entity.Student;
import utils.ConsoleReader;

import java.util.HashMap;

public class DeleteMarksCommand extends StudentCommand{
    public DeleteMarksCommand(HashMap<String,Student> students) {
        super("deleteMarks", students);
    }

    @Override
    public void execute() {
        ConsoleReader.getStudentFromMap(students).deleteMarks();
    }

    @Override
    public String option() {
        return "Удалить все оценки";
    }
}
