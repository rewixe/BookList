//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

//Custom list adapter for book objects
class BookListAdapter extends ArrayAdapter<Book> {

    //Declarations
    private Context cntxt;
    //TextViews to display different items
    TextView displayName, displayAuthor, displayPages, displayID;
    int res;

    //Adapter for books
    BookListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Book> objects)
    {
        super(context, resource, objects);
        cntxt = context;
        res = resource;
    }

    //Putting values from database into custom adapter
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent)
    {
        //Getting values from database to be inserted into list
        String name = getItem(position).getName();
        String author = getItem(position).getAuthor();
        String pages = getItem(position).getPages();
        String ID = getItem(position).getID();

        //Template book, values inserted into book, then book inserted into list,
        //then new values inserted into book, then book inserted
        //into list, and so on for all values in database
        Book book = new Book(name, author, pages, ID);

        //Putting values into list
        LayoutInflater insert = LayoutInflater.from(cntxt);
        view = insert.inflate(res, parent, false);

        //Sets TextViews
        displayName = (TextView) view.findViewById(R.id.textView2);
        displayAuthor = (TextView) view.findViewById(R.id.textView5);
        displayPages = (TextView) view.findViewById(R.id.textView4);
        displayID = (TextView) view.findViewById(R.id.textView3);

        //Sets TextView's content
        displayName.setText(name);
        displayAuthor.setText(author);
        displayPages.setText(pages);
        displayID.setText(ID);

        return view;
    }
}
