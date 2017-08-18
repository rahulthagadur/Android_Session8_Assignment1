package com.example.thagadur.android_session8_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    Button ascBtn;
    Button descBtn;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
   //1.Create an array
    String[] months={
            "January","February","March","April",
           "May","June","July","August","September",
           "October","November","December"
    };

    //2.create List view
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.Instialise with the respective ID of the Layout
        ascBtn=(Button)findViewById(R.id.asc_button);
        descBtn=(Button)findViewById(R.id.desc_button);
        listView=(ListView)findViewById(R.id.list_view);

        //4.Initialise Array adapter
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);

        //5.Link your adaapter to listView
        listView.setAdapter(adapter);

        //Logic for Ascending sort order
        ascBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //1.initialise arraylist with the array input taken
                list = new ArrayList<String>(Arrays.asList(months));

                //2.call sort function of arraylist super class Collections
                Collections.sort(list);

                //3.add the list to adapter
                adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);

                //4.Link your adaapter to listView
                listView.setAdapter(adapter);

                //5.notify the changes that has been made on the adapter
                adapter.notifyDataSetChanged();
            }
        });


        descBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //1.initialise arraylist with the array input taken
                list=new ArrayList<String>(Arrays.asList(months));

                //2.call sort function of arraylist super class Collections the second parameter is to sort in reverse order
                //(descending order)
                Collections.sort(list,Collections.<String>reverseOrder());

                //3.add the list to adapter
                adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);

                //4.Link your adaapter to listView
                listView.setAdapter(adapter);

                //5.notify the changes that has been made on the adapter
                adapter.notifyDataSetChanged();
            }
        });
    }
}
