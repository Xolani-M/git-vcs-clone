package org.myproject;

public class Main {
    public static void main(String[] args) {
        System.err.println("Program logs: ");

        if (args.length < 1) {
            System.out.println("Usage: <command> <args>");
            return;
        }

        final String command = args[0];

        switch (command){
            case "init" -> RepoInitializer.initGitRepo();
            // Add other cases for other commands if needed
            default -> System.out.println("Unknown command");
        }
    }
}
