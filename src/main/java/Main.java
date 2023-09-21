import commands.*;
import entity.Student;
import utils.FileLoader;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        FileLoader loader =new FileLoader();
        HashMap<String, Student> students = new HashMap<>();
        CommandExecutor startExecutor = new CommandExecutor();
        Command exitCommand = new ExitCommand();
        startExecutor.addCommand(exitCommand);
        Command openFileCommand =new OpenFileCommand(loader,students);
        startExecutor.addCommand(openFileCommand);
        CommandExecutor mainExecutor = new CommandExecutor();
        mainExecutor.addCommand(new PrintStudentCommand(students));
        mainExecutor.addCommand(new PrintAllStudentsCommand(students));
        mainExecutor.addCommand(new AddStudentCommand(students));
        mainExecutor.addCommand(new AddMarkCommand(students));
        mainExecutor.addCommand(new DeleteMarksCommand(students));
        Command closeFileCommand = new CloseFileCommand(loader,students);
        mainExecutor.addCommand(closeFileCommand);
        startExecutor.addNextExecutor(openFileCommand.getName(),mainExecutor);
        startExecutor.choiceEndCommand(exitCommand.getName());
        mainExecutor.choiceEndCommand(closeFileCommand.getName());
        startExecutor.start();
    }
}
