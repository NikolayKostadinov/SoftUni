package com.manhattan.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ProjectModel {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ProjectModel(String name, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        stringBuilder.append("Project name: ").append(this.name).append(System.lineSeparator());
        stringBuilder.append("\tProject Description: ")
                .append(this.description).append(System.lineSeparator());
        stringBuilder.append("\tProject Start Date: ")
                .append(this.startDate == null ? "null" : this.startDate.format(formatter)).append(System.lineSeparator());
        stringBuilder.append("\tProject End Date: ")
                .append(this.endDate == null ? "null" :this.endDate.format(formatter));

        return stringBuilder.toString();
    }
}
