package com.londonappbrewery.bitcointicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    // Constants:
    // TODO: Create the base URL
    private final String BASE_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTC";

    // Member Variables:
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = (TextView) findViewById(R.id.priceLabel);
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // TODO: Set an OnItemSelected listener on the spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Bitcoin", "Nothing selected");

            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.d("Bitcoin", "" + parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(), "" + parent.getItemAtPosition(position) + " got selected", Toast.LENGTH_LONG).show();
                String finalurl = BASE_URL+parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), " Requesting: "+ finalurl, Toast.LENGTH_LONG).show();
                letsDoSomeNetworking(finalurl);


            }
        });

    }

    // TODO: complete the letsDoSomeNetworking() method
    private void letsDoSomeNetworking(String finalurl) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(finalurl, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(getApplicationContext(), "Requesting JSON", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Toast.makeText(getApplicationContext(), "Bitcoin JSON: " + response.toString(), Toast.LENGTH_SHORT).show();
                // now parsing JSON
                try {
                    String price = response.getString("last");
                    mPriceTextView.setText(price);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //JSON PARSING DONE
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("Bitcoin", "Request fail! Status code: " + statusCode);
                Log.d("Bitcoin", "Fail response: " + response);
                Log.e("ERROR", e.toString());

            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);

                Toast.makeText(getApplicationContext(), "Tried " + retryNo + "times.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


