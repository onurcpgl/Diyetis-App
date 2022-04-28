package com.example.diyetisproje;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class diyet10page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyet10page);
        openDialog();
    }
    private void openDialog() {
        ExampleDialoq exampleDialoq=new ExampleDialoq();
        exampleDialoq.show(getSupportFragmentManager(),"exapmle dialog");

    }
}