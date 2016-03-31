package com.vonzhou.springinaction.springidol;

public class SongBook {
    private String[] songTitles;

    public SongBook(String[] songTitles) {
        this.songTitles = songTitles;
    }

    public String pickASong() {
        return songTitles[0];
    }
}
