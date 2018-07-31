package com.adserver.myads;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.adserver.jsonads_library.Ads_Server;

public class MainActivity extends AppCompatActivity implements Ads_Server.result_ads_Server {


    Ads_Server ads_server;
    ProgressDialog progressDialog;
    String link, secret_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(this);
        progressDialog.show();

        ads_server= new Ads_Server(this,this);


        ads_server.hit_server(link, secret_key);

    }

    @Override
    public void sucess() {
        Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
         ads_server.ready_resouce(0);


    }

    @Override
    public void failed() {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }



}
