//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Starting activity, i.e. Main page of application
public class MainActivity extends AppCompatActivity {

    //Declarations
    DBManager database;
    Button addBook, update, remove, gmaps, but1;

    //Handles opening of new activities when corresponding buttons are clicked
    public void init()
    {
        //Activity to display custom list, view books in database
        but1=(Button)findViewById(R.id.view);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent one = new Intent(MainActivity.this, second.class);
                startActivity(one);
            }
        });

        //Activity to remove book from database
        remove=(Button)findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two = new Intent(MainActivity.this, removalScreen.class);
                startActivity(two);
            }
        });

        //Activity to update books of database
        update=(Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent three = new Intent(MainActivity.this, updateScreen.class);
                startActivity(three);
            }
        });

        //Activity to add books to database
        addBook=(Button)findViewById(R.id.addBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent four = new Intent(MainActivity.this, addScreen.class);
                startActivity(four);
            }
        });

        //Activity to find library using google maps
        gmaps=(Button)findViewById(R.id.map);
        gmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmaps = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(gmaps);
            }
        });
    }


    //onCreate
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets database
        database = new DBManager(this);

        //Method init
        init();
    }
}
