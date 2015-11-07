1、inflate时，若传入的root为null，则后面一定会调用addView（否则inflate产生的view没有绑定到任何UI上，也就没什么用了），当传入的root为null时，inflate获得的view的layout属性失效。<br>
   若传入的root不为null，当attachToRoot为true时，infalte获得的view直接成为了root的子元素，即view有父布局，所以layout属性有效。<br>
   当attachToRoot为false时，inflate获得的view，它会绑定xml中定义的layout属性。后面当addView的时候，若不传入另外的LayoutParams属性，则会使用之前绑定的xml属性。
   总结：只要infalte传入的root不为null，则后面进行addView操作之后，xml中定义的layout属性就会有效。
2、