import java.time.LocalDate;
import java.util.*;

public class Biblioteca{
    static List<Book> books = new ArrayList<>();
    static List<Reader> readers = new ArrayList<>();
    static List<Loan> loans = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Menú Biblioteca DMC");
            System.out.println("1. Registrar libro");
            System.out.println("2. Filtrar libros");
            System.out.println("3. Registrar lector");
            System.out.println("4. Filtrar lectores");
            System.out.println("5. Registrar préstamo");
            System.out.println("6. Filtrar préstamos");
            System.out.println("7. Registrar devolución");
            System.out.println("0. Salir");
            option = teclado.nextInt();
            teclado.nextLine(); // consumir línea

            switch (option) {
                case 1 -> registrarLibro();
                case 2 -> filtrarLibros();
                case 3 -> registrarLector();
                case 4 -> filtrarLectores();
                case 5 -> registrarPrestamo();
                case 6 -> filtrarPrestamos();
                case 7 -> registrarDevolucion();
            }
        } while (option != 0);
    }

    public static void registrarLibro() {
        System.out.print("ISBN: ");
        String isbn = teclado.nextLine();
        for (Book b : books) {
            if (b.getISBN().equalsIgnoreCase(isbn)) {
                System.out.println("Error: ISBN repetido.");
                return;
            }
        }

        System.out.print("Título: ");
        String title = teclado.nextLine();
        System.out.print("Autor: ");
        String author = teclado.nextLine();
        System.out.print("Género: ");
        String genre = teclado.nextLine();
        System.out.print("Fecha de publicación (AAAA-MM-DD): ");
        LocalDate date = LocalDate.parse(teclado.nextLine());

        books.add(new Book(isbn, title, author, genre, date));
        System.out.println("Se registró el libro con éxito.");
    }

    public static void filtrarLibros() {
        System.out.print("Buscar por título, autor o ISBN: ");
        String search = teclado.nextLine().toLowerCase();
        books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(search) ||
                             b.getAuthor().toLowerCase().contains(search) ||
                             b.getISBN().equalsIgnoreCase(search))
                .forEach(System.out::println);
    }

    public static void registrarLector() {
        System.out.print("Nombre: ");
        String name = teclado.nextLine();
        System.out.print("Carnet: ");
        String carnet = teclado.nextLine();
        for (Reader r : readers) {
            if (r.getIdCard().equalsIgnoreCase(carnet)) {
                System.out.println("Error: carnet repetido.");
                return;
            }
        }
        System.out.print("Correo: ");
        String email = teclado.nextLine();

        readers.add(new Reader(name, carnet, email));
        System.out.println("Se ha registrado con éxito el lector.");
    }

    public static void filtrarLectores() {
        System.out.print("Buscar por nombre, carnet o correo: ");
        String search = teclado.nextLine().toLowerCase();
        readers.stream()
                .filter(r -> r.getName().toLowerCase().contains(search) ||
                             r.getIdCard().toLowerCase().contains(search) ||
                             r.getEmail().toLowerCase().contains(search))
                .forEach(System.out::println);
    }

    public static void registrarPrestamo() {
        System.out.print("ISBN del libro: ");
        String isbn = teclado.nextLine();
        Book book = books.stream().filter(b -> b.getISBN().equalsIgnoreCase(isbn)).findFirst().orElse(null);
        if (book == null) {
            System.out.println("Error: libro no encontrado.");
            return;
        }

        System.out.print("Carnet del lector: ");
        String carnet = teclado.nextLine();
        Reader reader = readers.stream().filter(r -> r.getIdCard().equalsIgnoreCase(carnet)).findFirst().orElse(null);
        if (reader == null) {
            System.out.println("Error: lector no encontrado.");
            return;
        }

        System.out.print("Fecha de préstamo (AAAA-MM-DD): ");
        LocalDate loanDate = LocalDate.parse(teclado.nextLine());
        System.out.print("Fecha de devolución (AAAA-MM-DD): ");
        LocalDate returnDate = LocalDate.parse(teclado.nextLine());

        loans.add(new Loan(book, reader, loanDate, returnDate));
        System.out.println("Préstamo registrado con éxito.");
    }

    public static void filtrarPrestamos() {
        System.out.print("Buscar por título, carnet o fecha (AAAA-MM-DD): ");
        String search = teclado.nextLine().toLowerCase();
        loans.stream()
                .filter(l -> l.getBook().getTitle().toLowerCase().contains(search) ||
                             l.getReader().getIdCard().toLowerCase().contains(search) ||
                             l.getLoanDate().toString().contains(search) ||
                             l.getReturnDate().toString().contains(search))
                .forEach(System.out::println);
    }

    public static void registrarDevolucion() {
        System.out.print("ISBN del libro a devolver: ");
        String isbn = teclado.nextLine();
        Optional<Loan> loan = loans.stream()
                .filter(l -> l.getBook().getISBN().equalsIgnoreCase(isbn) && !l.isReturned())
                .findFirst();
        if (loan.isPresent()) {
            loan.get().markAsReturned();
            System.out.println("Libro registrado como devuelto.");
        } else {
            System.out.println("Error: préstamo no encontrado o ya devuelto.");
        }
    }
}
