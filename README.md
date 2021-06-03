# Balanced
Library Availbale at JitPack.io

[![](https://jitpack.io/v/00sanoj00/Balanced.svg)](https://jitpack.io/#00sanoj00/Balanced)

😍⭐⭐  Easy way to Encrypt/Decrypt string in Android.😍⭐⭐

[<img src="/device-2021-06-04-000507.png"
width="300"
    hspace="10" vspace="10">](/readme/Wallabag%20Reading%20List.png)
    
## Installation


Add jitpack in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
```
Step 2. Add the dependency

```
	dependencies {
	
	         implementation 'com.github.00sanoj00:Balanced:1.0'
	}
```

## How to use
How to `Encrypt String`

```java
import com.sanoj.balanced.encript.decript.BED;

String mEncriptext = BED.encryptToBase64String("My String","mykey");

///example
String mEncriptext = BED.encryptToBase64String("Hi How Are You","12345");
```
How to `Decrypt String`
```java
import com.sanoj.balanced.encript.decript.BED;

String mDecrypt = BED.decryptBase64StringToString("My decrypt String ","mykey");

///example
String mDecrypt = BED.decryptBase64StringToString("5iKauOrKFRS1/9xQVi/icmUhAEmGSHGqxmv3YsOVYZ2nZgtnBwjF9+SmkPX3RYLcijcXdQ== ","12345");
```
