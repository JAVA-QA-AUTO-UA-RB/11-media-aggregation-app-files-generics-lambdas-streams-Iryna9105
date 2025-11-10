package com.example.media.classes;

/**
 * Abstract base class for all media types.
 */
public abstract class Media {
    protected String title;
    protected int duration; // in seconds

    public Media(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    // TODO: Implement method that returns duration in minutes + seconds
    // Example: "4 min 30 sec"
    public String getDurationInMinutes() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + " min " + seconds + " sec ";
    }

    @Override
    public String toString() {
        return title + " (" + duration + " sec)";
    }
}
