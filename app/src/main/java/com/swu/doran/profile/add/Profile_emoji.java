package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.swu.doran.R;

public class Profile_emoji extends AppCompatActivity {

    TextView select_emoji_btn;
    TextView next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_emoji);


        select_emoji_btn = findViewById(R.id.select_emoji_btn);
        select_emoji_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Profile_select_emoji.class);
                startActivity(intent);
            }
        });

        next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Profile_birthday.class);
                startActivity(intent);
            }
        });

    }
}