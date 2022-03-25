package com.swu.doran.profile.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.swu.doran.R;
import com.swu.doran.profile.start.ProfileMenuActivity;

public class Profile_birthday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_birthday);
    }

    public void back(View view) {
        super.onBackPressed();
    }

    //프로필 설정 완료 버튼
    public void complete(View view) {
        startActivity(new Intent(this, ProfileMenuActivity.class));
    }
}