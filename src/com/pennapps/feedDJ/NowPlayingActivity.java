package com.pennapps.feedDJ;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NowPlayingActivity extends Activity {
	
	private Song currentSong;
	private ImageButton thumbsUp;
	private ImageButton thumbsDown;
	private TextView title;
	private TextView artist;
	private Requester r;
	private Handler h;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Put updates to currentSong here
        // Display loading screen in the meantime?
        this.h = new Handler() {
			public void handleMessage(Message msg) {
				//process incoming messages here
				switch (msg.what) {
				case 0:
					//(String) msg.obj is the JSON response or 'ack'
					if (msg.obj.equals("ack")) {
						break;
					}
					else {
						//we have a JSON string so parse it
						try {
							JSONObject JObj = new JSONObject((String) msg.obj);
							if (JObj.get("req").equals("5")) {
								//confirm a new now playing
								String new_name = JObj.getJSONArray("song").getString(0);
								String new_artist = JObj.getJSONArray("song").getString(1);
								updateCurrentSong(new Song(new_name, new_artist));
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				}
			}
		};
        setContentView(R.layout.now_playing);
        addWidgets();
        setListeners();
        getInitValues();
	}
	
	private void getInitValues() {
		JSONObject n = new JSONObject();
		JSONObject f = new JSONObject();
		
		try {
			n.put("req", "4");
			f.put("req", "5");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.r = new Requester(this.h, n.toString());
		this.r.run();
		this.r = new Requester(this.h, f.toString());
		this.r.run();
	}

	private void setListeners() {
		thumbsUp.setOnClickListener(thumbsUpButtonListener);
		thumbsDown.setOnClickListener(thumbsDownButtonListener);
	};

	// Configure widgets on screen
	private void addWidgets() {
		this.thumbsUp = (ImageButton) this.findViewById(R.id.thumbs_up);
		this.thumbsDown = (ImageButton) this.findViewById(R.id.thumbs_down);
		this.title = (TextView) this.findViewById(R.id.text1);
		this.artist = (TextView) this.findViewById(R.id.text2);
		this.title.setText("Capital (Original Mix)");
		this.artist.setText("Christoph Andersson");
	}
		
	private android.view.View.OnClickListener thumbsUpButtonListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			JSONMagic("2");			
		}
	};
	
	private android.view.View.OnClickListener thumbsDownButtonListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			JSONMagic("3");			
		}
	};
	
	private void JSONMagic(String req) {
		JSONObject jObj = new JSONObject();
		try {
			jObj.put("req", req);
			jObj.put("id", currentSong.getID());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return;
		}
		//send jObj to server
		r = new Requester(h, jObj.toString());
		r.run();
	}
	
	public void updateCurrentSong(Song s) {
		// Add currentSong to previousTracks list
		if (currentSong != null) {
			PreviousTracksActivity.previousSongs.add(currentSong);
		}
		currentSong = s;
		title.setText(currentSong.getTitle());
        artist.setText(currentSong.getArtist());
	}
}
