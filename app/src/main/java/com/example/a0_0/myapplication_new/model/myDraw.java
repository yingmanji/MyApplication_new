package com.example.a0_0.myapplication_new.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 樱满集0_0 on 2017/5/27.
 */

public class myDraw extends View{

    public myDraw(Context context) {
        super(context);
    }

    public myDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);//设置笔的大小

        //画点
        //canvas.drawPoint(10,20,paint);
        //canvas.drawPoints(new float[]{100,100,200,200,300,300,400,400,500,500,600,600},paint);
        //canvas.drawPoints(new float[]{100,100,200,200,300,300,400,400,500,500},4,4,paint);
        //第一个4,忽略掉前4个数据（两个点）100 100 200 200
        //第二个4,绘制实际的数据个数（两个点）300 300 400 400
        //绘制实线
        //canvas.drawLine(100,100,200,200,paint);
        //canvas.drawLines(new float[]{100,100,200,200,300,300,400,400},paint);
        //canvas.drawLines(new float[]{100,100,200,200,300,300,400,400,500,500,600,600},2,5,paint);
        //第一个2忽略前两个数据
        //第二8提取8个数据绘制直线(不一定)
        //绘制矩形
        //canvas.drawRect(100,200,300,400,paint);
        //左上右下
        //RectF rectF=new RectF(200,300,400,500);
        //canvas.drawRect(rectF,paint);
        //Rect rect=new Rect(10,20,30,40);
        //canvas.drawRect(rect,paint);
        //绘制文本
        //paint.setTextSize(120);
        //canvas.drawText("2333",100,200,paint);
        //canvas.drawText("这是一行文字",100,200,paint);
        //canvas.drawText("这是一行文字",100,200,300,400,paint);会报错
        //绘制文本路径
        Path path=new Path();
        path.addCircle(100,200,60,Path.Direction.CW);//cw代表顺时针
        canvas.drawTextOnPath("这是另一行文字这是另一行文字这是另一行文字这是另一行文字这是另一行文字",path,0,0,paint);
        //水平方向的偏移量,垂直方向的偏移量,有正负偏移
        invalidate();//重新描绘
        super.onDraw(canvas);
    }
}
