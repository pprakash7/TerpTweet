package com.example.cmsc436.exampletabs;

/**
 * Created by Katherine Larson on 4/26/2016.
 */
public class CalendarEvent {
    String title;
    String link;
    String description;

    public CalendarEvent(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
