package com.example.project4.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The type Song.
 */
public class Song implements Parcelable {

    private String songName;
    private String artistName;
    private String songTime;

    // Selected/Playing song index/position
    private static int SELECTED_SONG_POSITION = -1;

    /**
     * Instantiates a new Song.
     *
     * @param songName   the song name
     * @param artistName the artist name
     * @param songTime   the song time
     */
    public Song(String songName, String artistName, String songTime) {
        this.songName = songName;
        this.artistName = artistName;
        this.songTime = songTime;
    }

    /**
     * Gets song name.
     *
     * @return the song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Gets artist name.
     *
     * @return the artist name
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Gets song time.
     *
     * @return the song time
     */
    public String getSongTime() {
        return songTime;
    }

    /**
     * Sets current playing song position.
     *
     * @param position the song position
     */
    public static void setCurrentPlayingSongPosition(int position)  {
        SELECTED_SONG_POSITION = position;
    }

    /**
     * Get current playing song position int.
     *
     * @return the int of song position
     */
    public static int getCurrentPlayingSongPosition(){
        return SELECTED_SONG_POSITION;
    }

    private Song(Parcel in) {
        songName = in.readString();
        artistName = in.readString();
        songTime = in.readString();
    }

    /**
     * The constant CREATOR.
     */
    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(artistName);
        dest.writeString(songTime);
    }
}
