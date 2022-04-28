package com.example.diyetisproje;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class diyet3page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyet3page);
        openDialog();
    }
    private void openDialog() {
        ExampleDialoq exampleDialoq=new ExampleDialoq();
        exampleDialoq.show(getSupportFragmentManager(),"exapmle dialog");

    }
}