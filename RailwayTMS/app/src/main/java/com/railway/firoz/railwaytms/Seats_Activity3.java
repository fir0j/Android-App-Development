package com.railway.firoz.railwaytms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Seats_Activity3 extends AppCompatActivity {

    private Button mbutton_next2;
    private String si3,di3;
    private String mtrain,mseats;
    private TextView mRandomcost;
    private String RandomNumber;
    private int max = 5000;
    private int min = 1000;
    public final void print(){
        Intent i = new Intent(this,print_acivity4.class);
        i.putExtra("si4",si3);
        i.putExtra("di4",di3);
        i.putExtra("seats3",mseats);
        i.putExtra("trains3",mtrain);
        i.putExtra("RNumber",RandomNumber);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_3);


        Spinner mspinner_train = (Spinner)findViewById(R.id.spinner_train);

        ArrayAdapter<CharSequence> tadapter = ArrayAdapter.createFromResource(this,R.array.Trains, android.R.layout.simple_spinner_item);
        tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner_train.setAdapter(tadapter);

        mspinner_train.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mtrain = parent.getItemAtPosition(position).toString();
                Random random = new Random();
                RandomNumber = "" + (random.nextInt(max-min)+min);
                Toast.makeText(getApplicationContext(),"RandomNumberGenerated is"+RandomNumber,Toast.LENGTH_SHORT).show();
                mRandomcost =(TextView)findViewById(R.id.Cost_amount);
                mRandomcost.setText("RS."+RandomNumber);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mspinner_seats = (Spinner)findViewById(R.id.spinner_seats);

        ArrayAdapter<CharSequence> sadapter = ArrayAdapter.createFromResource(this,R.array.Seats, android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner_seats.setAdapter(sadapter);

        mspinner_seats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mseats = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Intent i = getIntent();
        si3 = i.getExtras().getString("si2");
        di3 = i.getExtras().getString("di2");

        mbutton_next2 = (Button)findViewById(R.id.button_next2);
        mbutton_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print();
            }
        });
    }
}
