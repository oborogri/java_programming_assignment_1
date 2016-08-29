# java_programming_assignment_1
This assignment relates to Introduction to Java programming language, Analysis & refactoring class, Object Interaction and Grouping Objects.
Question 1 - Develop a Sphere class with a specific Application Programming Interface (API):
  
  public Sphere() // set the default value of the radius to 10.0
  public Sphere(double radius)
  public double surfaceArea() // surface area of sphere 
  public double volume() // the volume of sphere 
  public double greatCircle() // circumference of great circle
  public void changeSize(double radius) // facilitates radius reset
  public int getNumberSpheres(); // number of Sphere objects created
  
  Question 2 - Develope the DemoArray class in the arrays project.
  
  Question 3 - Develop a small suite of classes: Library, Librarian and Book.
  
  3.1 - Develop a Book class with the following API:

public Book(String title, String author, int numberPages, String isbn)
public void borrow()        // borrow a book
public boolean isBorrowed() // is book on loan?
public void returns()       // return book 
public String loanStatus()  // print a message
public void printDetails()  // print details re book
public String getTitle()      // return book title

3.2 Write a simple Library class in which to store books. Here is its API:

public void     add(Book book)
public int      numberBooks()
public String   loanStatus(Book book)
public String   hasBook(Book book)
public boolean  removeBook(Book book)
public void     removeAllBooks()
public void     printDetailsAll() // print details all books in library

3.3 Create a Librarian class. Use this to test the Book and Library classes

public Librarian()
public void unitTest()

Question 4 - relates to the String class. Complete the class by adding the following methods:

4.1 - isEqual();
4.2 - isEqualIgnoreCase();
4.3 - hasPrefix();
4.4 - length();
4.5 - toUpper();
4.6 - endsWith();
4.7 - subString();
4.8 - reverse1();
4.9 - reverse2();
4.10 - reverse 3();
4.11 - isPalindrome();

Question 5 - This question requires modifying the 24-hour clock class. There are two parts to this question. 
The first part requires modifying the starter code to produce a clock displaying hours, minutes and seconds.
The second part requires adding days to the display.
