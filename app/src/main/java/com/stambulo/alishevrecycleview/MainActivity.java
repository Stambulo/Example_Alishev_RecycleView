package com.stambulo.alishevrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private RecyclerView numbersList;                             // Создаем объект класса RecycleView
    private NumbersAdapter numbersAdapter;                        // Новый Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersList = findViewById(R.id.rv_numbers);              // Находим список

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);// this-контекст
        numbersList.setLayoutManager(layoutManager);              // Выбираем способ отображения.

        numbersList.setHasFixedSize(true);                        // Размер списка фиксированный

        numbersAdapter = new NumbersAdapter(100);   // Создаем, и передаем кол-во элементов
        numbersList.setAdapter(numbersAdapter);
    }
}
