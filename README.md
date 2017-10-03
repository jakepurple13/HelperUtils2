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
## Output
```
10-03 13:44:07.922 27061-27061/programmer.box.helperutils D/Line_18: Hello	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:18)

10-03 13:44:07.922 27061-27061/programmer.box.helperutils E/Line_19: Hello	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:19)

10-03 13:44:07.923 27061-27061/programmer.box.helperutils W/Line_20: Hello	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:20)

10-03 13:44:07.923 27061-27061/programmer.box.helperutils E/Line_21: Hello	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:21)

10-03 13:44:07.923 27061-27061/programmer.box.helperutils V/Line_22: Hello	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:22)

10-03 13:44:07.923 27061-27061/programmer.box.helperutils D/Hello: World	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:24)

10-03 13:44:07.923 27061-27061/programmer.box.helperutils E/Hello: World	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:25)

10-03 13:44:07.924 27061-27061/programmer.box.helperutils W/Hello: World	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:26)

10-03 13:44:07.924 27061-27061/programmer.box.helperutils E/Hello: World	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:27)

10-03 13:44:07.924 27061-27061/programmer.box.helperutils V/Hello: World	at programmer.box.helperutils.MainActivity.onCreate(MainActivity.java:28)

```


# Add to project

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
