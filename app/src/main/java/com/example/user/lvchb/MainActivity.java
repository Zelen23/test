package com.example.user.lvchb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.text.Layout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   Context context;
    String selectedWord;
    public static final int IDM_WRITE = 101;
    ArrayList<Lines_data>liner=new ArrayList<Lines_data>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        ListView list=(ListView)findViewById(R.id.list);

        registerForContextMenu(list);
        list.setOnCreateContextMenuListener(this);

        ArrayList<String> data= new ArrayList<>();

        data.add("07:00-10:00:00.  -  -  false");
        data.add("10:00:00.-11:00  Елена  -  false");
        data.add("11:00-12:00  екатерина сенина  500  true");
        data.add("12:00-13:00  -  -  false");
        data.add("13:00-14:00  Анна Зайцева  Руб  true");
        data.add("14:00-19:00  -  -  false");
        data.add("19:00-20:00  кондакова любовь  500  false");
        data.add("20:00-23:00  -  -  false");
        data.add("23:00-23:59  -  -  false");

        creat_line(data);
        Adapter MyAdapter_= new Adapter_(this,liner){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);


                return view;
            }
        };

        list.setAdapter((ListAdapter) MyAdapter_);
    }


    void creat_line(ArrayList data){
        int i=0;
        for(Object elt:data){
            String [] s=elt.toString().split("  ");
            boolean b= Boolean.parseBoolean(s[3]);
            liner.add(new Lines_data(s[0], s[1], 500, b));
            i++;

        Log.i("liner",liner.toString());
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(liner.get(info.position).time+"  "+liner.get(info.position).name);
            selectedWord = liner.get(info.position).time;
        if(liner.get(info.position).name.equals("-"))
            menu.add(menu.NONE, IDM_WRITE, menu.NONE, "Записать");


        }


    @Override
    public boolean onContextItemSelected(final MenuItem item) {

        switch (item.getItemId()) {

            case IDM_WRITE:
                // String s=item.getMenuInfo().toString();
                parse_time(selectedWord);

                break;



            default:
                return super.onContextItemSelected(item);

        }
        return true;
    }

  void parse_time(String time){
        String t1 = null;
        String t2 = null;

        if(time.length()!=0) {
            String[] parse = time.split("-");
            if (parse.length == 2) {
             // если времени 2
                t1 = parse[0];
                t2 = parse[1];

                Log.i("parse", t1 + "" + t2);

            }

        }
  }
}

