package com.stambulo.alishevrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;        // Счетчик id
    private int numberItems;                   // Здесь будем зранить количество элементов

    public NumbersAdapter(int numberOfItems){  // Конструктор класса адаптера
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // ViewGroup - это и есть RecycleView
        Context context = parent.getContext();               // Получаем context RecycleView
        int layoutIdForListItem = R.layout.number_list_item; // Получаем id layout элемента

        // LayoutInflater создает новый Java объект из xml файла
        LayoutInflater inflater = LayoutInflater.from(context); // Для этого мы получали context

        // Новый элемент списка
        // Передаем id элемента и родителя, false-не помещать внутрь родителя
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        // передаем view конструктору
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        // Статическая переменная в id элемента
        viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position); // У существующего элемента списка, меняем значение
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder{

        TextView listItemNumberView;   // Элемент списка
        TextView viewHolderIndex;      // id ViewHolder`a

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.rv_number_item);    // Генерируем Java объект
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);// Генерируем Java объект
            // findViewById - дорогая операция. Выполняется толко один раз.
        }

        void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex)); // Передаем элементу текст
        }
    }
}
