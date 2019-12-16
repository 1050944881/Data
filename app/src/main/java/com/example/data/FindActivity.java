package com.example.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FindActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);
        Button button =(Button)findViewById(R.id.find_t);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FindActivity.this, MainActivity.class);
                startActivity(myIntent);
                Toast.makeText(FindActivity.this, "提交成功，返回登录界面", Toast.LENGTH_LONG).show();
            }
        });
        ImageView imageView = (ImageView)findViewById(R.id.find_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FindActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
