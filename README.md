# HelperUtils2

A helper utility class for logging and anything else that I can think of.

[![](https://jitpack.io/v/jakepurple13/HelperUtils2.svg)](https://jitpack.io/#jakepurple13/HelperUtils2)
https://jitpack.io/#jakepurple13/HelperUtils2

# **Logging**

```java
UtilLog.d("Hello");
UtilLog.e("Hello");
UtilLog.w("Hello");
UtilLog.e("Hello");
UtilLog.v("Hello");

UtilLog.d("Hello", "World");
UtilLog.e("Hello", "World");
UtilLog.w("Hello", "World");
UtilLog.e("Hello", "World");
UtilLog.v("Hello", "World");
```


Add
```xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```xml
  	dependencies {
	        compile 'com.github.jakepurple13:HelperUtils2:v0.1'
	}
```
