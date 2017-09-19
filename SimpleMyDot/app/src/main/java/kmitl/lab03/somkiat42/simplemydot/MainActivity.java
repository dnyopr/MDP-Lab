package kmitl.lab03.somkiat42.simplemydot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import kmitl.lab03.somkiat42.simplemydot.fragment.main;
import kmitl.lab03.somkiat42.simplemydot.model.Dots;
import kmitl.lab03.somkiat42.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity implements main.AListener, View.OnClickListener{

    private DotView dotView;
    private Dots dots;
    private main main_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnRandom = (Button) findViewById(R.id.randomDot);
        Button btnClear = (Button) findViewById(R.id.removeAll);

        if(savedInstanceState == null) {
            initialFragment();
        }

        btnRandom.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    private void initialFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, main.newInstance())
                .commit();
    }

    private void viewFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onClick(View view) {
        if(R.id.randomDot == view.getId()){
            main_fragment.onRandomDot(view);
            Log.wtf("printLogTest"," hi");
        }
        else if(R.id.removeAll == view.getId()){
            main_fragment.onRemoveAll(view);
        }
    }

    @Override
    public void log(String dots) {
        Log.i("log", dots);
    }


}
