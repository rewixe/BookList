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

//class for handling removing books from database
public class removalScreen extends AppCompatActivity {

    //Declarations
    EditText removeName;
    EditText removeAuthor;
    Button removeBookBtn;
    Integer removedBooks;
    DBManager database;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removal_screen);

        //sets database
        database = new DBManager(this);

        //Sets editTexts
        removeName=(EditText)findViewById(R.id.removeName);
        removeAuthor=(EditText)findViewById(R.id.removeAuthor);
        removeBookBtn=(Button)findViewById(R.id.removeBook);

        //Method declaration
        removeBook();
    }

    //method for removing book from database
    public void removeBook()
    {
        //Sets click listener on button, when it is clicked book is removed
        removeBookBtn.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        //gets values t be removed from editTexts
                        String bookName = removeName.getText().toString();
                        String bookAuthor = removeAuthor.getText().toString();

                        //removes books from database using values from editTexts
                        //as parameters, counts number of books removed from database
                        //stores in removed books
                        removedBooks = database.removeBook(bookName, bookAuthor);

                        //checks to see if successfully removed, informs user of result
                        if(removedBooks <= 0)
                        {
                            Toast.makeText(removalScreen.this, "Book not removed", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(removalScreen.this, "Book removed", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
