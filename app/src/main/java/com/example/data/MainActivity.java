package com.example.data;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by willy on 16/12/12.
 */

 public class MainActivity extends AppCompatActivity {
     private Button login;
     private EditText user,password;
     private TextView enroll,forget;

    private ImageView imageView;
    private WaveView waveView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(user.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "输入名称密码不能为空", Toast.LENGTH_LONG).show();

                }
                else if (TextUtils.isEmpty(password.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "输入名称密码不能为空", Toast.LENGTH_LONG).show();
                } else {
                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(myIntent);
                }
            }
        });
        enroll=(TextView)findViewById(R.id.login_enroll);
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my = new Intent(MainActivity.this, EnrollActivity.class);
                startActivity(my);
            }
        });

        imageView = (ImageView) findViewById(R.id.image);
        waveView3 = (WaveView) findViewById(R.id.wave_view);

        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.BOTTOM|Gravity.CENTER;
        waveView3.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0,0,0,(int)y+2);
                imageView.setLayoutParams(lp);
            }
        });

        forget =(TextView)findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my = new Intent(MainActivity.this, FindActivity.class);
                startActivity(my);
            }
        });
    }

}
