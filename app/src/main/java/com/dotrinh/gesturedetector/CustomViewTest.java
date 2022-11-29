/*
 * Created by dotrinh on 13:20, 11/11/2022
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.gesturedetector;


import static com.dotrinh.gesturedetector.tool.LogUtil.LogI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.dotrinh.gesturedetector.tool.Tool;

public class CustomViewTest extends View {

    TextPaint textPaint;
    static Paint RECT_PAINT;
    static Paint LINE_PAINT;
    Rect textBounds;
    //    private String textStr = "あえおaby";
    private String textStr = "あいえお\n高田様";

    public CustomViewTest(Context context) {
        super(context);
        initialize(context);
    }

    public CustomViewTest(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    public CustomViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        RECT_PAINT = new Paint();
        RECT_PAINT.setStrokeWidth(1);
        RECT_PAINT.setColor(Color.BLUE);
        RECT_PAINT.setStyle(Paint.Style.STROKE);
        RECT_PAINT.setAntiAlias(true);

        textBounds = new Rect();
        textPaint = new TextPaint();
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(Tool.convertSpToPx(getContext(), 30));
        textPaint.setAntiAlias(true);
        gestureDetector = new GestureDetector(context, new MyGestureListener());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //--------------------------- TEST DOUBLE CLICK
    GestureDetector gestureDetector;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            LogI("Double Tap at: (" + x + "," + y + ")");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            LogI("onLongPress at: (" + x + "," + y + ")");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            LogI("onScroll 11: (" + e1.getX() + ", " + e1.getY() + ")");
            LogI("onScroll 22: (" + e2.getX() + ", " + e2.getY() + ")");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            LogI("onFling 11: (" + e1.getX() + ", " + e1.getY() + ")");
            LogI("onFling 22: (" + e2.getX() + ", " + e2.getY() + ")");
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}