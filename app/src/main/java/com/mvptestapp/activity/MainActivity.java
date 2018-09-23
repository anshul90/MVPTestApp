package com.mvptestapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.mvptestapp.R;
import com.mvptestapp.fragment.MainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.frame_container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentManager manager = getSupportFragmentManager();
        // create the fragment and data the first time
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_container, MainFragment.newInstance()); // newInstance() is a static factory method.
        transaction.commit();
    }

}
