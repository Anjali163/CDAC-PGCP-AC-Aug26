package models;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Member {
    private String name;
    private int memberID;
    private List<Book> borrowedBooks;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
  }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMemberID() { return memberID; }
    public void setMemberID(int memberID) { this.memberID = memberID; }

    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
 }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
  }

    public boolean hasBorrowed(String ISBN) {
        for (Book book : borrowedBooks) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                return true;
            }
     }
        return false;
    }

    public void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }

        // ListIterator is intentionally used as required by the assignment.
        ListIterator<Book> iterator = borrowedBooks.listIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
      }
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberID + ")";
    }
}
