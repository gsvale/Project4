package com.example.project4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project4.R;
import com.example.project4.objects.Song;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Artist list activity.
 */
public class ArtistListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list);

        ListView artistsListView = findViewById(R.id.artists_lv_id);

        // Get songs list from bundle
        Bundle bundle = getIntent().getExtras();
        ArrayList<Song> songs = new ArrayList<>();

        if (bundle != null) {
            songs = bundle.getParcelableArrayList(SongsActivity.SONG_LIST_TAG);
        }

        // Verify if songs list is not null and its not empty
        if (songs != null && !songs.isEmpty()) {
            ArrayList<String> artists = new ArrayList<>();

            int index = 0;
            int size = songs.size();

            // Create list of artist from songs artists, and avoid duplicates
            while (index < size) {

                String artist = songs.get(index).getArtistName();

                if (!artists.contains(artist)) {
                    artists.add(artist);
                }

                index++;
            }

            // Sort list of artists
            Collections.sort(artists);


            // Create and set ArrayList<String> adapter with artists list
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.artist_list_item, artists);
            artistsListView.setAdapter(adapter);
        }


    }
}
