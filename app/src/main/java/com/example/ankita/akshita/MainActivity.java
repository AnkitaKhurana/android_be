package com.example.ankita.akshita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//Libraries for Backend Connection

public class MainActivity extends AppCompatActivity {
    Button btn;
    List<NameValuePair> params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Main);
        btn = (Button)findViewById(R.id.enter);


        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                params = new ArrayList<NameValuePair>();
                Intent intent = getIntent();
                ServerRequest sr = new ServerRequest();

                JSONObject json = sr.getJSON("http://10.0.2.2:8080/",params);
                if(json != null){
                    try{
                         intent = new Intent(getApplicationContext(), LoginActivity.class);

                        startActivity(intent);


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
