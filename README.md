# MyStudyProject
安卓学习示例

---
获取屏幕高宽度：
DisplayMetrics metric = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(metric);
int width = metric.widthPixels;     // 屏幕宽度（像素）
int height = metric.heightPixels;   // 屏幕高度（像素）
float density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）

---
DisplayMetrics dm = context.getResources().getDisplayMetrics();
int width = dm.widthPixels;
int height = dm.heightPixels;


---
评分控件
<RatingBar
                android:id="@+id/rating_bar"
                style="?android:attr/ratingBarStyleSmall"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="3dp"
                android:isIndicator="true"
                android:numStars="5"
                android:progressDrawable="@drawable/score_rating_sel" />

ViewStudy Model
<?xml version="1.0" encoding="UTF-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android" >

    <item
        android:id="@android:id/background"
        android:drawable="@drawable/xing">
    </item>
    <item
        android:id="@android:id/secondaryProgress"
        android:drawable="@drawable/xing">
    </item>
    <item
        android:id="@android:id/progress"
        android:drawable="@drawable/xing_dj">
    </item>

</layer-list>

---
GC_FOR_ALLOC freed 6346K, 7% free , paused 143ms, total 143ms</br>
This is not an error, but an information that Garbage collector has run.

If you are seeing a lot of those, it might mean that you are making many allocations or have little memory. You should try to improve your program's memory performance.

There is a good source information about investigating RAM consumption in Android:

https://developer.android.com/tools/debugging/debugging-memory.html

There is also a document about general strategies for managing your memory consumption in Android:

http://developer.android.com/training/articles/memory.html

05-12 11:51:06.581: I/Choreographer(6837): Skipped 392 frames! The application may be doing too much work on its main thread.
Well, you are doing some heavy processing in your Activity thread. You need profile your application and probably move some code to a separate thread or to a service.
