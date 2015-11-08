package com.example.foodnow;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;

import com.example.foodnow.model.MegaMenuType;
import com.example.foodnow.model.Menu;
import com.example.foodnow.model.MenuList;
import com.example.foodnow.model.Merchant;
import com.example.foodnow.model.MerchantList;
import com.example.foodnow.model.Randomizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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

    private String merchantName;
    private String foodItemName;
    private String foodPrice;
    private String address;

    OkHttpClient mClient = new OkHttpClient();
    private FloatingActionButton infoButton;

    public void doAPICALL(FloatingActionButton infoButton){
        this.infoButton = infoButton;
        new LongOperation().execute("");

    };

    public void getMerchants(){

    };

    public String getMerchantName() {
        return merchantName;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

                    List<Merchant> merchantsWeGot = mList.getMerchants();
                    int randInt = (int)(merchantsWeGot.size() * Math.random());

                    String id;
                    int numberOfMenus;
                    MenuList menus;
                    Merchant merchant;
                    do {
                        merchant = merchantsWeGot.get(Randomizer.getRandomIntegerInclusive(0, merchantsWeGot.size() - 1));
                        id = merchant.getId();

                        // Query Selected Merchant for Menu

                        url = new URL(host + "merchant/" + id + "/menu" + "?client_id=" + CLIENT_ID);
                        Log.d("test", host + "merchant/" + id + "/menu" + "?client_id=" + CLIENT_ID);
                        urlConnection = (HttpURLConnection) url.openConnection();

                        in = new BufferedInputStream(urlConnection.getInputStream());
                        br = new BufferedReader(new InputStreamReader(in));
                        JSON = br.readLine();

                        // Parse Menu For Menu Children
                        menus = gson.fromJson(JSON, MenuList.class);
                        numberOfMenus = menus.getMenulist().size();
                    } while (numberOfMenus <= 1);

                    randInt = (int) (Math.random() * menus.getMenulist().size());
                    Menu selectedMenu = menus.getMenulist().get(randInt);

                    MegaMenuType randomItem = selectedMenu.getRandomItem();
                    APIWrapper.this.foodItemName = randomItem.getName();
                    APIWrapper.this.merchantName = merchant.getName();
                    APIWrapper.this.foodPrice = String.format("$%.2f", randomItem.getPrice());
                    APIWrapper.this.address = merchant.getAddress();

                    return "";
                }catch(Exception e){
                    Log.e("test",e.getMessage(),e);
                }
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                infoButton.setEnabled(true);
                infoButton.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onProgressUpdate(Void... values) {
            }
    }
}
