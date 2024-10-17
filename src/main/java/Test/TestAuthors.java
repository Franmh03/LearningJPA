package Test;

import modelos.ModelAuthor;
import modelos.ModelBook;
import modelos.ModelEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestAuthors {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");

    public static void main(String[] args) {
        createData();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ModelAuthor> authors = (List<ModelAuthor>) em.createQuery("FROM ModelAuthor ").getResultList();
        em.close();
        System.out.println("In this DB are:  " + authors.size() + " authors");
        for (ModelAuthor modelAuthor : authors) {
            System.out.println(modelAuthor);
        }
        findData();
        emf.close();

    }
    static void createData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ModelAuthor a1 = new ModelAuthor(1L, "Juan Jhons","American");
        ModelAuthor a2 = new ModelAuthor(2L, "Ezequiel Smith","American");
        ModelAuthor a3 = new ModelAuthor(3L, "Martin Grimes","American");

        em.persist(a1);
        em.persist(a2);
        em.persist(a3);

        em.persist( new ModelBook(1L,"Databases",a1));
        em.persist( new ModelBook(2L,"Microservbices",a1));
        em.persist( new ModelBook(3L,"Fuel and engines",a1));
        em.persist( new ModelBook(4L,"Pure logic",a2));
        em.persist( new ModelBook(5L,"Incosistence in code",a2));
        em.getTransaction().commit();
        em.close();
    }
    static void findData () {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ModelAuthor author = em.find(ModelAuthor.class, 1L);
        List<ModelBook> books = author.getBooks();
        for (ModelBook book : books) {
            System.out.println(book.toString());
        }
        em.getTransaction().commit();
        em.close();
    }
}
