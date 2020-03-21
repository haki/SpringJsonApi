package git.rest.book.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private @Id @GeneratedValue( strategy = GenerationType.AUTO) Long id;

    private String name;
    private String author;
    private Integer page;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public Integer getPage() {
        return page;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", page=" + page +
                '}';
    }
}
