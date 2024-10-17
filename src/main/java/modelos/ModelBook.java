package modelos;

import javax.persistence.*;

@Entity
@Table (name = "books")
public class ModelBook {
    @Id
    @Column (name = "id_book")
    private Long id;
    @Column (name = "title")
    private String title;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "autor_id")
    private ModelAuthor author;
    public ModelBook() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelBook(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "ModelBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", id author: " + author.getId() +
                '}';
    }

    public ModelBook(Long id, String title, ModelAuthor author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

}
