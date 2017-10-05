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

# Notification

```java


UtilNotification.sendNotification(MainActivity.this, android.R.mipmap.sym_def_app_icon, "Title", "Message", "Channel", MainActivity.class, 1);
            
UtilNotification.sendReplyNotification(MainActivity.this, android.R.mipmap.sym_def_app_icon, android.R.mipmap.sym_def_app_icon, "Reply", "Reply", "Title", "Message","Channel", MainActivity.class, 1);

UtilNotification.createNotificationChannel(MainActivity.this, "Channel", "Description", "Channel");

UtilNotification.createNotificationGroup(MainActivity.this, "group", "group_name");

UtilNotification.showSnackbar(v, "Hello", UtilNotification.Lengths.LONG, "World", new UtilNotification.SnackBarAction() {
                    @Override
                    public void snackClick(Snackbar snackbar) {
                        snackbar.dismiss();
                    }
                });
                
UtilNotification.showToast(MainActivity.this, "Hello", UtilNotification.Lengths.LONG);

UtilNotification.showMenu(MainActivity.this, v, R.menu.sample_menu, new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId()==R.id.hello) {
                            UtilNotification.showSnackbar(v, "Hello was pressed", UtilNotification.Lengths.LONG, "Cool!", new UtilNotification.SnackBarAction() {
                                @Override
                                public void snackClick(Snackbar snackbar) {
                                    snackbar.dismiss();
                                }
                            });
                            return true;
                        }

                        return false;
                    }
                });


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
	        compile 'com.github.jakepurple13:HelperUtils2:v0.3'
	}
```
