package com.challenge.song_registry.main;

import com.challenge.song_registry.model.Singer;
import com.challenge.song_registry.model.SingerData;
import com.challenge.song_registry.model.Song;
import com.challenge.song_registry.model.SongData;
import com.challenge.song_registry.repository.SingerRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner sn = new Scanner(System.in);
    private SingerRepository repository;
    
    public Main(SingerRepository repository) {
        this.repository = repository;
    }
    public void showMenu() {
        int option = -1;
        while (option != 0) {
            String menu = """
                    1 - Register a new singer
                    2 - Show singers
                    3 - Register a new song
                    4 - Search songs by singer
                    
                    0 - Exit
                    """;
            System.out.println(menu);
            option = sn.nextInt();
            sn.nextLine();
            
            switch (option) {
                case 1 -> registerSinger();
                case 2 -> showSingers();
                case 3 -> registerSong();
                case 4 -> searchSongsBySinger();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void searchSongsBySinger() {
        showSingers();
        System.out.println("Enter the singer's name:");
        String singerName = sn.nextLine();
        List<Singer> singers = repository.findByNameContainsIgnoreCase(singerName);
        if (singers.isEmpty()) {
            System.out.println("Singer not found");
            return;
        }

        singers.get(0).getSongs().forEach(System.out::println);
    }

    private void registerSong() {
        showSingers();
        System.out.println("Enter the singer's name:");
        String singerName = sn.nextLine();
        List<Singer> singers = repository.findByNameContainsIgnoreCase(singerName);
        if (singers.isEmpty()) {
            System.out.println("Singer not found");
            return;
        }

        System.out.println("Enter the song's name:");
        String name = sn.nextLine();
        System.out.println("Enter the song's release date:");
        String releaseDate = sn.nextLine();
        System.out.println("Enter the song's duration:");
        String duration = sn.nextLine();

        Song song = new Song(new SongData(name, releaseDate, duration));
        // Set the singer for the song
        song.setSinger(singers.get(0));
        // Add the song to the singer's list of songs
        singers.get(0).getSongs().add(song);
        repository.save(singers.get(0));
        System.out.println("Song registered successfully!");
    }

    private void registerSinger() {
        System.out.println("Enter the singer's name:");
        String name = sn.nextLine();
        System.out.println("Enter the singer's country:");
        String country = sn.nextLine();
        System.out.println("Enter the singer's birth date:");
        String birthDate = sn.nextLine();
        System.out.println("Enter the singer's genre:");
        String genre = sn.nextLine();

        Singer singer = new Singer(new SingerData(name, country, birthDate, genre));
        repository.save(singer);
        System.out.println("Singer registered successfully!");
    }

    private void showSingers() {
        repository.findAll().forEach(System.out::println);
    }
}
