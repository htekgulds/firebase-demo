package com.example.htds.firebasedemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.htds.firebasedemo.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.edit_user)
    MaterialEditText editUser;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, root);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }

}
