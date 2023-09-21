package commands;

import entity.Student;

import java.util.HashMap;
import java.util.HashSet;

public abstract class StudentCommand implements Command {
    protected final String name;
    protected HashMap<String,Student> students;

    @Override
    public String toString() {
        return getName()+"  "+option();
    }
    protected StudentCommand(String name, HashMap<String,Student> students) {
        this.name = name;
        this.students = students;
    }

    @Override
    public String getName() {
        return name;
    }
}
