package com.example.cmsc436.exampletabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "pf9nKLgyg0xSYkQPs427T7ON0";
    private static final String TWITTER_SECRET = "o98K9CFnuQJsjXlIcU2Yxs6xmk733CvjqtH9xwEZrFOBAuTAGn";


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private DrawerLayout mDrawer;
    private Intent intent;

    public static ArrayList<TwitterAccount> accountsToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = getIntent();

        // ArrayList of the accounts to be shown
        accountsToShow = new ArrayList<>();

        // Twitter Accounts at UMD
        TwitterAccount presidentLoh = new TwitterAccount("President Loh", 299743215L, "presidentLoh");
        TwitterAccount uOfMd = new TwitterAccount("UMD",36003748L , "UofMaryland");
        TwitterAccount diamondback = new TwitterAccount("Diamondback", 36003748L, "thedbk");
        TwitterAccount dots = new TwitterAccount("DOTS", 95280326L, "DOTS_UMD");
        TwitterAccount umdCS = new TwitterAccount("CS", 2375775877L, "umdcs");
        TwitterAccount umpd = new TwitterAccount("UMPD", 24467012L, "UMPD");
        TwitterAccount terrapins = new TwitterAccount("Terrapins", 54994166L, "umterps");
        TwitterAccount libraries = new TwitterAccount("Libraries", 190617492L, "UMDLibraries");
        TwitterAccount see = new TwitterAccount("SEE", 31916772L, "SEE_UMD");
        TwitterAccount greenTidings = new TwitterAccount("Green Tidings", 1339312776L, "UMDGreenTidings");
        TwitterAccount bsos = new TwitterAccount("BSOS",  45880617L, "bsosumd");
        TwitterAccount stamp = new TwitterAccount("Stamp",59604041L, "thestampumd");
        TwitterAccount gradSchool = new TwitterAccount("Grad School", 836145468L, "UMDGradSchool");
        TwitterAccount studentGov = new TwitterAccount("Student Gov.", 322990625L, "UMDSGA");
        TwitterAccount healthCenter = new TwitterAccount("Health Center", 440949316L, "UMDHealthCenter");
        TwitterAccount resLife = new TwitterAccount("Res Life", 978882858L, "UMDReslife");
        TwitterAccount ece = new TwitterAccount("ECE",  64892308L, "eceumd");
        TwitterAccount recWell = new TwitterAccount("RecWell", 139808463L, "UMDRecWell");
        TwitterAccount finAid = new TwitterAccount ("Fin Aid", 140133799L, "umdosfa");
        TwitterAccount intramuruals = new TwitterAccount("Intramuruals", 366214573L, "UMDIntramuruals");
        TwitterAccount umdCompSci = new TwitterAccount("Comp Sci",546915948L, "UMDCompSci" );
        TwitterAccount umdSmith = new TwitterAccount("Smith", 2350626696L, "SmithUndergrad");
        TwitterAccount hungryTerps = new TwitterAccount("Free Food", 377734560L, "Free_Food_UMD");
        TwitterAccount clarkSchool = new TwitterAccount("Clark", 58569666L, "ClarkSchool");
        TwitterAccount umdSenate = new TwitterAccount("Senate", 171922158L, "Senate");
        TwitterAccount terpWeather = new TwitterAccount("Weather", 376005446L, "TerpWeather");

        // Getting the accounts to be shown
        if(intent.getStringExtra("loh").equals("true"))
            accountsToShow.add(presidentLoh);
        if(intent.getStringExtra("umd").equals("true"))
            accountsToShow.add(uOfMd);
        if(intent.getStringExtra("db").equals("true"))
            accountsToShow.add(diamondback);
        if(intent.getStringExtra("dots").equals("true"))
            accountsToShow.add(dots);
        if(intent.getStringExtra("umdcs").equals("true"))
            accountsToShow.add(umdCS);
        if(intent.getStringExtra("umpd").equals("true"))
            accountsToShow.add(umpd);
        if(intent.getStringExtra("terrapins").equals("true"))
            accountsToShow.add(terrapins);
        if(intent.getStringExtra("libraries").equals("true"))
            accountsToShow.add(libraries);
        if(intent.getStringExtra("see").equals("true"))
            accountsToShow.add(see);
        if(intent.getStringExtra("green").equals("true"))
            accountsToShow.add(greenTidings);
        if(intent.getStringExtra("bsos").equals("true"))
            accountsToShow.add(bsos);
        if(intent.getStringExtra("stamp").equals("true"))
            accountsToShow.add(stamp);
        if(intent.getStringExtra("grad").equals("true"))
            accountsToShow.add(gradSchool);
        if(intent.getStringExtra("sga").equals("true"))
            accountsToShow.add(studentGov);
        if(intent.getStringExtra("health").equals("true"))
            accountsToShow.add(healthCenter);
        if(intent.getStringExtra("reslife").equals("true"))
            accountsToShow.add(resLife);
        if(intent.getStringExtra("ece").equals("true"))
            accountsToShow.add(ece);
        if(intent.getStringExtra("recwell").equals("true"))
            accountsToShow.add(recWell);
        if(intent.getStringExtra("financial").equals("true"))
            accountsToShow.add(finAid);
        if(intent.getStringExtra("intramural").equals("true"))
            accountsToShow.add(intramuruals);
        if(intent.getStringExtra("compsci").equals("true"))
            accountsToShow.add(umdCompSci);
        if(intent.getStringExtra("smith").equals("true"))
            accountsToShow.add(umdSmith);
        if(intent.getStringExtra("hungry").equals("true"))
            accountsToShow.add(hungryTerps);
        if(intent.getStringExtra("clark").equals("true"))
            accountsToShow.add(clarkSchool);
        if(intent.getStringExtra("senate").equals("true"))
            accountsToShow.add(umdSenate);
        if(intent.getStringExtra("weather").equals("true"))
            accountsToShow.add(terpWeather);

        // onCreate
        super.onCreate(savedInstanceState);

        // Twitter and Fabric configuration
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(navigationView);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Context context = getApplicationContext();
            CharSequence message = "If you want to change your preferences, please click on the accounts tab";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        Menu navMenu = navigationView.getMenu();
        for (TwitterAccount t: accountsToShow){
            navMenu.add(t.getAccountName());
        }
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked

        mViewPager.setCurrentItem(menuItem.getItemId());
        int index = -1;

        String title = menuItem.getTitle().toString();
        for (TwitterAccount t: accountsToShow) {
            if (t.getAccountName().equalsIgnoreCase(title)) {
                index = accountsToShow.indexOf(t);
            }
        }
        if (index == -1){
            index = 0;
        }

        mViewPager.setCurrentItem(index);

        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mViewPager.setCurrentItem(1);
            return true;
        }
        else if(id == R.id.accounts){
            setResult(1, intent);
            finish();
        }
        else if (id == R.id.calendar) {
            Intent intent = new Intent(getApplicationContext(), Calendar.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";

        private SwipeRefreshLayout swipeRefreshLayout;
        private TweetTimelineListAdapter fragmentAdapter;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Setting listview to twitter
            final ListView listView = (ListView)(rootView.findViewById(R.id.listView));
            swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
            swipeRefreshLayout.setOnRefreshListener(this);
            TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);

            // Building the timeline
            Fabric.with(getContext(), new Twitter(authConfig), new TweetUi());
            int sectionNum = getArguments().getInt(ARG_SECTION_NUMBER) -1;
            Long idNum = accountsToShow.get(sectionNum).getID();

            UserTimeline userTimeLine = new UserTimeline.Builder()
                    .screenName(accountsToShow.get(sectionNum).getIdName())
                    .build();

            TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                    .setTimeline(userTimeLine)
                    .build();

            listView.setAdapter(adapter);
            fragmentAdapter = adapter;

            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                boolean enableRefresh = false;

                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                     int totalItemCount) {
                    if (listView != null && listView.getChildCount() > 0) {
                        // check that the first item is visible and that its top matches the parent
                        enableRefresh = listView.getFirstVisiblePosition() == 0 &&
                                listView.getChildAt(0).getTop() >= 0;
                    } else {
                        enableRefresh = false;
                    }
                    swipeRefreshLayout.setEnabled(enableRefresh);
                }
            });
            return rootView;
        }

        // Creating refresh option
        @Override
        public void onRefresh() {
            swipeRefreshLayout.setRefreshing(true);
            fragmentAdapter.refresh(new Callback<TimelineResult<Tweet>>() {
                @Override
                public void success(Result<TimelineResult<Tweet>> result) {
                    swipeRefreshLayout.setRefreshing(false);
                }

                @Override
                public void failure(TwitterException exception) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show the total number of accounts in the array list
            return accountsToShow.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (accountsToShow.get(position).getAccountName());
        }
    }
}
