package com.ffchat.localchat;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewActivity extends Activity {
	/** Called when the activity is first created. */
	private GridView gv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		gv = (GridView) findViewById(R.id.mygrid);
		AddAdapter addadapter = new AddAdapter(this);
		gv.setAdapter(addadapter);
	}

	public class AddAdapter extends BaseAdapter {
		private final LayoutInflater mInflater;
		private final ArrayList<ListItem> mItems = new ArrayList<ListItem>();

		// public static final int ITEM_SHORTCUT = 0;
		// public static final int ITEM_APPWIDGET = 1;
		// public static final int ITEM_LIVE_FOLDER = 2;
		// public static final int ITEM_WALLPAPER = 3;
		/**
		 * Specific item in our list.
		 */
		public class ListItem {
			public final CharSequence text;
			public final Drawable image;
			// public final int actionTag;
			public final Drawable touchimage;

			// , int actionTag
			public ListItem(Resources res, int textResourceId, int imageResourceId, int touchImageResourceId) {
				text = res.getString(textResourceId);
				if (imageResourceId != -1) {
					image = res.getDrawable(imageResourceId);
				} else {
					image = null;
				}
				if (touchImageResourceId != -1) {
					touchimage = res.getDrawable(touchImageResourceId);
				} else {
					touchimage = null;
				}
			}
		}

		public AddAdapter(GridViewActivity launcher) {
			super();
			mInflater = (LayoutInflater) launcher.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// Create default actions
			Resources res = launcher.getResources();
			mItems.add(new ListItem(res, R.string.item1, R.drawable.item1, R.drawable.item5));
			mItems.add(new ListItem(res, R.string.item2, R.drawable.item2, R.drawable.item6));
			mItems.add(new ListItem(res, R.string.item3, R.drawable.item3, R.drawable.item7));
			mItems.add(new ListItem(res, R.string.item4, R.drawable.item4, R.drawable.item8));
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			final ListItem item = (ListItem) getItem(position);
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.griditem, parent, false);
			}
			final TextView textView = (TextView) convertView;// .findViewById(R.id.mygrid);
			textView.setTag(item);
			textView.setText(item.text);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, item.image, null, null);
			textView.setOnTouchListener(new OnTouchListener() {
				public boolean onTouch(View arg0, MotionEvent arg1) {
					// TODO Auto-generated method stub
					if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
						Log.d("WeatherWidget", MotionEvent.ACTION_DOWN + "");
						textView.setCompoundDrawablesWithIntrinsicBounds(null, item.touchimage, null, null);
					} else if (arg1.getAction() == MotionEvent.ACTION_UP) {
						Log.d("WeatherWidget", arg1.getAction() + "");
						textView.setCompoundDrawablesWithIntrinsicBounds(null, item.image, null, null);
						// Intent i = new
						// Intent(GridViewActivity.this,Page1Activity.class);
						// startActivity(i);
					}
					return true;
				}
			});
			return convertView;
		}

		public int getCount() {
			return mItems.size();
		}

		public Object getItem(int position) {
			return mItems.get(position);
		}

		public long getItemId(int position) {
			return position;
		}
	}
}
