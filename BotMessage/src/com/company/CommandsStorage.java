package com.company;

class CommandsStorage {

    static Command[] generateCommands(){

        Command[] commands = new Command[4];

        commands[0] = new Command("help", "show information about bot commands");
        commands[1] = new Command("echo", "print argument");
        commands[2] = new Command("authors", "print author names");
        commands[3] = new Command("stop", "finish work with bot");
        return commands;
    }
}
