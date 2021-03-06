package danaya58070042.kmitl.moneyflow;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danaya58070042.kmitl.moneyflow.database.MoneyFlowDB;
import danaya58070042.kmitl.moneyflow.model.MoneyFlow;

public class AddData extends AppCompatActivity implements View.OnClickListener{
    Button btn_income, btn_expense, btn_save;
    EditText detail, amount;
    String type;
    MoneyFlowDB moneyFlowDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        btn_income = findViewById(R.id.btn_income);
        btn_expense = findViewById(R.id.btn_expense);
        btn_save = findViewById(R.id.btn_save);
        detail = findViewById(R.id.edit_detail);
        amount = findViewById(R.id.edit_amount);
        btn_income.setOnClickListener(this);
        btn_expense.setOnClickListener(this);
        btn_save.setOnClickListener(this);

        moneyFlowDB = Room.databaseBuilder(this,
                MoneyFlowDB.class, "Moneyflow")
                .fallbackToDestructiveMigration()
                .build();



    }

    @Override
    public void onClick(View view) {
        if(R.id.btn_income == view.getId()){
            type = "+";
        }
        else if(R.id.btn_expense == view.getId()){
            type = "-";
        }
        else if(R.id.btn_save == view.getId()){
            new AsyncTask<Void, Void, MoneyFlow>(){
                @Override
                protected MoneyFlow doInBackground(Void... voids) {
                    MoneyFlow moneyFlow = new MoneyFlow();

                    moneyFlow.setType(type);
                    moneyFlow.setDescribe(detail.getText().toString());
                    moneyFlow.setAmount(Integer.valueOf(amount.getText().toString()));

                    moneyFlowDB.getMoneyFlowDAO().insert(moneyFlow);
                    return null;
                }
            }.execute();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
