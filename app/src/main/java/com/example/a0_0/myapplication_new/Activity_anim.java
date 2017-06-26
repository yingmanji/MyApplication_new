package com.example.a0_0.myapplication_new;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_anim extends Activity {
    private ImageView img_tv;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        img_tv=(ImageView)findViewById(R.id.img_tv);
        tv=(TextView)findViewById(R.id.tv);
    }
    public void start(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_alpha:
                Animation animationAlpha= AnimationUtils.loadAnimation(this,R.anim.alpha_animation);
                img_tv.setAnimation(animationAlpha);
                img_tv.startAnimation(animationAlpha);
                break;
            case R.id.btn_scale:
                Animation animationScale= AnimationUtils.loadAnimation(this,R.anim.scale_animation);
                img_tv.setAnimation(animationScale);
                img_tv.startAnimation(animationScale);
                break;
            case R.id.btn_rotate:
                Animation animationRotate= AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
                img_tv.setAnimation(animationRotate);
                img_tv.startAnimation(animationRotate);
                break;
            case R.id.btn_trans:
                Animation animationTrans= AnimationUtils.loadAnimation(this,R.anim.trans_animation);
                img_tv.setAnimation(animationTrans);
                img_tv.startAnimation(animationTrans);
                break;
            case R.id.btn_change:
                //设置TextView颜色变化，后面的8位数字代表rgb颜色
                ObjectAnimator animator=ObjectAnimator.ofInt(tv,"BackgroundColor",0xaabbccdd,0x11bbaadd,0x22bbccaa,0xaa33ccbb,0x11223344,0x22bbdd44,0x7788aadd);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setDuration(1000);//设置动画时间1秒,1000ms
                animator.start();
                break;
            default:
                break;
        }
    }
}
