package com.company;
import java.lang.String;

class Bot{

    private final String Authors = "Daniil Tass, Aleksandr Khrushchev, Semen Rabnushkin";

    private Command[] commands;

    Bot(){

        commands = CommandsStorage.generateCommands();
    }

    String processCommand(String command) {

        var commandArgs = command.split(" ");
        var commandName = command.split(" ")[0];

        if(commandName.equals("help"))
            return processHelp(commandArgs);
        if(commandName.equals("echo"))
            return processEcho(commandArgs);
        if(commandName.equals("authors"))
            return processSimpleCommand(commandArgs, Authors);
        if(commandName.equals("stop"))
            return processSimpleCommand(commandArgs, "stop");

        return "there is no such command use help";
    }

    private String processHelp(String[] commandArgs){

        var result = new StringBuilder();
        if(commandArgs.length == 1) {
            for (Command value : commands)
                result.append(value.name).append("\n");
        }
        else{
            switch (commandArgs[1]){
                case "help":
                    result.append(commands[0].description);
                    break;
                case "echo":
                    result.append(commands[1].description);
                    break;
                case "authors":
                    result.append(commands[2].description);
                    break;
                case "stop":
                    result.append(commands[3].description);
                    break;
                default:
                    result.append("No such command.");
            }
        }

        return result.toString();
    }

    private String processEcho(String[] commandArgs){

        var result = new StringBuilder();

        for(var i = 1; i < commandArgs.length; i++) {
            result.append(commandArgs[i]);
            result.append(" ");
        }

        return result.toString();
    }

    private String processSimpleCommand(String[] commandArgs, String answer){

        if(commandArgs.length > 1)
            return "This command doesn't takes arguments";
        return answer;
    }
}
