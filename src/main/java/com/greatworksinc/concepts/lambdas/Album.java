package com.greatworksinc.concepts.lambdas;

import java.util.Collections;
import java.util.List;

public class Album {
  private final String title;
  private final List<Song> songs;

  public Album(String title, List<Song> songs) {
    this.title = title;
    this.songs = songs;
  }

  public String getTitle() {
    return title;
  }

  public List<Song> getSongs() {
    return Collections.unmodifiableList(songs);
  }
}
