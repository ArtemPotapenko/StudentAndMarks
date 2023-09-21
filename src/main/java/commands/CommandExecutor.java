package commands;

import utils.ConsoleReader;

import java.io.Console;
import java.util.HashMap;

public class CommandExecutor {
    HashMap<String, Command> map = new HashMap<>();
    Command endCommand;
    Command nextCommand;
    CommandExecutor nextExecutor;
    {
        map.put("help", new Command() {
            @Override
            public String getName() {
                return "help";
            }

            @Override
            public void execute() {
                printHelp();
            }

            @Override
            public String option() {
                return "список команд";
            }

            @Override
            public String toString() {
                return getName()+" "+option();
            }
        });
    }

    public void addCommand(Command command) {
        map.put(command.getName(), command);
    }

    public void addCommand(String key, Command command) {
        map.put(key, command);
    }

    public void choiceEndCommand(String commandName) {
        endCommand = map.get(commandName);
    }

    private void printHelp() {
        System.out.println("Выберете команду:");
        map.values().forEach(System.out::println);
    }
    public void addNextExecutor(String commandName, CommandExecutor nextExecutor){
        nextCommand = map.get(commandName);
        this.nextExecutor = nextExecutor;
    }

    private Command choiceCommand() {
        String name = ConsoleReader.readString();
        while (!map.containsKey(name)) {
            System.out.println("Такой комманды нет, введите еще раз.");
            name = ConsoleReader.readString();
        }
        return map.get(name);
    }
    private void execute(Command command){
        command.execute();
        if (command.equals(nextCommand)){ nextExecutor.start();}
    }

    public void start() {
        printHelp();
        Command command = choiceCommand();
        execute(command);
        while (!command.equals(endCommand)){
            command = choiceCommand();
            execute(command);
        }
    }
}
