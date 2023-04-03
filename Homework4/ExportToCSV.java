package Homework4;

public class ExportToCSV implements ExportFormat{
    @Override
    public <T extends Task> String createString(T task) {
        return String.format("%d|%s|%s|%s|%s|%s|%s|%s\n",task.getId(), task.getDescription(), task.getPriority(), task.getCreatedDate(), task.getCreatedTime(), task.getResponsible(), task.getDeadlineDate(),task.getDeadlineTime());
    }
}