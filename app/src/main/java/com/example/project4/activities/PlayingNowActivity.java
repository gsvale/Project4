package com.example.project4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project4.R;
import com.example.project4.objects.Song;

import java.util.ArrayList;

/**
 * The type Playing now activity.
 */
public class PlayingNowActivity extends AppCompatActivity {

    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);

        TextView playingNowLabelTv = findViewById(R.id.playing_now_label_tv_id);
        TextView noSongPlayingLabelTv = findViewById(R.id.no_song_playing_label_tv_id);
        TextView songNameTv = findViewById(R.id.playing_song_name_tv_id);
        TextView songArtistTv = findViewById(R.id.playing_song_artist_tv_id);
        TextView songTimeTv = findViewById(R.id.playing_song_time_tv_id);

        // Get songs list from bundle and the current playing song index as well, if there is one
        Bundle bundle = getIntent().getExtras();

        // Get index of current song playing
        int position = Song.getCurrentPlayingSongPosition();

        if (bundle != null) {
            songs = bundle.getParcelableArrayList(SongsActivity.SONG_LIST_TAG);
        }

        // // Verify if songs list is not null and its not empty, and position is valid
        if ((songs != null && !songs.isEmpty()) && position >= 0) {

            Song song = null;
            int size = songs.size();

            // Get song to play
            for (int i = 0; i < size; i++) {
                if (i == position) {
                    song = songs.get(i);
                }
            }


            // If song is null, display warning to the user
            if (song == null) {
                noSongPlayingLabelTv.setVisibility(View.VISIBLE);
                return;
            }

            // Fill TextViews with song item values
            playingNowLabelTv.setVisibility(View.VISIBLE);

            songNameTv.setText(getString(R.string.name_song, song.getSongName()));
            songArtistTv.setText(getString(R.string.artist_song, song.getArtistName()));
            songTimeTv.setText(getString(R.string.time_song, song.getSongTime()));

            songNameTv.setVisibility(View.VISIBLE);
            songArtistTv.setVisibility(View.VISIBLE);
            songTimeTv.setVisibility(View.VISIBLE);
        } else {
            noSongPlayingLabelTv.setVisibility(View.VISIBLE);
        }

        Button artistListBt = findViewById(R.id.artist_list_bt_id);

        // Click intent for ARTIST LIST button
        artistListBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explicit intent -> Go to ArtistListActivity and pass the songs list as extra
                Intent intent = new Intent(PlayingNowActivity.this, ArtistListActivity.class);
                intent.putExtra(SongsActivity.SONG_LIST_TAG, songs);
                startActivity(intent);
            }
        });

    }



}
