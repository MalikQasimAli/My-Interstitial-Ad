package com.adserver.jsonads_library;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.adserver.jsonads_library.DataBinding.Ads_data;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Ads_Server
{
    Context context;
    result_ads_Server resultAdsServer;
    public static Ads_data adsData;

    public static String link_schdule= "https://api.jsonbin.io/b/5b601bcc2b23fb1f2b6a46e7/latest";


    Bitmap bitmap1,bitmap2,bitmap3;


    public Ads_Server(Context mContext,result_ads_Server resultAdsServer)
    {

        this.context=mContext;
        this.resultAdsServer=resultAdsServer;



    }

    public void hit_server()
    {

        get_data(link_schdule);

    }

    public boolean is_add_ready(int number)
    {

        if (number==0 && bitmap1!=null)
        {
            return  true;
        }
        if (number==1 && bitmap2!=null)
        {
            return  true;
        }
        if (number==2 && bitmap2!=null)
        {
            return  true;
        }

        return false;
    }


    public void ready_resouce(final int number)
    {
        Glide.with(context)
                .load(adsData.getAds_server().get(number).getPic())
                .asBitmap()
                .dontAnimate()
                //.placeholder(R.drawable.downloadingimg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                        if (number==0)
                        {
                            bitmap1=resource;
                            show_ad(0);
                         //   Log.e("Ready resource","ready");
                        }else if (number==1)
                        {
                            bitmap2=resource;
                        }else if (number==2)
                        {
                            bitmap3=resource;
                        }

                    }
                });
    }

    public void show_ad(int id)
    {

        final int ad_id=id;

        Bitmap bitmap=null;

        if (id==0)
        {
            if(bitmap1!=null)
            {
                bitmap=bitmap1;
            }else
            {
                return;
            }
        }else if (id==1)
        {
            if(bitmap2!=null)
            {
                bitmap=bitmap2;
            }else
            {
                return;
            }
        }
        else if (id==2)
        {
            if(bitmap3!=null)
            {
                bitmap=bitmap3;
            }else
            {
                return;
            }
        }

        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog settingsDialog = new Dialog(context);
        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(inflater.inflate(R.layout.ad_layout
                , null));
        settingsDialog.show();


        Button close_btn=(Button)settingsDialog.findViewById(R.id.close_btn_Ad);
        Button opene_btn=(Button)settingsDialog.findViewById(R.id.open_btn_ad);
        ImageView ad_img=(ImageView)settingsDialog.findViewById(R.id.ad_img);
        ImageView icon_delte=(ImageView)settingsDialog.findViewById(R.id.icon_delete);

        ad_img.setImageBitmap(bitmap);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                settingsDialog.dismiss();
            }
        });

        opene_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+adsData.getAds_server().get(ad_id).getLink())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+adsData.getAds_server().get(ad_id).getLink())));
                }
            }
        });

        icon_delte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsDialog.dismiss();
            }
        });



    }

    private void get_data(String Link) {
     //   prog.show();
       // prog.setCancelable(false);
        RequestQueue queue = Volley.newRequestQueue(context);



        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET,
                Link,

                null,
                new Response.Listener<JSONObject>() {
//                    JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, IHttpConstants.BASE_URL+"Product", null,
//                            new Response.Listener<JSONObject>()
//                            {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("BAWA TAG", response.toString());


                        Gson gson = new Gson();
                        String jsonOutput = response.toString();
                        Type listType = new TypeToken<Ads_data>() {
                        }.getType();
                        adsData = gson.fromJson(jsonOutput, listType);
                        resultAdsServer.sucess();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                resultAdsServer.failed();
             //   prog.dismiss();
            //    volleyView.response_failure(error);

            }
        }) {

            /**
             * Passing some request headers
             * */


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();

                headers.put("secret-key", "$2a$10$GlNnwJQyHue.TYBBkmxnd.KsVruNGM0XhGK1sHuU9dSip7U3oceAC");
                return headers;
            }


        };

        jsonObjReq.setTag("BAWA TAG error check");
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000,
                3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Adding request to request queue
        queue.add(jsonObjReq);
    }





    public interface result_ads_Server
    {
        public void sucess();
        public void failed();
    }

}
