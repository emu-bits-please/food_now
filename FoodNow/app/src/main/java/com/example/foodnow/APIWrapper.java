package com.example.foodnow;

import android.os.AsyncTask;
import android.util.Log;

import com.example.foodnow.model.Item;
import com.example.foodnow.model.Menu;
import com.example.foodnow.model.MenuList;
import com.example.foodnow.model.MerchantList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by rwitting on 11/7/15.
 */
public class APIWrapper {
    //final static String host = "http://sandbox.delivery.com/";
    final static String host = "http://sandbox.delivery.com/";

    final static String GUEST_TOKEN = "Guest-Token";
    final static String AUTH_TOKEN = "Authorization";
    final static String GUEST_TOKEN_URL = "customer/auth/guest";
    final static String CUSTOMER_CART_URL = "customer/cart";
    final static String CHECKOUT_URL = "customer/cart";
    final static String CC_URL = "customer/cc";
    final static String AUTH_URL = "customer/auth";
    final static String LOCATION_URL = "customer/location/";
    final static String ORDER_URL = "customer/orders/recent";
    final static String SEARCH_URL = "merchant/search/delivery?";
    final static String SEARCH_ADDRESS = "1330 1st Ave, 10021";
    final static String ADDRESS_APT = "Apt 123";
    final static String CLIENT_ID = "OGM0ODA2Mjk2ZTVjYzA0ZGJjZWQxODg5YjY4ZjVjYzBl";
    final static String ORDER_TYPE = "delivery";

    OkHttpClient mClient = new OkHttpClient();

    public void doAPICALL(){
        new LongOperation().execute("");

    };

    public void getMerchants(){

    };

    private class LongOperation extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                try{
                    // Merchant Query
                    // host + SEARCH_URL + "address=704+Pearl+St,+48197" + "&client_id=" + CLIENT_ID

                    // MENU QUERY
                    // host + "merchant/" + "76345" +"/menu" + "?client_id=" + CLIENT_ID

                    String JSON = "";
                    // Query for a list of local merchants
                    URL url = new URL(host + SEARCH_URL + "address=704+Pearl+St,+48197" + "&client_id=" + CLIENT_ID);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    JSON = br.readLine();
                    // Convert JSON String to Merchant List
                    Gson gson =  new GsonBuilder().create();
                    MerchantList mList = gson.fromJson(JSON, MerchantList.class);

                    int randInt = (int)(mList.getMerchants().size() * Math.random());

                    String id = mList.getMerchants().get(randInt).getId();
                    Log.d("TEST", "TEST" + id);

                    // Query Selected Merchant for Menu

                    url = new URL(host + "merchant/" + id + "/menu" + "?client_id=" + CLIENT_ID);
                    Log.d("test",host + "merchant/" + id + "/menu" + "?client_id=" + CLIENT_ID);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    in = new BufferedInputStream(urlConnection.getInputStream());
                    br = new BufferedReader(new InputStreamReader(in));
                    JSON = br.readLine();
                    Log.d("tEsT", JSON);

                    // Parse Menu For Menu Children
                    MenuList menus = gson.fromJson(JSON, MenuList.class);

                    randInt = (int) (Math.random() * menus.getMenulist().size());
                    Menu selectedMenu = menus.getMenulist().get(randInt);

                    Log.d("testblah", selectedMenu.getId());

                    Item randomItem = selectedMenu.getRandomItem();
                    Log.d("item", randomItem.getName());

                    return "";
                }catch(Exception e){
                    Log.e("test",e.getMessage(),e);
                }
                return "";
            }

            @Override
            protected void onPostExecute(String result) {

            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onProgressUpdate(Void... values) {
            }
    }
}
