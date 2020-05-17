package com.greatworksinc.concepts.lambdas;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimonJukebox implements Jukebox {
  @Override
  public List<String> findAlbumNamesForMusician(Musician musician) {
    return musician.getAlbums().stream().map(Album::getTitle).collect(Collectors.toList());
  }

  @Override
  public List<Song> skipFirst2Songs(Album album) {
    return album.getSongs().stream().skip(2).collect(Collectors.toList());
  }

  @Override
  public Map<String, Integer> computeTotalLengthByGenre(List<Album> albums) {
    return null;
  }

  @Override
  public Optional<Song> findOneSong(List<Album> albums) {
    return albums.stream().map(Album::getSongs).flatMap(Collection::stream).findFirst();
  }

  @Override
  public List<Song> findAllSongsForAlbums(List<Album> albums) {
    return albums.stream()
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  @Override
  public List<Song> findAllSongsForMusicians(List<Musician> musicians) {
    return findAllSongsForAlbums(
        musicians.stream()
            .map(Musician::getAlbums)
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));
  }

  @Override
  public List<Song> findShortSongs(List<Musician> musicians) {
    return findAllSongsForMusicians(musicians).stream()
        .filter(SHORT_SONG)
        .collect(Collectors.toList());
  }

  @Override
  public List<Song> findStarSongs(List<Album> albums, int star) {
    return null;
  }
}
