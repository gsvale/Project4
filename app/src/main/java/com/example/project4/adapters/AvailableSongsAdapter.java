package com.example.project4.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project4.R;
import com.example.project4.activities.PlayingNowActivity;
import com.example.project4.activities.SongsActivity;
import com.example.project4.objects.Song;

import java.util.ArrayList;

/**
 * The type Available songs adapter.
 */
public class AvailableSongsAdapter extends ArrayAdapter<Song> {

    private ArrayList<Song> songs;

    /**
     * Instantiates a new Available songs adapter.
     *
     * @param context the context
     * @param values  the values
     */
    public AvailableSongsAdapter(Context context, ArrayList<Song> values) {
        super(context, 0, values);
        songs = values;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Song songItem = getItem(position);

        View viewItem = convertView;
        if (viewItem == null) {
            viewItem = LayoutInflater.from(getContext()).inflate(R.layout.available_songs_list_item, parent, false);
        }

        TextView songNameTv = viewItem.findViewById(R.id.song_name_tv_id);
        TextView songArtistTv = viewItem.findViewById(R.id.song_artist_tv_id);

        // Fill name and song TextViews with the Song object values
        songNameTv.setText(songItem != null ? songItem.getSongName() : null);
        songArtistTv.setText(songItem != null ? songItem.getArtistName() : null);

        Button songPlayBt = viewItem.findViewById(R.id.song_play_bt_id);
        songPlayBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explicit intent -> Go to PlayingNowActivity and pass extra information to intent -> ArraysList of songs and the song to play index

                Intent intent = new Intent(getContext(), PlayingNowActivity.class);
                intent.putExtra(SongsActivity.SONG_LIST_TAG, songs);
                intent.putExtra(SongsActivity.SONG_SELECTED_TAG, position);

                // Update mCurrentSongPlaying in SongsActivity
                ((SongsActivity) getContext()).setCurrentSongPlaying(songItem);

                getContext().startActivity(intent);
            }
        });

        return viewItem;
    }
}
