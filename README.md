# FastPagerAndroid
Android widget to allow fast scrolling through large ViewPagers in Android.

![](https://raw.githubusercontent.com/dscottpi/FastPagerAndroid/master/art/example.gif)

## Installation


## Usage

Add the fastpager widget in your layout: 
```xml
<com.only5c.dscottpi.fastpager.Fastpager
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:id="@+id/fast_pager"
        android:layout_alignParentBottom="true">
</com.only5c.dscottpi.fastpager.Fastpager>
```

Instantiate FastPager and add your ViewPager to it: 
```java
  viewPager = (ViewPager) findViewById(R.id.viewPager);
  viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

  fastpager = (Fastpager) findViewById(R.id.fast_pager);
  fastpager.setSmoothScroll(true);
  fastpager.setViewPager(viewPager);
```

To hide/show the view simply call: 
```java
fastpager.toggleFade();
```
