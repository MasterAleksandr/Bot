package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var bot = new Bot();
        while(true) {
            var in = new Scanner(System.in);
            var command = in.nextLine();
            var result = bot.processCommand(command);

            if(result.equals("stop")){
                System.out.print("Work is finished");
                break;
            }

            System.out.print(result + "\n");
        }
    }
}
