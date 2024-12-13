package com.challenge.song_registry.model;

public enum Genre {
    ROCK("Rock"),
    POP("Pop"),
    RAP("Rap"),
    CLASSIC("Classic"),
    JAZZ("Jazz"),
    REGGAE("Reggae"),
    FUNK("Funk"),
    METAL("Metal"),
    BLUES("Blues"),
    COUNTRY("Country");

    private String genre;
    Genre (String genre) {
        this.genre = genre;
    }

    public static Genre fromString(String text){
        for(Genre Gen: Genre.values()){
            if(Gen.genre.equalsIgnoreCase(text)){
                return Gen;
            }
        }
        throw new IllegalArgumentException("No genre found for " + text);
    }
}
