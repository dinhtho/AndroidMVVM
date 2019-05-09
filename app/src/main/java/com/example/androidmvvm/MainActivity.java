package com.example.androidmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidmvvm.viewmodel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView tvCount;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        tvCount = findViewById(R.id.tv_count);

        CounterViewModel counterViewModel = ViewModelProviders.of(this)
                .get(CounterViewModel.class);
        counterViewModel.getCounter().observe(this, count -> {
            tvCount.setText(String.valueOf(count.getCount()));
        });

        bt.setOnClickListener((v) -> {
            counterViewModel.onButtonClick();
        });

    }
}
