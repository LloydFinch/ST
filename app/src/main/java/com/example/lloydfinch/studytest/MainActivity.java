package com.example.lloydfinch.studytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) this.findViewById(R.id.button_click);
        button.setOnClickListener((v)->{
            Toast.makeText(this,"this is lambda expression",Toast.LENGTH_LONG).show();
        });
    }
}
