package ch.k42.suspendablecoffee;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import ch.k42.suspendablecoffee.fragments.FeedFragment;
import ch.k42.suspendablecoffee.fragments.MapFragment;
import ch.k42.suspendablecoffee.fragments.PayFragment;

public class MainActivity extends AppCompatActivity implements FeedFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener, PayFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Bundle args = new Bundle();
            FragmentTransaction transaction;
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    // Create fragment and give it an argument specifying the article it should show
                    MapFragment mapFragment = new MapFragment();

                    //args.putInt(MapFragment.ARG_POSITION, position);
                    mapFragment.setArguments(args);

                    transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, mapFragment);
                    transaction.addToBackStack(null);

// Commit the transaction
                    transaction.commit();
                    return true;
                case R.id.navigation_pay:
                    // Create fragment and give it an argument specifying the article it should show
                    PayFragment payFragment = new PayFragment();
                    //args.putInt(MapFragment.ARG_POSITION, position);
                    payFragment.setArguments(args);

                    transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, payFragment);
                    transaction.addToBackStack(null);

// Commit the transaction
                    transaction.commit();
                    return true;
                case R.id.navigation_feed:
                    // Create fragment and give it an argument specifying the article it should show
                    FeedFragment feedFragment = new FeedFragment();
                    //args.putInt(MapFragment.ARG_POSITION, position);
                    feedFragment.setArguments(args);

                    transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, feedFragment);
                    transaction.addToBackStack(null);

// Commit the transaction
                    transaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            MapFragment firstFragment = new MapFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
