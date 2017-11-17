package com.danaya.viewmodel;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Danaya on 11/17/2017.
 */

public class CounterViewModel extends ViewModel {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
