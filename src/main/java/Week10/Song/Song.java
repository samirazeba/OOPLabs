package Week10.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song {
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }
    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                return true;
            }
            currentIndex ++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with the target genre");
        }
        return playlist.get(currentIndex++);
    }
}
class RunSong {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Song1" , "Artist1", "Pop"));
        playlist.add(new Song("Song2" , "Artist2", "Rock"));
        playlist.add(new Song("Song3" , "Artist3", "Pop"));
        playlist.add(new Song("Song4" , "Artist4", "Hip Hop"));
        playlist.add(new Song("Song5" , "Artist5", "Rock"));

        String targetGenre = "Pop";
        GenreFilterIterator filter = new GenreFilterIterator(playlist, targetGenre);

        System.out.println("We need to find the song with the genre " + targetGenre);

        while (filter.hasNext()) {
            Song song = filter.next();
            System.out.println("Title: ".concat(song.getTitle())
                    .concat("\nArtist: ").concat(song.getArtist())
                    .concat("\nGenre: ").concat(song.getGenre()).concat("\n"));
        }

    }
}