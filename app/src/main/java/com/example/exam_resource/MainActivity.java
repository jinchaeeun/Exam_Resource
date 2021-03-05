package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Member Variable ------------------------------------------------
    private final String TAG = "MainActivity"; //프르젝트 단위나 액티비티 이름, 상수 변수는 구분을 위해 거의 대문자로 작성하기로 규약함
    private LinearLayout linearLAY;
    private TextView     msgTXT;
    private TextView     msgETXT;
    //private LinearLayout linearLAY = findViewById(R.id.linearLAY); 이건 불가능함 선언과 동시에 X
    // private Random      random= new Random();  //이건 UI 요소와 상관 없으니까 가능함
    private Resources   appRes;
    //private Resources   appRes=this.getResources(); //xml res 자원 접근객체  레이아웃과 상관 없어서 이렇게도 가능

    //Member Method - AppCompatActivity's override --------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI 객체 변수 초기화
        linearLAY = findViewById(R.id.linearLAY);
        msgTXT = findViewById(R.id.msgTXT);
        msgETXT = findViewById(R.id.msgETXT);

        appRes = this.getResources();

    }

    // Member Method - xml onclick 처리 메서드 -------------------------
    public void onClick(View v){
        // 클릭한 UI 요소 객체가 인자 v에 담겨져 옴
        //레이아웃 객체와 텍스트 뷰 객체가 필요 - private로 멤버변수 선언
        if(v.getId()==R.id.linearLAY){
            // 전체 화면인 LinearLayout 클릭했을 경우 처리
            msgTXT.setTextColor(Color.BLUE);
            msgTXT.setTextSize(30);
            String curText = msgTXT.getText().toString(); //msgTXT에 현재 들은 값 getText()해서 가져옴. 단, CharSequence 타입이라 toString해줌
            //msgTXT.set으로 해서 설정할 수 있고 get해서 가져올 수 있음
            Log.i(TAG, "curTXT =>"+curText);

            //msgTXT.setText("Happy New Year");
            //클릭했을 때 editText에 있는 값을 msgTXT에도 있어야함
            String newmsg = msgETXT.getText().toString();
            //msgTXT.setText(newmsg);

            // 입력 여부에 따라서 TextView 출력
            if(newmsg.length()>0)
                msgTXT.setText(newmsg);
            else
                //msgTXT.setText("Nothing");
                //Java에서 resource 자원 데이터 사용
                //Resources 클래스 <-- getResources()
                msgTXT.setText(appRes.getString(R.string.nothing)); //하드코딩 안하고 xml에 있는 데이터를 쓸 수 있다.






        }

    }
}