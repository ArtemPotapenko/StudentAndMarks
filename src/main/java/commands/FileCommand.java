package commands;

import entity.Student;
import utils.FileLoader;

import java.util.HashMap;

public abstract class FileCommand implements Command{
    String name;

    @Override
    public String toString() {
        return getName()+"  "+option();
    }

    @Override
    public String getName() {
        return name;
    }

    FileLoader loader;
    HashMap<String, Student> students;

    public FileCommand(String name, FileLoader loader, HashMap<String, Student> students) {
        this.name = name;
        this.loader = loader;
        this.students = students;
    }

}
