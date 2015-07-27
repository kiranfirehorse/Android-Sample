package com.example.neeraj.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by neeraj on 24/7/15.
 */
public class HistoryFragment extends Fragment{
    TextView hist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_frag_layout,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hist=(TextView)getActivity().findViewById(R.id.histFragText);

    }

    void changeText(String data) {
        //Toast.makeText(getActivity(),data,Toast.LENGTH_LONG).show();
    }
}
