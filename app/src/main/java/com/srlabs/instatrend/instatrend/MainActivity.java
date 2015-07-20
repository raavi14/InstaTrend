package com.srlabs.instatrend.instatrend;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;


public class MainActivity extends ActionBarActivity {

    private ConfigurationBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetTrends getTrends=new GetTrends();
        getTrends.execute();
    }

    public class GetTrends extends AsyncTask<Void,Void,String>
    {
        @Override
        protected String doInBackground(Void... params) {
            String temp="";
            builder = new ConfigurationBuilder();
            builder.setApplicationOnlyAuthEnabled(true);
            Twitter twitter = new TwitterFactory(builder.build()).getInstance();
            twitter.setOAuthConsumer(Const.CONSUMER_KEY, Const.CONSUMER_SECRET);
            try {
                OAuth2Token token = twitter.getOAuth2Token();
                Trends value=twitter.getPlaceTrends(23424977);
                Trend[] trends=value.getTrends();
                for(Trend trend:trends)
                {
                    temp+=trend.getName()+" ,";

                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return temp;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txtView=(TextView)findViewById(R.id.txtSample);
            txtView.setText(result);
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
