package Homework4;
import java.util.Scanner;

public class UserActions implements UserActionsImpl {
    private final Scanner scanner;
    private final Planner planner;
    protected static String CSVFile = "/Users/Admin/IdeaProjects/GB_Java_OOP/src/Homework4/Planner.csv";
    protected static String JSONFile = "/Users/Admin/IdeaProjects/GB_Java_OOP/src/Homework4/Planner.json";
    protected static String XMLFile = "/Users/Admin/IdeaProjects/GB_Java_OOP/src/Homework4/Planner.xml";

    public UserActions(Scanner scanner, Planner planner) {
        this.scanner = scanner;
        this.planner = planner;
    }

    @Override
    public void addNewTask() {
        System.out.println("Adding a new Task.\n Enter Task description --> ");
        String descr = scanner.nextLine();

        System.out.println("\nEnter priority: 1 - Low, 2 - Medium, 3 - Immediate implementation --> ");
        String prior = scanner.nextLine();
        int priority = 0;
        if (prior.equals("1") | prior.equals("2") | prior.equals("3"))
            priority = Integer.parseInt(prior);
        else
            System.out.println("Incorrect code, in this case priority by default will be LOW");

        System.out.println("Enter responsible person --> ");
        String responsible = scanner.nextLine();

        System.out.println("Enter deadline date in format \"dd.MM.yyyy\" --> ");
        String deadlineDate = scanner.nextLine();

        System.out.println("Enter deadline time in format \"hh:mm\":");
        String deadlineTime = scanner.nextLine();

        planner.add(new Task(descr, Task.setPriorityCode(priority), responsible, deadlineDate, deadlineTime));
    }

    @Override
    public void showAllTasks() {
        if (planner.getSize() > 0)
            planner.showAll();
        else
            System.out.println("The planner of tasks is empty...");
    }

    @Override
    public void showSortedByPriority(){
        if (planner.getSize() > 0)
            planner.showSortedByPriority();
        else
            System.out.println("The planner of tasks is empty...");
    }

    @Override
    public void deleteTaskByNumber(){
        if (planner.getSize() > 0) {
            System.out.println("Enter the number of Task for deletion --> ");
            int number = Integer.parseInt(scanner.nextLine());
            planner.delete(number);
        } else {
            System.out.println("The planner of tasks is empty....");
        }
    }

    @Override
    public void searchTaskByString(){
        if (planner.getSize() > 0) {
            System.out.println("Enter the word or part of the string of Task for searching --> ");
            String keyword = scanner.nextLine();
            planner.totalSearch(keyword);
        } else {
            System.out.println("The planner of tasks is empty...");
        }
    }

    @Override
    public void exportTasksToCSV(){
        IteratorOfPlanner iteratorOfPlanner = new IteratorOfPlanner(planner);
            while (iteratorOfPlanner.hasNext()) {
                ExportModel<Task> saved = new ExportModel<>(iteratorOfPlanner.next());
                saved.setFormat(new ExportToCSV());
                saved.setPath(CSVFile);
                saved.save();
            }
            System.out.println("Saved to CSV file");
    }
    @Override
    public void exportTasksToJSON(){
        IteratorOfPlanner iteratorOfPlanner = new IteratorOfPlanner(planner);
        while (iteratorOfPlanner.hasNext()) {
            ExportModel<Task> saved = new ExportModel<>(iteratorOfPlanner.next());
            saved.setFormat(new ExportToJSON());
            saved.setPath(JSONFile);
            saved.save();
        }
        System.out.println("Saved to JSON file");
    }
    @Override
    public void exportTasksToXML(){
        IteratorOfPlanner iteratorOfPlanner = new IteratorOfPlanner(planner);
        while (iteratorOfPlanner.hasNext()) {
            ExportModel<Task> saved = new ExportModel<>(iteratorOfPlanner.next());
            saved.setFormat(new ExportToXML());
            saved.setPath(XMLFile);
            saved.save();
        }
        System.out.println("Saved to XML file");
    }
}