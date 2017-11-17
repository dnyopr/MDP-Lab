package com.danaya.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

        displayCouter();

    }

    public void displayCouter() {

        final TextView txtResult = findViewById(R.id.countText);
//        Button btn_click = findViewById(R.id.button);
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                counter++;
//                txt.setText(String.valueOf(counter));
//            }
//        });

        txtResult.setText(String.valueOf(counterViewModel.getCounter()));

    }

    public void onCounter(View view) {
        counterViewModel.setCounter(counterViewModel.getCounter()+1);
        displayCouter();
    }
}
