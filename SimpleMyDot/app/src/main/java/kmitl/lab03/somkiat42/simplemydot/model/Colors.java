package kmitl.lab03.somkiat42.simplemydot.model;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colors {
    private List<Integer> colorList = new ArrayList<>();

    public Colors() {
        colorList.add(Color.rgb(253,173,150));
        colorList.add(Color.rgb(209,141,178));
        colorList.add(Color.rgb(201,147,212));
        colorList.add(Color.rgb(159,163,227));
        colorList.add(Color.rgb(112,149,225));
        colorList.add(Color.rgb(81,192,191));
        colorList.add(Color.rgb(178,226,137));
        colorList.add(Color.rgb(249,205,151));
        colorList.add(Color.rgb(255,237,153));
        colorList.add(Color.rgb(255,226,0));

    }
    public int getColor() {
        return colorList.get(
                new Random().nextInt(colorList.size()));
    }
}
