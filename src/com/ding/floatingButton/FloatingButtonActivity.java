package com.ding.floatingButton;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;

public class FloatingButtonActivity extends Activity {
    private ImageButton mImage1,mImage2,mImage3;
    private int mImage1Height,mImage2Height,mImage3Height;
    SparseArray sparseArray=new SparseArray<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mImage1=getViewById(R.id.fa_action_view);
        mImage2=getViewById(R.id.fa_action_view1);
        mImage3=getViewById(R.id.fa_action_view2);
        mImage1Height=mImage1.getTop();
        mImage2Height=mImage2.getTop();
        mImage3Height=mImage3.getTop();
        mImage2.setVisibility(View.GONE);
        mImage3.setVisibility(View.GONE);
        mImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mImage2.getVisibility()==View.GONE) {

                    openAnimation();
                    mImage2.setVisibility(View.VISIBLE);
                    mImage3.setVisibility(View.VISIBLE);
                }else{
                    closeAnimation();
                    mImage2.setVisibility(View.GONE);
                    mImage3.setVisibility(View.GONE);
                }
//                Toast.makeText(view.getContext(), "aaaa", Toast.LENGTH_LONG).show();
            }
        });


    }
    private void openAnimation(){
//        Animation translateAnimation2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_animation);
//        TranslateAnimation translateAnimation2=(TranslateAnimation)getResources().getAnimation(R.anim.down_animation);
//        TranslateAnimation translateAnimation2=new TranslateAnimation(0f,0f,-178,0f);
        TranslateAnimation translateAnimation2=new TranslateAnimation(0f,0f,178,0f);
        translateAnimation2.setDuration(200);
//        translateAnimation2.setFillAfter(true);
        translateAnimation2.setInterpolator(new OvershootInterpolator(2f));



//        TranslateAnimation translateAnimation3=new TranslateAnimation(0f,0f,-356,0f);
        TranslateAnimation translateAnimation3=new TranslateAnimation(0f,0f,356,0f);
        translateAnimation3.setDuration(200);
//        translateAnimation3.setFillAfter(true);
        translateAnimation3.setInterpolator(new OvershootInterpolator(2f));

        mImage2.setAnimation(translateAnimation2);
        mImage3.setAnimation(translateAnimation3);

        mImage2.startAnimation(translateAnimation2);
        mImage3.startAnimation(translateAnimation3);




    }
    private void closeAnimation(){
//         TranslateAnimation translateAnimation2=new TranslateAnimation(0f,0f,0f,-178f);
         TranslateAnimation translateAnimation2=new TranslateAnimation(0f,0f,0f,178f);
        translateAnimation2.setDuration(200);

//        TranslateAnimation translateAnimation3=new TranslateAnimation(0f,0f,0f,-356f);
        TranslateAnimation translateAnimation3=new TranslateAnimation(0f,0f,0f,356f);
        translateAnimation3.setDuration(200);

        mImage2.setAnimation(translateAnimation2);
        mImage3.setAnimation(translateAnimation3);

        mImage2.startAnimation(translateAnimation2);
        mImage3.startAnimation(translateAnimation3);



    }
    private <T extends View>T getViewById(int rId){
        View view=(View)sparseArray.get(rId);
        if(view!=null){
            return (T)view;
        }else{
            view=findViewById(rId);
            sparseArray.put(rId,view);
        }
        return (T)view;
    }



}
