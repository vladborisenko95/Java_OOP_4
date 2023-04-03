package Homework4;

public class ExportToXML implements ExportFormat{
    @Override
    public <T extends Task> String createString(T task) {
        return String.format("""
                <xml>
                <Task>
                <id>%d</id>
                <Description>%s</Description>
                <Priority>%s</Priority>
                <Creation date>%s</Creation date>
                <Creation time date>%s</Creation time>
                <Responsible>%s</Responsible>
                <Deadline date>%s</Deadline date>
                <Deadline time date>%s</Deadline time>
                </Task></xml>
                """, task.getId(), task.getDescription(), task.getPriority(), task.getCreatedDate(), task.getCreatedTime(), task.getResponsible(), task.getDeadlineDate(),task.getDeadlineTime());
    }
}