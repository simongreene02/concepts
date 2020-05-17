package com.greatworksinc.concepts.lambdas;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimonJukeboxTest {
  private final Song song1 = new Song("Song 1", "Music", 99);
  private final Song song2 = new Song("Song 2", "Music", 1);
  private final Song song3 = new Song("Song 3", "Music", 300);
  private final Song song4 = new Song("Song 4", "Music", 56.7);
  private final Song song5 = new Song("Song 5", "Music", 38);
  private final Album album1 = new Album("Album 1", List.of(song1, song2, song3));
  private final Album album2 = new Album("Album 2", List.of(song4, song5));
  private final Album album3 = new Album("Album 3", List.of(song4));
  private final Album album4 = new Album("Album 4", List.of());
  private final Musician musician1 = new Musician("Musician 1", List.of(album1, album2));
  private Jukebox jukebox;

  @BeforeEach
  void setUp() {
    jukebox = new SimonJukebox();
  }

  @Test
  void findAlbumNamesForMusician() {
    assertThat(jukebox.findAlbumNamesForMusician(musician1))
        .containsExactly("Album 1", "Album 2")
        .inOrder();
  }

  @Test
  void skipFirst2Songs() {
    assertThat(jukebox.skipFirst2Songs(album1)).containsExactly(song3);
  }

  @Test
  void skipFirst2Songs_twoItems() {
    assertThat(jukebox.skipFirst2Songs(album2)).isEmpty();
  }

  @Test
  void skipFirst2Songs_oneItem() {
    assertThat(jukebox.skipFirst2Songs(album3)).isEmpty();
  }

  @Test
  void skipFirst2Songs_empty() {
    assertThat(jukebox.skipFirst2Songs(album4)).isEmpty();
  }

  @Test
  void computeTotalLengthByGenre() {}

  @Test
  void findOneSong() {
    assertThat(jukebox.findOneSong(List.of(album1, album2))).hasValue(song1);
  }

  @Test
  void findOneSong_emptyAlbum() {
    assertThat(jukebox.findOneSong(List.of(album4))).isEmpty();
  }

  @Test
  void findOneSong_emptyList() {
    assertThat(jukebox.findOneSong(List.of())).isEmpty();
  }

  @Test
  void findAllSongsForAlbums() {
    assertThat(jukebox.findAllSongsForAlbums(List.of(album1, album2)))
        .containsExactly(song1, song2, song3, song4, song5);
  }

  @Test
  void findAllSongsForMusicians() {
    assertThat(jukebox.findAllSongsForMusicians(List.of(musician1)))
        .containsExactly(song1, song2, song3, song4, song5);
  }

  @Test
  void findShortSongs() {}

  @Test
  void findStarSongs() {}
}
