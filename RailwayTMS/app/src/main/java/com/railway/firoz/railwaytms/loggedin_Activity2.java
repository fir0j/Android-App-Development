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

public class loggedin_Activity2 extends AppCompatActivity {
    private Spinner Source_Spinner;
    private Spinner Destination_Spinner;
    private Button mbutton_next;
    String sourceItem;
    String destinationItem;
    TextView ticketFrom;
    TextView ticketTo;

    public final void seats(){
        Intent i = new Intent(getApplicationContext(),Seats_Activity3.class);
        i.putExtra("si2",sourceItem);
        i.putExtra("di2",destinationItem);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_loggedin);

        Source_Spinner = (Spinner)findViewById(R.id.spinner_source);
        ArrayAdapter<CharSequence> sadapter = ArrayAdapter.createFromResource(this,
                R.array.Sources, android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Source_Spinner.setAdapter(sadapter);

        Source_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                sourceItem = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(getApplicationContext(),"Item disappered",Toast.LENGTH_LONG).show();
            }
        });

        Destination_Spinner = (Spinner) findViewById(R.id.spinner_Destination);
        ArrayAdapter<CharSequence> dadapter = ArrayAdapter.createFromResource(this,
                R.array.Destination, android.R.layout.simple_spinner_item);
        dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Destination_Spinner.setAdapter(dadapter);

        Destination_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                destinationItem =parent.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       mbutton_next = (Button)findViewById(R.id.button_next);
       mbutton_next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               seats();
           }
       });

    }
}
