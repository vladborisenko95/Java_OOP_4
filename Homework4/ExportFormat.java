package Homework4;

public interface ExportFormat {
    <T extends Task> String createString(T task);
}