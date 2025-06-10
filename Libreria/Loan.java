import java.time.LocalDate;

public class Loan {
    public Book book;
    public Reader reader;
    public LocalDate loanDate;
    public LocalDate returnDate;
    public boolean returned;
    public Loan(Book book, Reader reader, LocalDate loanDate, LocalDate returnDate) {
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.returned = false;
    }
    public void markAsReturned() {
        this.returned = true;
    }
    public boolean isReturned() {
        return returned;
    }
    public Book getBook() {
        return book;
    }
    public Reader getReader() {
        return reader;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public String toString() {
        return "Préstamo de: " + book.title + " a " + reader.name +
               " | Fecha préstamo: " + loanDate + " | Devolución: " + returnDate +
               " | Devuelto: " + (returned ? "Sí" : "No");
    }
}
