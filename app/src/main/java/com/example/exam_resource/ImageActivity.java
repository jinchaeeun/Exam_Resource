package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {
    
    //Member Variable --------------------------------
    private ImageView   skyIMG;
    private Resources   appRes;
    private int[]       imgResIds = {R.drawable.purplesky,R.drawable.tulip};
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면 설정
        setContentView(R.layout.image_layout);
        
        //UI 객체 가져오기
        skyIMG = findViewById(R.id.skyIMG);

        // res 폴더의 xml 자원 접근 객체
        appRes = this.getResources();
    }

    // XML's BTNClick Method -------------------------------
    public void BTNClick(View v){
        //클릭할 때마다 ImageView Image 변경
        skyIMG.setImageResource(imgResIds[count]);
        //skyIMG.setImageResource(appRes.getDrawble(imgResIds[count]));
        //count= (count == (imgResIds.length -1)) ? 0: count++;
        if(count == (imgResIds.length-1)) //imgResIds.length는 0,1 --> 2가 나옴.
            count = 0;
        else
            count++;
    }
}