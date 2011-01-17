package com.pennapps.feedDJ;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TwoLineListItem;

public class SongArrayAdapter extends ArrayAdapter {
	private final int resourceId;
	
	public SongArrayAdapter(Context context, int textViewResourceId, 
			List objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Song c = (Song) getItem(position);
		
		//if the array is null nothing to display, just return null
		if (c == null) {
			return null;
		}
		
		LayoutInflater inflater = (LayoutInflater) 
			getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		TwoLineListItem view;
		if (convertView == null) {
			view = (TwoLineListItem) inflater.inflate(resourceId, parent, false);
		}
		else {
			view = (TwoLineListItem) convertView;
		}
		
		//set value for first field
		if (view.getText1() != null) {
			view.getText1().setText(c.getTitle());
		}
		
		if (view.getText2() != null) {
			view.getText2().setText(c.getArtist());
		}
		
		return view;
	}
	
}
