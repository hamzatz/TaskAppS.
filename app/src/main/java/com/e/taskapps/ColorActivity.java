package com.e.taskapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

    }

    public void OnClick(View view) {
        Intent intent= new Intent();
        switch (view.getId()){
            case R.id.colorRed:
                intent.putExtra("color",R.color.colorRed);
                break;

            case R.id.colorYellow:
                intent.putExtra("color",R.color.colorYellow);
                break;

            case R.id.colorBlue:
                intent.putExtra("color",R.color.colorBlue);
                break;

            case R.id.colorGreen:
                intent.putExtra("color",R.color.colorGreen);
                break;

        }
        setResult(RESULT_OK,intent);
        finish();
    }
}
