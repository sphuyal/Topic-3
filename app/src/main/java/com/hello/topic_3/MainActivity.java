package com.hello.topic_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    AutoCompleteTextView etBatch;
    Spinner spinCountry;
    Button btnSave;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName=findViewById(R.id.etName);
        result=findViewById(R.id.result);
        spinCountry =findViewById(R.id.spinCountry);
        btnSave=findViewById(R.id.btnSave);

        String countries[] ={"Nepal","USA","Spain","France","China","japan"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spinCountry.setAdapter(adapter);

        String batch[]={"22 A", "22 B", "22 C", "22 D"};

        etBatch = findViewById(R.id.etBatch);
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,android.R.layout.select_dialog_item,batch);

        etBatch.setAdapter(stringArrayAdapter);
        etBatch.setThreshold(1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,batch,country;

                name=etName.getText().toString();
                country = spinCountry.getSelectedItem().toString();
                batch=etBatch.getText().toString();

                result.append(("name:"+ name + "country: " +country+"batch: "+batch+"\n"));

            }
        });
    }
}
