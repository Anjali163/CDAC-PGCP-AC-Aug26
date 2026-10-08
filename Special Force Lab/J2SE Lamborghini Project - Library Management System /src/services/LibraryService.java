package services;

import exceptions.BookAlreadyBorrowedException;
import exceptions.BookNotAvailableException;
import exceptions.MemberNotFoundException;
import models.Book;
import models.Library;
import models.Member;

public class LibraryService {
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
  }

    public void borrowBook(int memberID, String ISBN)
            throws MemberNotFoundException, BookNotAvailableException,
                   BookAlreadyBorrowedException {

        Member member = library.getMemberById(memberID);
        if (member == null) {
            throw new MemberNotFoundException(
                    "Member not found: " + memberID);
    }

        Book book = library.getBookByISBN(ISBN);
        if (book == null) {
            throw new BookNotAvailableException(
                    "Book is not available.");
       }

        if (member.hasBorrowed(ISBN)) {
            throw new BookAlreadyBorrowedException(
                    "You have already borrowed this book.");
  }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(
                    "Book is not available.");
      }

        book.setAvailable(false);
        member.borrowBook(book);
   }

    public void returnBook(int memberID, String ISBN)
            throws MemberNotFoundException, BookNotAvailableException {

        Member member = library.getMemberById(memberID);
        if (member == null) {
            throw new MemberNotFoundException(
                    "Member not found: " + memberID);
        }

        Book book = library.getBookByISBN(ISBN);
        if (book == null) {
            throw new BookNotAvailableException(
                    "Book not found.");
   }

        if (!member.hasBorrowed(ISBN)) {
            throw new BookNotAvailableException(
                    "You did not borrow this book.");
        }

        member.returnBook(book);
        book.setAvailable(true);
    }

    public void printStatistics() {
        System.out.println("Total Members: " + library.getTotalMembers());
        System.out.println("Total Books: " + library.getTotalBooks());
        System.out.println("Currently Borrowed Books: "
                + library.getCurrentlyBorrowedBooks());
    }
}
