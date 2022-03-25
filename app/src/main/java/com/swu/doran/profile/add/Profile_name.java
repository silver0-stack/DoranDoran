package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.swu.doran.R;

public class Profile_name extends AppCompatActivity {

    TextView next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_name);

    }

    public void back(View view) {
        super.onBackPressed();
    }

    public void next(View view) {
        startActivity(new Intent(this, Profile_emoji.class));
    }
}