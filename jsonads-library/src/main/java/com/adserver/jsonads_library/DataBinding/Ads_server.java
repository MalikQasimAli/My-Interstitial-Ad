package com.adserver.jsonads_library.DataBinding;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Ads_server{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("link")
  @Expose
  private String link;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("pic")
  @Expose
  private String pic;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setLink(String link){
   this.link=link;
  }
  public String getLink(){
   return link;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
  public void setPic(String pic){
   this.pic=pic;
  }
  public String getPic(){
   return pic;
  }
}