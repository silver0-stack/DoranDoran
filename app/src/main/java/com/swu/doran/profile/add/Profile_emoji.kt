package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.swu.doran.R;

public class Profile_emoji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_emoji);


    }

    public void next(View view) {
        startActivity(new Intent(this, Profile_birthday.class));
    }

    public void back(View view) {
        super.onBackPressed();
    }

    //프사 선택
    public void selectImg(View view) {
        startActivity(new Intent(this, Profile_select_emoji.class));
    }
}