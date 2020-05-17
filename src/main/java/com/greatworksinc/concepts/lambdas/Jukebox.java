package com.greatworksinc.concepts.lambdas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

// homework
// Given interface, create Immutable model objcts (Musician -> Album -> Song)
public interface Jukebox {

  Predicate<Song> SHORT_SONG = song -> song.getLength() < 60;

  List<String> findAlbumNamesForMusician(Musician musician);

  List<Song> skipFirst2Songs(Album album);

  Map<String, Integer> computeTotalLengthByGenre(List<Album> albums);

  Optional<Song> findOneSong(List<Album> albums);

  List<Song> findAllSongsForAlbums(List<Album> albums);

  List<Song> findAllSongsForMusicians(List<Musician> musicians);

  List<Song> findShortSongs(List<Musician> musicians);

  List<Song> findStarSongs(List<Album> albums, int star);
}
