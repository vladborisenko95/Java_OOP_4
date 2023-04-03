package Homework4;

public class ExportToJSON implements ExportFormat {
    @Override
    public <T extends Task> String createString(T task) {
        return String.format("""
                {
                "id" : %d, {
                "Description":%s,
                "Priority":"%s",
                "Creation date":"%s"
                "Creation time":"%s"
                "Responsible person":"%s"
                "Deadline date":"%s"
                "Deadline time":"%s"
                }
                }
                """, task.getId(), task.getDescription(), task.getPriority(), task.getCreatedDate(), task.getCreatedTime(), task.getResponsible(), task.getDeadlineDate(),task.getDeadlineTime());
    }
}