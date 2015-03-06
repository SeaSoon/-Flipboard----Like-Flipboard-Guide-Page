package com.ocean.filpboardstart;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private List<String> textList = new ArrayList<String>();
	private ListView lv_circle;
	private String[] strs = new String[]{
		"新闻","军事","娱乐","搞笑"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv_circle = (ListView) findViewById(R.id.lv_background);
		for (int i = 0; i < 4; i++) {
			textList.add(strs[i]);
		}
		new Timer().schedule(new TimerTaskForListViewRolling(lv_circle, this, textList), 10, 10);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
