package commands;

import entity.Student;
import utils.FileLoader;

import java.util.HashMap;

public class CloseFileCommand extends FileCommand{

    public CloseFileCommand( FileLoader loader, HashMap<String, Student> students) {
        super("closeFile", loader, students);
    }

    @Override
    public void execute() {
        loader.printAll(students);
        students.clear();
    }

    @Override
    public String option() {
        return "Закрыть файл и сохранить";
    }
}
