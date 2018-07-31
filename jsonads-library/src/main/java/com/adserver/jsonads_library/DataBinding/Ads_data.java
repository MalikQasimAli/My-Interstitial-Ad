package com.adserver.jsonads_library.DataBinding;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Ads_data {
  @SerializedName("ads_server")
  @Expose
  private List<Ads_server> ads_server;
  public void setAds_server(List<Ads_server> ads_server){
   this.ads_server=ads_server;
  }
  public List<Ads_server> getAds_server(){
   return ads_server;
  }
}