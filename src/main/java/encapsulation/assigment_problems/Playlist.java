package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2 — The Playlist.
 * Songs are stored in a private array; getSongs() hands back a fresh
 * copy each time, so mutating the returned array never touches the
 * playlist's real contents.
 *
 * Expected Output (running this file's main method):
 *
 * Original after external mutation: [Song A, Song B]
 * Song count: 2
 */
public class Playlist {

    private String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count >= songs.length) {
            return; // playlist full
        }
        songs[count] = title;
        count++;
    }

    /** Returns a safe copy — modifying it never affects the playlist's real contents. */
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // mutating the copy must not affect the playlist

        System.out.println("Original after external mutation: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
