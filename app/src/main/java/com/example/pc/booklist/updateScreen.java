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

//class that allows users to update books in database
public class updateScreen extends AppCompatActivity
{

    //Declarations
    DBManager database;
    EditText updateName;
    EditText updateAuthor;
    EditText updatePages;
    EditText updateID;
    Button updateBookBtn;
    int result;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_screen);

        //set database
        database = new DBManager(this);

        //declare editTexts, and button
        updateName=(EditText)findViewById(R.id.updateName);
        updateAuthor=(EditText)findViewById(R.id.updateAuthor);
        updatePages=(EditText)findViewById(R.id.updatePages);
        updateID=(EditText)findViewById(R.id.updateID);
        updateBookBtn=(Button)findViewById(R.id.updateBook);

        //Declare method
        updateBooks();
    }

    //Methos that updates books
    public void updateBooks()
    {
        //sets onclick listenr on button, when button is clicked, book is updated
        updateBookBtn.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        //updates book using values obtained from editTexts, stores result in variable
                        result = database.updateData(updateID.getText().toString(), updateName.getText().toString(), updateAuthor.getText().toString(),updatePages.getText().toString());

                        //checks to see if update occurred, informs user of result
                        if(result > 0)
                        {
                            Toast.makeText(updateScreen.this, "Book updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(updateScreen.this, "Book not updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
