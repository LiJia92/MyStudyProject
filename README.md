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
   android:progressDrawable="@drawable/score_rating_sel" /> <br>

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