package KitapListesi;

import java.time.LocalDate;

public class Book {
    private String title;
    private int pageCount;
    private String authorName;
    private LocalDate publicationDate;

    public Book(String title, int pageCount, String authorName, LocalDate publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
