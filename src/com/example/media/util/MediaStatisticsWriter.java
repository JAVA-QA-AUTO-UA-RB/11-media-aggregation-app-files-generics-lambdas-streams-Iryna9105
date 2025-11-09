package com.example.media.util;

import com.example.media.classes.Playlist;
import com.example.media.classes.Track;
import com.example.media.classes.Video;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MediaStatisticsWriter {


    public static void writeTrackStats(Playlist<Track> playlist, String filename) throws IOException {

        // TODO: Реалізуйте цей метод

        List<Track> tracks = playlist.getItems();
        if (tracks.isEmpty()) {
            Files.write(Paths.get(filename), "No tracks available.".getBytes());
            return;
        }
        int count = tracks.size();
        double avgDuration = tracks.stream()
                .mapToInt(Track::getDuration)
                .average()
                .orElse(0);

        List<Track> top3 = tracks.stream()
                .sorted(Comparator.comparingInt(Track::getRating).reversed()
                        .thenComparing(Track::getDuration, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());

        List<Track> popTracks = tracks.stream()
                .filter(t -> t.getGenre().equalsIgnoreCase("Pop"))
                .collect(Collectors.toList());

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(filename)))) {
            writer.println("Tracks count: " + count);
            writer.println();
            writer.printf("Average duration: %.2f seconds", avgDuration);
            writer.println();
            writer.println("Top 3 tracks by rating: ");
            for (int i = 0; i < top3.size(); i++) {
                Track t = top3.get(i);
                writer.printf("%d. %s (rating %d)%n", i + 1, t.getTitle(), t.getRating());
            }
            writer.println();
            writer.println("Pop tracks:");
            for (Track t : popTracks) {
                writer.println("- " + t.getTitle());
            }
        }

    }

    public static void writeVideoStats(Playlist<Video> playlist, String filename) throws IOException {
        List<Video> videos = playlist.getItems();
        if (videos.isEmpty()){
            Files.write(Paths.get(filename), "No videos available.".getBytes());
            return;
        }
        int count = videos.size();

        double avgDuration = videos.stream()
                .mapToInt(Video::getDuration)
                .average()
                .orElse(0);

        List <Video> top3 = videos.stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<Video> educationVideos = videos.stream()
                .filter(v -> v.getCategory().equalsIgnoreCase("Education"))
                .collect(Collectors.toList());

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(filename)))){
            writer.println("Videos count: " + count);
            writer.println("Average duration: " + String.format("%.2f", avgDuration) + " seconds");
            writer.println();
            writer.println("Top 3 videos by views:");
            for (int i=0; i < top3.size(); i++){
                Video v = top3.get(i);
                writer.println((i + 1) + ". " + v.getTitle() + " (rating " + v.getViews() + ")");
            }
            writer.println();
            writer.printf("Education videos:");
            for (Video v : educationVideos){
                writer.println("-" + v.getTitle());
            }
        }
    }
}
