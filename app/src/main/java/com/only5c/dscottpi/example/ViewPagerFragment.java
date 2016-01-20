package com.only5c.dscottpi.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dan on 18/01/2016.
 */
public class ViewPagerFragment extends Fragment {

    public static ViewPagerFragment newInstance(int position) {

        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt("POS", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int position = getArguments().getInt("POS");

        View v = inflater.inflate(R.layout.vp_fragment, container, false);
        TextView tv = (TextView) v.findViewById(R.id.fragment_title);
        tv.setText(String.valueOf(position));

        return v;
    }
}
