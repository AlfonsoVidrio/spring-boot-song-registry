package com.challenge.song_registry.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date releaseDate;
    private String duration;
    @ManyToOne
    private Singer singer;


    public Song () {}

    public Song(SongData songData) {
        this.title = songData.title();
        this.duration = songData.duration();
        try {
            this.releaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(songData.releaseDate());
        } catch (ParseException e) {
            e.printStackTrace();
            this.releaseDate = null; // or handle the error as needed
        }
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return
                "releaseDate='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration;
    }
}
