package models;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<String, Book> books;
    private Set<Member> members;

    public Library() {
        books = new HashMap<>();
        members = new HashSet<>();
}

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
  }

    public void addMember(Member member) {
        members.add(member);
}

    public boolean containsBook(String ISBN) {
        return books.containsKey(ISBN);
    }

    public boolean containsMember(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return true;
            }
      }
        return false;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        // Iterator is intentionally used as required by the assignment.
        Iterator<Book> iterator = books.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Book searchBook(String keyword) {
        for (Book book : books.values()) {
            if (book.getISBN().equalsIgnoreCase(keyword)
                    || book.getTitle().equalsIgnoreCase(keyword)
                    || book.getAuthor().equalsIgnoreCase(keyword)) {
                return book;
            }
      }
        return null;
    }

    public Book getBookByISBN(String ISBN) {
        return books.get(ISBN);
    }

    public Member getMemberById(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return member;
            }
      }
        return null;
    }

    public int getTotalMembers() {
        return members.size();
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getCurrentlyBorrowedBooks() {
        int count = 0;
        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                count++;
            }
     }
        return count;
    }

    public Set<Member> getMembers() {
        return members;
    }
}
