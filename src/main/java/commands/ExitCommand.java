package commands;

public class ExitCommand implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String option() {
        return "Закрыть программу.";
    }
    @Override
    public String toString() {
        return getName()+"  "+option();
    }
}
