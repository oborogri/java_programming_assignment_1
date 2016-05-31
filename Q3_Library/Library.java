import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a Library class 
 * @version  05.02.2016
 * @author   Grigore Oboroceanu
 */

public class Library
{

    private ArrayList<Book> books;

    /**
     * Constructs a default Library as list 
     */ 
    public Library ()
    {
        books = new ArrayList<Book>();
    }

    /**
     * Adds a book object to the Lybrary list
     */
    public void add(Book book)
    {
        books.add(book);   
    }

    /**
     * Retursn number of books in the Lybrary
     */
    public int numberBooks ()
    {
        return books.size();
    }

    /**
     * Returns details of a specific book loan status
     */
    public String loanStatus(Book book)
    {
        if (books.contains (book))
        {
            return book.loanStatus();
        }
        else 
        {
            return (book.getTitle() + " is not in our Lybrary");
        }

    }

    /**
     * Informs whether a specific book is in the Library collection  
     */
    public String hasBook(Book book)
    {
        if(books.contains(book))
        {
            return "Book title " + book.getTitle() + " is in stock and available to borrow";
        }
        else
        {
            return "We do not stock book title " + book.getTitle();
        }
    }

    /**
     * Removes a specific book from Library collection
     * returns true if successful
     * returns false if not successful or book not in the Library 
     */
    public boolean removeBook(Book book)
    {
        return books.remove(book);
    }

    /**
     * Removes all books from the Lubary collection
     */
    public void removeAllBooks()
    {
        books.removeAll(books);     
    }

    /**
     * Prints details of all books in the Library
     */
    public void printDetailsAll()
    {
        for(int i = 0; i < books.size(); i ++)
            books.get(i).printDetails();
    }
}