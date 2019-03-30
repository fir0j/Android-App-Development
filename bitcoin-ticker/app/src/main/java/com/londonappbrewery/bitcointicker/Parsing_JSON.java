package com.londonappbrewery.bitcointicker;

import org.json.JSONException;
import org.json.JSONObject;

// This is another method of parsing JSON Which has not been used in Am I rich? app.
//Now parsing the JSON RESPONSE
public class Parsing_JSON{

    public String btcprice;

    public  static Parsing_JSON fromJson(JSONObject jsonObject){

        try{
            Parsing_JSON p = new Parsing_JSON();
            p.btcprice = jsonObject.getString("last");
            return p;

        }catch(JSONException e){

            e.printStackTrace();
            return null;
        }

    }

    public String getBtcprice() {
        return btcprice;
    }
}