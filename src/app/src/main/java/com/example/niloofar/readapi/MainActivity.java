 package com.example.niloofar.readapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAdd(View view){

        try{
            URL url = new URL(/*your url*/);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            InputStream stream=urlConnection.getInputStream();
            InputStreamReader reader=new InputStreamReader(stream);
            int data;
            String result="";
            data=reader.read();
            while (data!=-1){
                result+=(char)data;
                data=reader.read();

            }
            urlConnection.disconnect();
            Log.i("DATA",result);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }




     }

}
