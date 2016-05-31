/**
 * Book.java
 * This class defines the basic description of a book and provides some characteristic methods.
 * @version  05.02.2016
 * @author   Grigore Oboroceanu
 */
public class Book
{
    private String title;
    private String author;
    private String ISBN;
    private int numberPages;
    boolean isBorrowed;
    private int numberBorrowings;

    /**
     * Creates an instance of book with given parameters 
     */
    public Book(String title, String author, int numberPages, String ISBN)
    {
        setState(title, author, ISBN, numberPages);
    }

    /**
     * Defines state of the book class fileds  
     */
    public void setState (String title, String author, String ISBN, int numberPages)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.numberPages = numberPages;
    }

    /**
     * Facilitates borrowing the book 
     * Keeps track of the number of times the book has been borrowed
     * Warns the user if the book is already on loan
     */
    public void borrow()
    {
        if (isBorrowed)
        {
            System.out.println(title + " not available : currently on loan");   
        }
        else
        {
            isBorrowed = true;
            numberBorrowings ++;
        }
    }

    /**
     * Facilitates return of the book to the library
     * Changes the loan status of the book to available
     */
    public void returns()
    {
        isBorrowed = false;      
    }

    /**
     * Returns title of the book
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Informs about the status of a specific book - on loan or available   
     */
    public String loanStatus()
    {
        if (isBorrowed)
        {
            return title + " not available: presently on loan";
        }
        else
        {  
            return title + " is available";
        }

    }

    /**
     * Prints out book details and loan status  
     */
    public void printDetails ()
    {
        System.out.println("Title           :  " + title);
        System.out.println("Author          :  " + author);
        System.out.println("Pages           :  " + numberPages);
        System.out.println("ISBN            :  " + ISBN);
        System.out.println("Borrowed        :  " + numberBorrowings + " times");
        System.out.println("Availability    :  " + loanStatus()+ "\n");
    }

}
