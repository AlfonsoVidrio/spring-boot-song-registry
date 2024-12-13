package com.challenge.song_registry.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "singers")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs;

    public Singer() {}

    public Singer(SingerData singerData) {
        this.name = singerData.name();
        this.country = singerData.country();
        try {
            this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(singerData.birthDate());
        } catch (ParseException e) {
            e.printStackTrace();
            this.birthDate = null; // or handle the error as needed
        }
        this.genre = Genre.fromString(singerData.genre().trim());
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", genre=" + genre +
                ", songs=" + songs + "\n";
    }
}