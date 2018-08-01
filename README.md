<img src="https://i.imgur.com/GtSC7gi.jpg" alt="My Interstitial Ad"/>

## Getting Started

### Prerequisites

Add it in your root build.gradle at the end of repositories:

```
Step 1 : 

Add it in your root build.gradle at the end of repositories:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```  


```  
Step 2 :

dependencies {
	       implementation 'com.github.MalikQasimAli:My-Interstitial-Ad:1.0.1'
	}
  
  ```
### Server Setup  

  ```
Step 1 :

* Crate Account on https://jsonbin.io/ 100% free JSON Bin website.
```

 ```
Step 2 :

* Create new bin and paste following JSON object
{
  "ads_server": [
    {
      "id": "1",
      "name": "ad1",
      "link": "com.freebestphotoapps.pakistanindepedenceday.august14",
      "pic": "https://i.imgur.com/82pv4S3.jpg"
    },
    {
      "id": "2",
      "name": "ad2",
      "link": "com.freebestphotoapps.pakistanindepedenceday.august14",
      "pic": "https://i.imgur.com/82pv4S3.jpg"
    },
    {
      "id": "3",
      "name": "ad3",
      "link": "com.freebestphotoapps.pakistanindepedenceday.august14",
      "pic": "https://i.imgur.com/82pv4S3.jpg"
    }
  ]
}

* Currently it support only 3 ads. 
* Link: paste your app package name
* pic: upload image on any server or use http://www.imgur.com/ and paste direct link here.


```
### Important Note :
```
* Get your secret key https://jsonbin.io/api-keys
* Copy Bin id. 
```

### Use of Library

```
implements Ads_Server.result_ads_Server in your activity.

 Ads_Server ads_server= new Ads_Server(this,this);
 ads_server.hit_server(BinID, secret_key);

```

#### Response

check if request sucessfuly executed.

```
  @Override
    public void sucess() {
       
    }
    
 ```
 Ready your resource 
 
 ```
  ads_server.ready_resouce(number);
   
   number can be 0 or 1 or 2 only because we have 3 ads.
 
 ```
 
 ```
 Check of ad is ready and show it.
 
 if(ads_server.ready_resource(number))
 {
   show_ad(number)
 }
 
 ```
 
 This is it. This is first release and my first library please give me your suggestions.
 
 
 ## TO DO LIST
 
 ```
 * Make it more dynamic instead of creating 3 ads. 
 
 ```
