package commands;

import entity.Student;
import utils.ConsoleReader;
import utils.FileLoader;

import java.io.Console;
import java.io.File;
import java.util.HashMap;

public class OpenFileCommand extends FileCommand {

    public OpenFileCommand(FileLoader loader, HashMap<String, Student> students) {
        super("openFile", loader, students);
    }
    @Override
    public void execute() {
        loader.setFile(ConsoleReader.readFile());
        loader.readAll(students);
    }

    @Override
    public String option() {
        return "Отрыть файл и прочитать информацию о всех студентах";
    }
}
