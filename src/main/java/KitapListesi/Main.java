package KitapListesi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Book nesnelerini oluşturma
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter ve Felsefe Taşı", 223, "J.K. Rowling", LocalDate.of(1997, 1, 1)));
        bookList.add(new Book("Harry Potter ve Sırlar Odası", 251, "J.K. Rowling", LocalDate.of(1998, 1, 1)));
        bookList.add(new Book("Harry Potter ve Azkaban Tutsağı", 317, "J.K. Rowling", LocalDate.of(1999, 1, 1)));
        bookList.add(new Book("Harry Potter ve Ateş Kadehi", 636, "J.K. Rowling", LocalDate.of(2000, 1, 1)));
        bookList.add(new Book("Harry Potter ve Zümrüdüanka Yoldaşlığı", 766, "J.K. Rowling", LocalDate.of(2003, 1, 1)));
        bookList.add(new Book("Kitap 1", 90, "J.K. Rowling", LocalDate.of(1997, 1, 1)));
        bookList.add(new Book("Kitap 2", 91, "J.K. Rowling", LocalDate.of(1997, 1, 1)));
        bookList.add(new Book("Kitap 3", 83, "J.K. Rowling", LocalDate.of(1997, 1, 1)));
        bookList.add(new Book("Kitap 4", 75, "J.K. Rowling", LocalDate.of(1997, 1, 1)));
        bookList.add(new Book("Kitap 5", 68, "J.K. Rowling", LocalDate.of(1997, 1, 1)));

        // Kitap ismi ile yazar ismi eşleştirmek için Map oluşturma
        Map<String, String> bookAuthorMap = bookList.stream().collect(Collectors.toMap(Book::getTitle, Book::getAuthorName));

        // Sayfa sayısı 100'den fazla olan kitapları filtreleme
        List<Book> filteredList = bookList.stream().filter(book -> book.getPageCount() > 100).collect(Collectors.toList());

        System.out.println("Kitap ismi - Yazar ismi");
        System.out.println("=======================");
        bookAuthorMap.forEach((title, author) -> System.out.println(title + " - " + author));

        System.out.println("\nSayfa sayısı 100'den fazla olan kitaplar");
        System.out.println("========================================");
        filteredList.forEach(book -> System.out.println(book.getTitle()));

    }
}
