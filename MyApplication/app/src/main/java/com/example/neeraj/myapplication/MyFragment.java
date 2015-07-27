package com.example.neeraj.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by neeraj on 24/7/15.
 */
public class MyFragment extends Fragment implements View.OnClickListener{

    Button btn;
    int counter=0;
    Communicator comm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm= (Communicator) getActivity();
        btn=(Button)getActivity().findViewById(R.id.fragBtn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        comm.respond(new String("you clicked that times...!"));

    }
}
