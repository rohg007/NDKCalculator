package com.rohg007.android.jniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView resTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        EditText xEdt = findViewById(R.id.x_edt);
        EditText yEdt = findViewById(R.id.y_edt);
        Button addBtn = findViewById(R.id.add_btn);
        Button subBtn = findViewById(R.id.sub_btn);
        Button mulBtn = findViewById(R.id.mul_btn);
        Button divBtn = findViewById(R.id.div_btn);
        resTv = findViewById(R.id.res_tv);

        addBtn.setOnClickListener(view -> {
            printResult(add(Integer.parseInt(xEdt.getText().toString()), Integer.parseInt(yEdt.getText().toString())));
        });

        subBtn.setOnClickListener(view -> {
            printResult(sub(Integer.parseInt(xEdt.getText().toString()), Integer.parseInt(yEdt.getText().toString())));
        });

        mulBtn.setOnClickListener(view -> {
            printResult(mul(Integer.parseInt(xEdt.getText().toString()), Integer.parseInt(yEdt.getText().toString())));
        });

        divBtn.setOnClickListener(view -> {
            printResult(div(Integer.parseInt(xEdt.getText().toString()), Integer.parseInt(yEdt.getText().toString())));
        });
    }

    @SuppressLint("SetTextI18n")
    void printResult(int a){
        resTv.setText(Integer.toString(a));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int add(int x, int y);
    public native int sub(int x, int y);
    public native int mul(int x, int y);
    public native int div(int x, int y);
}