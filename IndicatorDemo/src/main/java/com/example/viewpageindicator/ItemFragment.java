package com.example.viewpageindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ItemFragment extends Fragment {

    private android.widget.TextView text;
    private RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final String[] data = new String[]{"mia", "music", "happy", "share", "join", "love"
            , "mia", "music", "happy", "share", "join", "love", "mia", "music", "happy", "share", "join", "love"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View contextView = inflater.inflate(R.layout.fragment_item, container, false);
        this.recycler = (RecyclerView) contextView.findViewById(R.id.recycler);
        this.text = (TextView) contextView.findViewById(R.id.text);
        Bundle mBundle = getArguments();
        String title = mBundle.getString("arg");
        text.setText(title);
        recycler.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(getActivity(), data);
        recycler.setAdapter(mAdapter);
        return contextView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}