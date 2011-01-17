package com.pennapps.feedDJ;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TabHost;

public class feedDJ extends TabActivity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, NowPlayingActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("now_playing").setIndicator("Now Playing",
                          res.getDrawable(R.drawable.tab_icons))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, PreviousTracksActivity.class);
        spec = tabHost.newTabSpec("previous_tracks").setIndicator("Previous Tracks",
                          res.getDrawable(R.drawable.tab_icons))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, VotingActivity.class);
        spec = tabHost.newTabSpec("voting").setIndicator("Voting",
                          res.getDrawable(R.drawable.tab_icons))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Refresh");
    	return super.onCreateOptionsMenu(menu);
    }
}