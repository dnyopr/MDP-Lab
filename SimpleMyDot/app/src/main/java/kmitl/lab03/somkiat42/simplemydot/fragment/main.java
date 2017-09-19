package kmitl.lab03.somkiat42.simplemydot.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import kmitl.lab03.somkiat42.simplemydot.R;
import kmitl.lab03.somkiat42.simplemydot.model.Colors;
import kmitl.lab03.somkiat42.simplemydot.model.Dot;
import kmitl.lab03.somkiat42.simplemydot.model.Dots;
import kmitl.lab03.somkiat42.simplemydot.view.DotView;

/**
 * A simple {@link Fragment} subclass.
 */
public class main extends Fragment implements Dots.OnDotsChangeListener, DotView.OnDotViewPressListener {

    private DotView dotView;
    private Dots dots;

    public static main newInstance() {
        
        Bundle args = new Bundle();

        main fragment = new main();
        fragment.setArguments(args);
        return fragment;
    }


    public main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        dotView = (DotView) rootView.findViewById(R.id.dotView);
        dotView.setOnDotViewPressListener(this);

        dots = new Dots();
        dots.setListener(this);

        return rootView;


    }


    @Override
    public void onDotViewPressed(int x, int y) {
        int dotPosition = dots.findDot(x, y);
        if(dotPosition == -1) {
            Dot newDot = new Dot(x, y, 30, new Colors().getColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }
    }

    @Override
    public void onDotsChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();
    }

    public void onRandomDot(View view) {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 30, new Colors().getColor());
        dots.addDot(newDot);
    }

    public void onRemoveAll(View view) {
        dots.clearAll();
    }

    public interface AListener{
        void log(String value);
    }



}
