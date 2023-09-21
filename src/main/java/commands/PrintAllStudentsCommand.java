package commands;

import entity.Student;

import java.util.HashMap;

public class PrintAllStudentsCommand extends StudentCommand{
    public PrintAllStudentsCommand(HashMap<String, Student> students) {
        super("printAllStudents", students);
    }

    @Override
    public void execute() {

        if (students.size()!=0){students.values().forEach(System.out::println);}
        else System.out.println("Нет уяеников");
    }

    @Override
    public String option() {
        return "Вывести информацию о свех учениках";
    }
}
