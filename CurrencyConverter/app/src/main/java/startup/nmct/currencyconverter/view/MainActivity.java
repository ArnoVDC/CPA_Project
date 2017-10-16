package startup.nmct.currencyconverter.view;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import startup.nmct.currencyconverter.R;
import startup.nmct.currencyconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, SelectCurrencyFragment.OnFragmentInteractionListener {

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Databinding
        // activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null)
        {
            showMainFragment();
        }

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    // BackStack

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    // Show Fragments

    private void showMainFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment mainFragment = MainFragment.newInstance();
        fragmentTransaction.replace(R.id.fragment_main, mainFragment, "mainFragment");
        fragmentTransaction.addToBackStack("mainFragment");
        fragmentTransaction.commit();
    }

    private void showSelectCurrencyFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectCurrencyFragment selectCurrencyFragment = SelectCurrencyFragment.newInstance();
        fragmentTransaction.replace(R.id.fragment_main, selectCurrencyFragment, "selectCurrencyFragment");
        fragmentTransaction.addToBackStack("selectCurrencyFragment");
        fragmentTransaction.commit();
    }

    private void showSelectCountryFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectCountryFragment selectCountryFragment = SelectCountryFragment.newInstance();
        fragmentTransaction.replace(R.id.fragment_main, selectCountryFragment, "selectCountryFragment");
        fragmentTransaction.addToBackStack("selectCountryFragment");
        fragmentTransaction.commit();
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
            showSelectCurrencyFragment();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Fragment callbacks

    @Override
    public void onMainFragmentInteraction(Uri uri) {
        // MainFragment Callback
    }

    @Override
    public void onSelectCurrencyFragmentInteraction(Uri uri) {
        // SelectCurrencyFragment Callback
    }
}
