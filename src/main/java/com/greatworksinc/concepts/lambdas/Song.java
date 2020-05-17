package com.greatworksinc.concepts.lambdas;

public class Song {
  private final String title;
  private final String genre;
  private final double trackLength;
  private final int starRating;

  public Song(String title, String genre, double trackLength) {
    this.title = title;
    this.genre = genre;
    this.trackLength = trackLength;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public double getLength() {
    return trackLength;
  }
}
