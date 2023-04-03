package Homework4;

import java.util.Iterator;

public class IteratorOfPlanner implements Iterator<Task> {

    private int index = -1;
    private final Planner tasks;

    public IteratorOfPlanner(Planner tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean hasNext() {
        return index < tasks.getSize()-1;
    }

    @Override
    public Task next() {
        return tasks.getTask(++index);
    }
}