package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();       // Define the Fragment manager
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);   // Try adding finding the fragment by container ID

                                                            // If the fragment does not exist
        if(fragment == null) {
            fragment = new CrimeFragment();                 // Then create a new one
            fm.beginTransaction()                           // and attach it to the fragment container ID in the FM
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
