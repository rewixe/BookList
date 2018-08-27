//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Class to manage functions which interact with SQLite database
class DBManager extends SQLiteOpenHelper
{
    //Instantiating database variables,
    private static final String DB = "books.db";
    private static final String TABLE = "books";

    //Columns in table
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String AUTHOR = "AUTHOR";
    private static final String PAGES = "PAGES";

    //Constructer
    DBManager(Context context)
    {
        super(context, DB, null, 1);
    }

    //Called when database needs upgrade
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        database.execSQL("DROP TABLE IF EXISTS" +TABLE);
        onCreate(database);

    }

    //onCreate function
    @Override
    public void onCreate(SQLiteDatabase database)
    {
        //Create database
        database.execSQL("CREATE TABLE " + TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AUTHOR TEXT, PAGES INTEGER) ");
    }

    //Method to add book to database, take in values to be inserted as parameters
    boolean addBook(String name, String author, String pages)
    {
        //Sets database
        SQLiteDatabase database = this.getWritableDatabase();

        //sets values to be inserted
        ContentValues rows = new ContentValues();
        rows.put(NAME, name);
        rows.put(AUTHOR, author);
        rows.put(PAGES, pages);

        //gets result of insert statement
        long result = database.insert(TABLE, null, rows);
        return result != -1;
    }

    //Method to get books from databse, stores in Cursor
    Cursor getBooks()
    {
        //Sets database
        SQLiteDatabase database = this.getWritableDatabase();
        //Returns result set
        return database.rawQuery("SELECT * FROM "+TABLE, null);
    }

    //Method to update books in database, takes in values to b updates as parameters
    int updateData(String id, String name, String author, String pages)
    {
        //Sets database
        SQLiteDatabase database = this.getWritableDatabase();
        //Sets values to be updated
        ContentValues rows = new ContentValues();
        rows.put(ID,id);
        rows.put(NAME,name);
        rows.put(AUTHOR,author);
        rows.put(PAGES,pages);
        //returns number of rows updated
        return database.update(TABLE, rows, "ID = ?",new String[] { id });
    }

    //Method to remove book from database, take in values to be removed as parameters
    int removeBook(String name, String author)
    {
        //Sets database
        SQLiteDatabase database = this.getWritableDatabase();
        //Returns number of rows deleted
        return database.delete(TABLE, "NAME=? AND AUTHOR=?", new String[] { name, author });
    }
}
