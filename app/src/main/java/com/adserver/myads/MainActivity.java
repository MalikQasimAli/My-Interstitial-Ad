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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(this);
        progressDialog.show();

        ads_server= new Ads_Server(this,this);
        ads_server.hit_server();

    }

    @Override
    public void sucess() {
        Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();


    /*    Dialog settingsDialog = new Dialog(this);
        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(getLayoutInflater().inflate(com.adserver.jsonads_library.R.layout.ad_layout
                , null));
        settingsDialog.show();*/
    //ads_server.show_ad(0);

     ads_server.ready_resouce(0);




    }

    @Override
    public void failed() {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }



}
