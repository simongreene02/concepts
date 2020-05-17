package com.greatworksinc.concepts.lambdas;

import java.util.Collections;
import java.util.List;

public class Musician {
  private final String title;
  private final List<Album> albums;

  public Musician(String title, List<Album> albums) {
    this.title = title;
    this.albums = albums;
  }

  public String getTitle() {
    return title;
  }

  public List<Album> getAlbums() {
    return Collections.unmodifiableList(albums);
  }
}
