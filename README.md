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

* Crate Account on [JSONBIN]https://jsonbin.io/) 100% free JSON Bin website.
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
* pic: upload image on any server or use [imgur](http://www.imgur.com/) and paste direct link here.

```

