package com.xiaoooyu.bethany.sample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xiaoooyu.bethany.sample.SegmentedPager.SegmentedPagerFragment;


public class MainActivity extends ActionBarActivity {

    private Drawable mActionBarBackgroundDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.ab_background);
        mActionBarBackgroundDrawable.setAlpha(0);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(mActionBarBackgroundDrawable);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment = new SegmentedPagerFragment();
            transaction.replace(R.id.content_fragment, fragment);
            transaction.commit();
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
        } else if(id == R.id.action_blur) {
            Intent intent = new Intent(this, BlurActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
