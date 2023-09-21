package commands;

public interface Command {
    String getName();
    void execute();
    String option();

}
