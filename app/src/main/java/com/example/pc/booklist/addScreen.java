//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Class that deals with adding books to the database
public class addScreen extends AppCompatActivity {

    //Declare variables
    DBManager database;     //instance for using dbManager class methods
    EditText addName;       //EditTexts
    EditText addAuthor;
    EditText addPages;
    Button addBookBtn;
    boolean result;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);

        //Sets database instance
        database = new DBManager(this);

        //Setting EditTexts to elements
        addName=(EditText)findViewById(R.id.addName);
        addAuthor=(EditText)findViewById(R.id.addAuthor);
        addPages=(EditText)findViewById(R.id.addPages);
        addBookBtn=(Button)findViewById(R.id.addBook);

        //Method
        addBook();
    }

    //Method that adds books to database
    public void addBook()
    {
        //Sets listener on button, carries out method when button pressed
        addBookBtn.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        //Adds book to database by getting values to be inserted
                        //from editTexts, and stores result set in result variable
                        result = database.addBook(addName.getText().toString(), addAuthor.getText().toString(), addPages.getText().toString());

                        //Checks to see if book has ben successfully inserted, informs user with toast
                        if(result)
                        {
                            Toast.makeText(addScreen.this, "Book added!", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(addScreen.this, "Book not added!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
