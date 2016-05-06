package com.example.cmsc436.exampletabs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Katherine Larson on 4/26/2016.
 */
public class EventAdapter extends BaseAdapter {

    private Activity mContext;
    private ArrayList<CalendarEvent> mList;
    private LayoutInflater mLayoutInflater = null;

    public EventAdapter(Activity context, ArrayList<CalendarEvent> data) {
        mContext = context;
        mList = data;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int pos) {
        return mList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        CalendarListViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.calendarevent, null);
            viewHolder = new CalendarListViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (CalendarListViewHolder) v.getTag();
        }

        viewHolder.title.setText(mList.get(position).getTitle());

        String text = mList.get(position).getDescription();

        String date = text.substring(0, text.indexOf("<br/>"));


        String des = "";
        des = des + date + "\n";

        String text2 = mList.get(position).getDescription().substring(date.length());
        text2 = text2.replaceAll("<br/>", "\n");

        des = des + text2;

        viewHolder.description.setText(des);
        String link = mList.get(position).getLink();
        viewHolder.link.setText(link);
        return v;
    }

    class CalendarListViewHolder {
        public TextView title;
        public TextView description;
        public TextView link;

        public CalendarListViewHolder(View base) {
            title = (TextView) base.findViewById(R.id.eventTitle);
            description = (TextView) base.findViewById(R.id.eventDescription);
            link = (TextView) base.findViewById(R.id.link);
            final String linkText = link.getText().toString();
            link.setText("");

            //link.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}