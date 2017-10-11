package com.kmitl.danaya58070042.lazyinstagram.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmitl.danaya58070042.lazyinstagram.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {



    public static MainFragment newInstance(String message) {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        args.putString("message",message);
        fragment.setArguments(args);
        return fragment;
    }

    String message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString("message");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView fragmentTextView = (TextView) rootView.findViewById(R.id.fragmentContainer);

        if(!message.isEmpty()){
            fragmentTextView.setText(message);
        }


        return rootView;
    }

}
