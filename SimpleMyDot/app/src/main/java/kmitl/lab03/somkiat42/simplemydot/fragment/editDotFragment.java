package kmitl.lab03.somkiat42.simplemydot.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kmitl.lab03.somkiat42.simplemydot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class editDotFragment extends Fragment {


    public editDotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_dot, container, false);
    }

}
