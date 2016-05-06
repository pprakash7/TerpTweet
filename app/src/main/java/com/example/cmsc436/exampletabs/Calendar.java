package com.example.cmsc436.exampletabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;

public class Calendar extends AppCompatActivity implements OnRssLoadListener {

    private String URL = "http://umd.bwcs-hosting.com/feeder/main/eventsFeed.do?f=y&sort=dtstart.utc:asc&fexpr=" +
            "(categories.href!=%22/public/.bedework/categories/sys/Ongoing%22%20and%20categories.href!=%22/public" +
            "/.bedework/categories/Campus%20Bulletin%20Board%22)%20and%20(entity_type=%22event%22%7Centity_type=%22todo%22)" +
            "&skinName=list-rss&count=10";


    private ListView feed;
    private ArrayList<CalendarEvent> events;
    private EventAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        feed = (ListView) findViewById(R.id.listViewCalendar);
        events = new ArrayList<CalendarEvent>();
        mListAdapter = new EventAdapter(this, events);
        loadFeeds(URL);
        feed.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();

    }

    private void loadFeeds(String url) {
        String[] urlArr = {url};
        new RssReader(Calendar.this)
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {
        // Assuming RSS size of 10
        for (int i = 0; i < rssItems.size(); i++) {
            String title = rssItems.get(i).getTitle();
            String description = rssItems.get(i).getDescription();
            String link = rssItems.get(i).getLink();
            CalendarEvent toAdd = new CalendarEvent(title, link, description);
            events.add(toAdd);
        }

        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(Calendar.this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }
}
