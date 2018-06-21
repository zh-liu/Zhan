package com.jsecode.zhan.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jsecode.zhan.R;


/**
 * Created by liuzhenghao on 2018/6/6.
 */

public class PhoneView extends RelativeLayout implements View.OnClickListener{

    public EditText phoneEdit;

    public Button   codeBtn;

    public int time = 10;

    public Handler handler = new Handler();




    public PhoneView(Context context) {
        super(context);
    }

    public PhoneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        LayoutInflater.from(context).inflate(R.layout.activity_phone, this);

        initView();
    }

    public void initView(){
       phoneEdit = findViewById(R.id.edit_code);

       codeBtn = findViewById(R.id.btn_get);
        codeBtn.setOnClickListener(this);
   }


    public  Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time>0){
                codeBtn.setText("重新获取("+time+")");

                handler.postDelayed(myRunnable,1000);

            }else{
                time = 10;
                codeBtn.setText("获取验证码");
                codeBtn.setEnabled(true);

            }

              }
          };


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_get){
            codeBtn.setEnabled(false);
            handler.postDelayed(myRunnable,100);

            //postHttp();
        }
    }


    public String getPhoneText(){
      return   phoneEdit.getText().toString();
    }

}
