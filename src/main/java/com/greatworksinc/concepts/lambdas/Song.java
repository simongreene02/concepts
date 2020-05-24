package com.greatworksinc.concepts.lambdas;

public class Song {
  private final String title;
  private final String genre;
  private final int trackLength;
  private final int starRating;

  public Song(String title, String genre, int trackLength, int starRating) {
    this.title = title;
    this.genre = genre;
    this.trackLength = trackLength;
    this.starRating = starRating;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public int getLength() {
    return trackLength;
  }

  public int getStarRating() {
    return starRating;
  }
}
