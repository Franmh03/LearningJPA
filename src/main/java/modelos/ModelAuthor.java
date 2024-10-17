package modelos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "authors")
public class ModelAuthor {
    @Id
    @Column(name = "author_id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "nationality")
    private String nationality;
    @OneToMany (mappedBy = "author",cascade = CascadeType.ALL)
    private List<ModelBook> books = new ArrayList<>();

    public ModelAuthor(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.books = new ArrayList<>();
    }

    public ModelAuthor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<ModelBook> getBooks() {
        return books;
    }

    public void setBooks(List<ModelBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ModelAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
