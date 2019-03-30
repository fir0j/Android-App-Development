package com.railway.firoz.railwaytms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GetTicket_Activity6 extends AppCompatActivity {

    String SourceItemPassed;
    String DestinationItemPassed;
    TextView userid;
    TextView seats;
    TextView ticketFrom;
    TextView ticktetTo;
    String mtrainid,mseatno;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ticket_6);

            Intent i = getIntent();

           SourceItemPassed = i.getExtras().getString("si4"); //ProblemLine2 receiving null
           DestinationItemPassed = i.getExtras().getString("di4");
           mtrainid = i.getExtras().getString("trains4");
           mseatno = i.getExtras().getString("seats4");

         userid = (TextView)findViewById(R.id.ticket_TID);
         userid.setText(mtrainid);

         seats = (TextView)findViewById(R.id.ticket_Seatno);
         seats.setText(mseatno);

        ticketFrom = (TextView)findViewById(R.id.ticket_From);
        ticketFrom.setText(SourceItemPassed);

        ticktetTo = (TextView)findViewById(R.id.ticket_To);
        ticktetTo.setText(DestinationItemPassed);

        //Toast.makeText(getApplicationContext(),"Receiving:"+SourceItemPassed,Toast.LENGTH_SHORT).show();
    }
}
