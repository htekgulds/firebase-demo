package com.example.htds.firebasedemo.ui.fragment;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.htds.firebasedemo.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.FontAwesome;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String FIREBASE = "https://htds-android-demo.firebaseio.com/";
    private static final String AUTH_PREFS = "com.example.htds.prefs.auth";

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.text_hello)
    TextView textHello;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, root);
        Firebase.setAndroidContext(getActivity());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        Firebase ref = new Firebase(FIREBASE);

        ref.child("message").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                textHello.setText(snapshot.getValue().toString());
            }

            @Override public void onCancelled(FirebaseError error) {
                textHello.setText(error.getMessage());
            }

        });

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
