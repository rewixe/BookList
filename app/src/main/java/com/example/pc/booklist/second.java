//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

//class which display books in database with custom list adapter
public class second extends AppCompatActivity {

    //declare database instnc
    DBManager database;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sets database
        database = new DBManager(this);

        //Declare and set listView
        ListView books = (ListView)findViewById(R.id.listView);

        //Declares book template where values come from
        Book bookTemplate;

        //Declare array list for books
        ArrayList<Book> bookList = new ArrayList<>();

        //gets books from database, stores result set in cursor
        Cursor result = database.getBooks();

        //declares strings for insertion into list
        String bookName, bookAuthor, bookPages, bookID;

        //counts iterations through result set, gets position in bookList
        int i = 0;

        //iterates through result set
        while(result.moveToNext())
        {
            //gets values and stores in strings
            bookID = result.getString(0);
            bookName = result.getString(1);
            bookAuthor = result.getString(2);
            bookPages = result.getString(3);

            //bookTemplate values set to strings above
            bookTemplate = new Book(bookName, bookAuthor, bookPages, bookID);

            //bookTemplate with current values added to bookList
            bookList.add(i, bookTemplate);

            //iterate to next position in bookList
            i++;
        }

        //Create new custom adapter and set adapter
        BookListAdapter adapter = new BookListAdapter(this, R.layout.custom_adapter_layout, bookList);
        books.setAdapter(adapter);
    }
}
