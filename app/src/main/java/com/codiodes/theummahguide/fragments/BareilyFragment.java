package com.codiodes.theummahguide.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codiodes.theummahguide.R;
import com.codiodes.theummahguide.activities.PostActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BareilyFragment extends Fragment {

    public BareilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bareily, container, false);
        ButterKnife.inject(this, view);
        // Inflate the layout for this fragment
        return view;
    }

    @OnClick(R.id.demo_button)
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), PostActivity.class);
        startActivity(intent);
    }
}
