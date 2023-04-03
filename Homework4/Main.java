package Homework4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planner planner = new Planner();
        planner.add(new Task("Buy a dress for my elder daughter on her Birthday Party", Priority.MEDIUM));
        planner.add(new Task("Take the dress from the Atelier \"Prestige\"", Priority.HIGH, "31.03.2023", "12:00"));

        new MenuSwitchCase(new Scanner(System.in)).startMenu(planner);
    }
}