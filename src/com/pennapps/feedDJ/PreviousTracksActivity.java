package com.pennapps.feedDJ;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class PreviousTracksActivity extends ListActivity {
	
	public static List<Song> previousSongs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        previousSongs = new ArrayList<Song>();
        setListAdapter(new SongArrayAdapter(this, R.layout.list_song, getSongs()));
        System.out.println("Created PreviousTracks");
	}
	
	
	private List<Song> getSongs() {
		Song s1 = new Song("Elements of Life", "DJ Tiesto");
		Song s2 = new Song("Moar Ghosts n Stuff", "Deadmau5");
		Song s3 = new Song("Irufushi", "Super8 & Tab");
		Song s4 = new Song("Another World", "The Chemical Brothers");
		Song s5 = new Song("1901", "Phoenix");
		Song s6 = new Song("Capital", "Christoph Andersson");
		Song s7 = new Song("Empathy", "Crystal Castles");
		Song s8 = new Song("Lebanese Blonde", "Thievery Corporation");
		Song s9 = new Song("The Horror", "RJD2");
		Song s10 = new Song("Remember", "Deadmau5");
		List songs = new ArrayList();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		songs.add(s5);
		songs.add(s6);
		songs.add(s7);
		songs.add(s8);
		songs.add(s9);
		songs.add(s10);
		return songs;
	}
}
