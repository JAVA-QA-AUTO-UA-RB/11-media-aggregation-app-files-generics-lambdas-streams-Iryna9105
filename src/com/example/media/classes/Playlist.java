package com.example.media.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic playlist class.
 */
public class Playlist<T extends Media> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    // TODO: Implement method to calculate total duration
    public int getTotalDuration() {
        return items.stream()
                .mapToInt(Media::getDuration)
                .sum();

    }

    // TODO: Implement method to print all items
    public void printAll() {
        items.forEach(System.out::println);
    }
}
