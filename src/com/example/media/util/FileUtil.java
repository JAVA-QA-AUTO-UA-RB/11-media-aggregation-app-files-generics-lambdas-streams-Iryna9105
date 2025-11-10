package com.example.media.util;

import com.example.media.classes.Track;
import com.example.media.classes.Video;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас-утиліта для зчитування вхідних файлів з даними.
 *
 * Файли:
 * - tracks.txt (список музичних треків)
 * - videos.txt (список відео)
 *
 * Завдання студентів:
 * Реалізувати методи readTracks(...) та readVideos(...),
 * які відкривають відповідні .txt файли, читають їх рядок за рядком
 * і перетворюють кожен рядок у об'єкт Track або Video.
 *
 * Використайте:
 * - java.nio.file.Files
 * - java.nio.file.Paths
 * - метод Files.readAllLines(...)
 * або Files.lines(...) для роботи зі Stream API.
 */
public class FileUtil {

    /**
     * Зчитує список треків із файлу.
     * <p>
     * Формат вхідного файлу tracks.txt:
     * ---------------------------------
     * Title;Artist;Genre;Duration;Rating
     * Shape of You;Ed Sheeran;Pop;240;9
     * Smells Like Teen Spirit;Nirvana;Rock;301;10
     * ...
     * <p>
     * Пояснення полів:
     * - Title (String)    → назва треку
     * - Artist (String)   → виконавець
     * - Genre (String)    → жанр (Pop, Rock, Electronic, HipHop)
     * - Duration (int)    → тривалість у секундах
     * - Rating (int)      → рейтинг від 1 до 10
     * <p>
     * TODO: Реалізувати:
     * - Пропустити перший рядок (заголовки колонок)
     * - Розбити кожен рядок по символу ";"
     * - Створити об'єкт Track з цих даних
     * - Додати його у список
     */
    public static List<Track> readTracks(String filename) throws IOException {
        List<Track> tracks = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(";");
            if (parts.length != 5) continue;


            String title = parts[0];
            String artist = parts[1];
            String genre = parts[2];
            int duration = Integer.parseInt(parts[3]);
            int rating = Integer.parseInt(parts[4]);

            Track track = new Track(title, artist, genre, duration, rating);
            tracks.add(track);
        }
        return tracks;
    }

    // TODO: зчитати рядки з файлу
    // TODO: пропустити перший рядок (headers)
    // TODO: для кожного рядка розбити його на частини (split(";"))
    // TODO: створити новий Track(...) і додати у список


    /**
     * Зчитує список відео із файлу.
     * <p>
     * Формат вхідного файлу videos.txt:
     * ---------------------------------
     * Title;Channel;Category;Duration;Views
     * Top 10 Java Tips;CodeAcademy;Education;600;25000
     * Funny Cats Compilation;AnimalFun;Entertainment;420;1000000
     * ...
     * <p>
     * Пояснення полів:
     * - Title (String)     → назва відео
     * - Channel (String)   → канал, який виклав відео
     * - Category (String)  → категорія (Education, Entertainment, Sports, Food)
     * - Duration (int)     → тривалість у секундах
     * - Views (int)        → кількість переглядів
     * <p>
     * TODO: Реалізувати:
     * - Пропустити перший рядок (заголовки колонок)
     * - Розбити кожен рядок по символу ";"
     * - Створити об'єкт Video з цих даних
     * - Додати його у список
     */
    public static List<Video> readVideos(String filename) throws IOException {
        List<Video> videos = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(";");
            if (parts.length != 5) continue;

            String title = parts[0];
            String channel = parts[1];
            String category = parts[2];
            int duration = Integer.parseInt(parts[3]);
            int views = Integer.parseInt(parts[4]);

            videos.add(new Video(title, channel, category, duration, views));
        }
        return videos;
    }

}

        // TODO: зчитати рядки з файлу
        // TODO: пропустити перший рядок (headers)
        // TODO: для кожного рядка розбити його на частини (split(";"))
        // TODO: створити новий Video(...) і додати у список


