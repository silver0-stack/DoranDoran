package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.swu.doran.R;

public class Profile_birthday extends AppCompatActivity {

    TextView next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_birthday);

        next_btn=findViewById(R.id.next_btn);
        next_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),Profile_personality.class);
            startActivity(intent);
        });
    }
}