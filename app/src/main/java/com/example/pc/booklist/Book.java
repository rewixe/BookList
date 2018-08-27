//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

//Book object class, stores book objects
public class Book
{
    //Book variables
    private String name;
    private String author;
    private String pages;
    private String ID;

    //Getters and setters
    public String getPages()
    {
        return pages;
    }

    public void setPages(String pages)
    {
        this.pages = pages;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    //Constructor
    public Book(String name, String author, String pages, String ID)
    {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.ID = ID;
    }
}
