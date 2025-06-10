import java.time.LocalDate;

public class Book {
    public String ISBN;
    public String title;
    public String author;
    public String genre;
    public LocalDate publicationDate;
    public Book(String ISBN, String title, String author, String genre, LocalDate publicationDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public String toString() {
        return "Libro: " + title + " | Autor: " + author + " | ISBN: " + ISBN;
    }
}

