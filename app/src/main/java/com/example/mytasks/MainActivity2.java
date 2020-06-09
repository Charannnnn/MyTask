package com.example.mytasks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText title,desc;
    Button btn;
    String titleStr,descStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title = (EditText) findViewById(R.id.title);
        desc = (EditText) findViewById(R.id.desc);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleStr = title.getText().toString();
                descStr = desc.getText().toString();
                addTask(titleStr,descStr);
                onBackPressed();
            }
        });
    }
    public void addTask(String title,String desc){
        LinearLayout newTask = new LinearLayout(this);
        newTask.setOrientation(LinearLayout.VERTICAL);
        final TextView tvTitle = new TextView(this);
        final TextView tvDesc = new TextView(this);
        CheckBox chk = new CheckBox(this);
        tvTitle.setText(title);
        tvDesc.setText(desc);
        tvTitle.setTextSize(18);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvTitle.setPaintFlags(tvTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    tvDesc.setPaintFlags(tvDesc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else{
                    tvTitle.setPaintFlags(tvTitle.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                    tvDesc.setPaintFlags(tvDesc.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
        newTask.addView(chk);
        newTask.addView(tvTitle);
        newTask.addView(tvDesc);
        MainActivity.list.addView(newTask);
    }
}