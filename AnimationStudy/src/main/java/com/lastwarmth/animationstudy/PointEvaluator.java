package com.lastwarmth.animationstudy;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2015/11/5.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        Point startPoint = startValue;
        Point endPoint = endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
