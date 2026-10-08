package ui;

import java.util.Scanner;

import exceptions.BookAlreadyBorrowedException;
import exceptions.BookNotAvailableException;
import exceptions.MemberNotFoundException;
import models.Book;
import models.Library;
import models.Member;
import services.LibraryService;

public class LibraryManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();
    private static LibraryService service = new LibraryService(library);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    displayBorrowedBooks();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    service.printStatistics();
                    break;
                case 9:
                    System.out.println("Exiting Library Management System...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Display All Books");
        System.out.println("4. Search Book");
        System.out.println("5. Borrow Book");
        System.out.println("6. Display Borrowed Books");
        System.out.println("7. Return Book");
        System.out.println("8. Display Library Statistics");
        System.out.println("9. Exit");
        System.out.println("==============================================");
    }

    private static void addBook() {
        System.out.println("\n--- Add Book ---");
        String title = readText("Title: ");
        String author = readText("Author: ");
        String isbn = readText("ISBN: ");

        if (library.containsBook(isbn)) {
            System.out.println("A book with this ISBN already exists.");
            return;
        }

        library.addBook(new Book(title, author, isbn));
        System.out.println("Book added: " + title + " by " + author
                + " (ISBN: " + isbn + ")");
    }

    private static void addMember() {
        System.out.println("\n--- Add Member ---");
        String name = readText("Name: ");
        int memberID = readInt("Member ID: ");

        if (library.containsMember(memberID)) {
            System.out.println("A member with this ID already exists.");
            return;
        }

        library.addMember(new Member(name, memberID));
        System.out.println("Member added: " + name
                + " (ID: " + memberID + ")");
    }

    private static void displayBooks() {
        System.out.println("\n--- Available Books ---");
        if (library.getTotalBooks() == 0) {
            System.out.println("No books in the library.");
            return;
        }
        library.displayBooks();
    }

    private static void searchBook() {
        System.out.println("\n--- Search Book ---");
        String keyword = readText("Enter title, author or ISBN: ");
        Book book = library.searchBook(keyword);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book found: " + book);
        }
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        int memberID = readInt("Member ID: ");
        String isbn = readText("ISBN: ");

        try {
            service.borrowBook(memberID, isbn);
            Book book = library.getBookByISBN(isbn);
            System.out.println("Book borrowed successfully: "
                    + book.getTitle() + " by " + book.getAuthor());
        } catch (MemberNotFoundException | BookNotAvailableException
                | BookAlreadyBorrowedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayBorrowedBooks() {
        System.out.println("\n--- Display Borrowed Books ---");
        int memberID = readInt("Member ID: ");
        Member member = library.getMemberById(memberID);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println("Borrowed Books for " + member.getName() + ":");
        member.printBorrowedBooks();
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        int memberID = readInt("Member ID: ");
        String isbn = readText("ISBN: ");

        try {
            Book book = library.getBookByISBN(isbn);
            service.returnBook(memberID, isbn);
            System.out.println("Book returned successfully: "
                    + book.getTitle() + " by " + book.getAuthor());
        } catch (MemberNotFoundException | BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}

