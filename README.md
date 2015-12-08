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
