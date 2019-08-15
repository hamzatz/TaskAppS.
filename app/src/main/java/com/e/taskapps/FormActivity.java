package com.e.taskapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDesc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        if (getActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTitle= findViewById(R.id.editTitle);
        editDesc= findViewById(R.id.editDesc);
    }


    public void onClickSave(View view) {
        Task task =new Task();
        String title = editTitle.getText().toString().trim();
        String desc= editDesc.getText().toString().trim();
        task.setTitle(title);
        task.setDesc(desc);
        Intent intent = new Intent();
        intent.putExtra("task",task);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickCancel(View view) {
        finish();
    }
}
