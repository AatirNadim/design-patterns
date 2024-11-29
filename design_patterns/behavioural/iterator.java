package design_patterns.behavioural;

import java.util.List;
import java.util.NoSuchElementException;

// Iterator interface
interface SongIterator {
    boolean hasNext();
    Song next();
}

// Aggregate interface
interface SongPlaylist {
    SongIterator createIterator();
}

// Concrete aggregate class
class ConcreteSongPlaylist implements SongPlaylist {
    private List<Song> songs;

    public ConcreteSongPlaylist(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public SongIterator createIterator() {
        return new ConcreteSongIterator(songs);
    }
}

// Concrete iterator class
class ConcreteSongIterator implements SongIterator {
    private List<Song> songs;
    private int currentPosition;

    public ConcreteSongIterator(List<Song> songs) {
        this.songs = songs;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < songs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            Song song = songs.get(currentPosition);
            currentPosition++;
            return song;
        } else {
            throw new NoSuchElementException();
        }
    }
}

// Song class
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

// Client code
//public class MusicPlayer {
//    public static void main(String[] args) {
//        List<Song> songs = Arrays.asList(
//                new Song("Song 1", "Artist 1"),
//                new Song("Song 2", "Artist 2"),
//                new Song("Song 3", "Artist 3")
//        );
//
//        ConcreteSongPlaylist playlist = new ConcreteSongPlaylist(songs);
//        SongIterator iterator = playlist.createIterator();
//
//        while (iterator.hasNext()) {
//            Song song = iterator.next();
//            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist());
//        }
//    }
//}