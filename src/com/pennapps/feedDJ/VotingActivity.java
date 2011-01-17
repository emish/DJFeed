package com.pennapps.feedDJ;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;


public class VotingActivity extends ListActivity {
	
	private ArrayAdapter<String> aa;
	private ArrayList<String> listSongs;
	private ListView listView;
	private String[] songs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  
		  setListAdapter(new SongArrayAdapter(this, R.layout.list_song, getSongs()));

	}
	
	private class ItemClickedListener implements OnItemClickListener {
		
		@Override
		public void onItemClick(AdapterView<?> aArg0, View textView, 
				int aPosition, long godknows) {
			String song_name = listSongs.get(aPosition);
			//Vote on this song name (best to pop a dialog to confirm)
			
		}
	}
	
//	private void updateFuturePlaylist(JSONObject JObj) throws JSONException {
//		JSONArray Jsongs = JObj.getJSONArray("songs");
//		for (int i = 0; i < Jsongs.length(); i++) {
//			VotingActivityJsongs.get(i)[0]
//		}
//	}

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
