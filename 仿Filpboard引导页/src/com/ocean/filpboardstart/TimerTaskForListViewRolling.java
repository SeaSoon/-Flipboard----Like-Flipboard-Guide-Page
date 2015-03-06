package com.ocean.filpboardstart;

import java.util.List;
import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TimerTaskForListViewRolling extends TimerTask {
	private ListView listView;
	private int smoothBy = 3;
	private Context context;
	private List<String> sponsorList;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			listView.smoothScrollBy(smoothBy, 0);
		};
	};

	public TimerTaskForListViewRolling(ListView listView, Context context,
			List<String> sponsorList) {
		this.listView = listView;
		this.context = context;
		this.sponsorList = sponsorList;

		listView.setAdapter(new MyBaseAdapter());
	}

	@Override
	public void run() {
		Message msg = handler.obtainMessage();
		handler.sendMessage(msg);
	}

	private class MyBaseAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			}

			// 找到listView中的item， 并且给每个item设置值
			TextView tv_line = (TextView) convertView.findViewById(R.id.list_line);
			TextView tv_name = (TextView) convertView.findViewById(R.id.list_name);
			String map = sponsorList.get(position% sponsorList.size());
			tv_line.setText("第 "+position+ " 行");
			tv_name.setText(map);

			return convertView;
		}

	}

}
