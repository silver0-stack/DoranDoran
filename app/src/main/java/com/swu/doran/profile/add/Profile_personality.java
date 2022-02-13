package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.swu.doran.MainActivity;
import com.swu.doran.R;

public class Profile_personality extends AppCompatActivity implements OnClickListener {

    TextView next_btn;

    Button personality_btn_1;
    Button personality_btn_2;
    Button personality_btn_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_personality);

        next_btn=findViewById(R.id.next_btn);
        next_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        personality_btn_1=findViewById(R.id.personality_btn_1);
        personality_btn_1.setOnClickListener(this);
        personality_btn_2=findViewById(R.id.personality_btn_2);
        personality_btn_2.setOnClickListener(this);
        personality_btn_3=findViewById(R.id.personality_btn_3);
        personality_btn_3.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v){
        switch (v.getId()){
            case R.id.personality_btn_1:
                personality_btn_1.setSelected(true);
                break;
            case R.id.personality_btn_2:

                personality_btn_2.setSelected(true);
                break;
            case R.id.personality_btn_3:
              personality_btn_3.setSelected(true);
                break;
        }
    }
}