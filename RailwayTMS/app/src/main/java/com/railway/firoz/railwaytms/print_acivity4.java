package com.railway.firoz.railwaytms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class print_acivity4 extends AppCompatActivity {

    private Button mprintTicket,book_button;
    private String si4,di4;
    private String trains4,seats4;
    private EditText mpay;
    private String paid_amount,RandomNum;
    private TextView ticketStatus;

    public void getTicket(){
        Intent i = new Intent(this,GetTicket_Activity6.class);
        i.putExtra("si4",si4);
        i.putExtra("di4",di4);
        i.putExtra("trains4",trains4);
        i.putExtra("seats4",seats4);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_print);


        Intent i = getIntent();
        si4 = i.getExtras().getString("si4");
        di4 = i.getExtras().getString("di4");
        trains4 = i.getExtras().getString("trains3");
        seats4 = i.getExtras().getString("seats3");
        RandomNum = i.getExtras().getString("RNumber");



        book_button = (Button)findViewById(R.id.book_button);
        book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpay = (EditText)findViewById(R.id.pay);
                paid_amount = mpay.getText().toString().trim();
                ticketStatus = (TextView)findViewById(R.id.ticked_booked);
                if(paid_amount.equalsIgnoreCase(RandomNum)){
                    ticketStatus.setText(R.string.book_success);
                }else{
                    ticketStatus.setText(R.string.book_fail);
                }

            }
        });
        mprintTicket = findViewById(R.id.button_print);
        mprintTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTicket();
            }
        });
    }
}
