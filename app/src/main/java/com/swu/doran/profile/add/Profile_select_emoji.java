package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.swu.doran.R;
import com.swu.doran.profile.start.ProfileMenuActivity;

public class Profile_select_emoji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_select_emoji);


    }

    public void next(View view) {
        startActivity(new Intent(this, Profile_emoji.class));
    }

    public void back(View view) {
        super.onBackPressed();
    }
}