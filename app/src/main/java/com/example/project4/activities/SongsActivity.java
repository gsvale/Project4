package com.example.project4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.project4.R;
import com.example.project4.adapters.AvailableSongsAdapter;
import com.example.project4.objects.Song;

import java.util.ArrayList;

/**
 * The type Songs activity.
 */
public class SongsActivity extends AppCompatActivity {


    // This activity is the MAIN and PARENT;

    /**
     * The constant SONG_LIST_TAG.
     */
    public static final String SONG_LIST_TAG = "SONG_LIST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView availableSongsListView = findViewById(R.id.available_songs_lv_id);

        final ArrayList<Song> songs = new ArrayList<>();

        // Fill ArrayList<Song> with values
        songs.add(new Song(getString(R.string.bob_sinclar_song_1_name), getString(R.string.bob_sinclar_artist), getString(R.string.bob_sinclar_song_1_time)));
        songs.add(new Song(getString(R.string.bob_sinclar_song_2_name), getString(R.string.bob_sinclar_artist), getString(R.string.bob_sinclar_song_2_time)));
        songs.add(new Song(getString(R.string.bob_sinclar_song_3_name), getString(R.string.bob_sinclar_artist), getString(R.string.bob_sinclar_song_3_time)));
        songs.add(new Song(getString(R.string.robbie_williams_song_1_name), getString(R.string.robbie_williams_artist), getString(R.string.robbie_williams_song_1_time)));
        songs.add(new Song(getString(R.string.robbie_williams_song_2_name), getString(R.string.robbie_williams_artist), getString(R.string.robbie_williams_song_2_time)));
        songs.add(new Song(getString(R.string.robbie_williams_song_3_name), getString(R.string.robbie_williams_artist), getString(R.string.robbie_williams_song_3_time)));
        songs.add(new Song(getString(R.string.shakira_song_1_name), getString(R.string.shakira_artist), getString(R.string.shakira_song_1_time)));
        songs.add(new Song(getString(R.string.shakira_song_2_name), getString(R.string.shakira_artist), getString(R.string.shakira_song_2_time)));
        songs.add(new Song(getString(R.string.shakira_song_3_name), getString(R.string.shakira_artist), getString(R.string.shakira_song_3_time)));
        songs.add(new Song(getString(R.string.pedro_abrunhosa_song_1_name), getString(R.string.pedro_abrunhosa_artist), getString(R.string.pedro_abrunhosa_song_1_time)));
        songs.add(new Song(getString(R.string.pedro_abrunhosa_song_2_name), getString(R.string.pedro_abrunhosa_artist), getString(R.string.pedro_abrunhosa_song_2_time)));
        songs.add(new Song(getString(R.string.pedro_abrunhosa_song_3_name), getString(R.string.pedro_abrunhosa_artist), getString(R.string.pedro_abrunhosa_song_3_time)));
        songs.add(new Song(getString(R.string.calvin_harris_song_1_name), getString(R.string.calvin_harris_artist), getString(R.string.calvin_harris_song_1_time)));
        songs.add(new Song(getString(R.string.calvin_harris_song_2_name), getString(R.string.calvin_harris_artist), getString(R.string.calvin_harris_song_2_time)));
        songs.add(new Song(getString(R.string.calvin_harris_song_3_name), getString(R.string.calvin_harris_artist), getString(R.string.calvin_harris_song_3_time)));


        // Create CustomAdapter and pass the context of activity and the arraylist of songs
        AvailableSongsAdapter adapter = new AvailableSongsAdapter(this, songs);

        availableSongsListView.setAdapter(adapter);

        Button playingNowBt = findViewById(R.id.playing_now_bt_id);
        Button artistListBt = findViewById(R.id.artist_list_bt_id);

        // Click intent for PLAYING NOW button
        playingNowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explicit intent -> Go to PlayingNowActivity and pass the songs list as extra and the current song playing, if there's one
                Intent intent = new Intent(SongsActivity.this, PlayingNowActivity.class);
                intent.putExtra(SONG_LIST_TAG, songs);
                startActivity(intent);
            }
        });

        // Click intent for ARTIST LIST button
        artistListBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explicit intent -> Go to ArtistListActivity and pass the songs list as extra
                Intent intent = new Intent(SongsActivity.this, ArtistListActivity.class);
                intent.putExtra(SONG_LIST_TAG, songs);
                startActivity(intent);
            }
        });

    }

}
