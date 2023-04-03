package Homework4;

import java.util.Scanner;

public class MenuSwitchCase {
    private final Scanner scanner;

    public MenuSwitchCase(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("1 - Add new task");
        System.out.println("2 - Show all tasks");
        System.out.println("3 - Sort tasks by priority");
        System.out.println("4 - Delete task by number");
        System.out.println("5 - Search task by any string");
        System.out.println("6 - Export to CSV file");
        System.out.println("7 - Export to JSON file");
        System.out.println("8 - Export to XML file");
        System.out.println("9 - Quit");
    }

    public void startMenu(Planner planner) {
        if (this.scanner != null) {
            String option;
            UserActions actions = new UserActions(scanner, planner);
            do {
                printMenu();
                System.out.print("Please, enter a number of the operation:\n");
                option = this.scanner.nextLine();
                switch (option) {
                    case "1":
                        System.out.println("Adding a new task:");
                        actions.addNewTask();
                        break;
                    case "2":
                        System.out.println("Showing all tasks:");
                        actions.showAllTasks();
                        break;
                    case "3":
                        System.out.println("Sorting the tasks by priority:");
                        actions.showSortedByPriority();
                        break;
                    case "4":
                        System.out.println("Deleting a task by number:");
                        actions.deleteTaskByNumber();
                        break;
                    case "5":
                        System.out.println("Searching a task by string:");
                        actions.searchTaskByString();
                        break;
                    case "6":
                        System.out.println("Exporting to CSV:");
                        actions.exportTasksToCSV();
                        break;
                    case "7":
                        System.out.println("Exporting to JSON:");
                        actions.exportTasksToJSON();
                        break;
                    case "8":
                        System.out.println("Exporting to XML:");
                        actions.exportTasksToXML();
                        break;
                    case "9":
                        System.out.println("Shutting down the program...");
                        break;
                    default:
                        System.out.println("You've entered incorrect menu number...\n");
                }
            } while (!option.equals("9"));
        }
    }
}