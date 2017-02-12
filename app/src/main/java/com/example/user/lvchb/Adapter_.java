package com.example.user.lvchb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 14.01.2017.
 */

public class Adapter_ extends ArrayAdapter<Lines_data> {
    private final Activity context;
    private  final ArrayList<Lines_data> data;
    //=new ArrayList<String>();

    public Adapter_(Activity context, ArrayList <Lines_data>data) {
        super(context, R.layout.row, data);
        this.context = context;
        this.data=data;


    }
    static class ViewHolder {

        public TextView names,time;
        public CheckBox chek;
        public EditText edit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder буферизирует оценку различных полей шаблона элемента
      //  View view = super.getView(position, convertView, parent);
        ViewHolder holder;

        // Очищает сущетсвующий шаблон, если параметр задан
        // Работает только если базовый шаблон для всех классов один и тот же
        View rowView = convertView;


        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.row, null, true);
            holder = new ViewHolder();
            holder.names = (TextView) rowView.findViewById(R.id.name);
            holder.time = (TextView) rowView.findViewById(R.id.time);
            holder.chek = (CheckBox) rowView.findViewById(R.id.checkbox);
            holder.edit = (EditText) rowView.findViewById(R.id.edSum);

            holder.names.setText(data.get(position).name);
            holder.time.setText(data.get(position).time);
            holder.edit.setText(String.valueOf(data.get(position).sum));
            holder.chek.setChecked(data.get(position).flag);


            return rowView;

        }

        return rowView;
    }


}
