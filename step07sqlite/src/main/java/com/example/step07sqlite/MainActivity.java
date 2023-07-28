package com.example.step07sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.step07sqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    DBHelper dbHelperl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /*
             DBHelper 객체를 생성해서 참조값을 필드에 저장하기
             name 은 DB 의 이름을 마음대로 정해서 전달하면 된다.
         */
        dbHelperl=new DBHelper(this, "MyDB.sqlite",
                null, 1);
    }
}