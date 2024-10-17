package Test;

import modelos.ModelDirection;
import modelos.ModelEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.time.LocalDate;


public class TestEmployees {
    private static EntityManager manager;
    private static EntityManagerFactory emf;


    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("app");
        manager = emf.createEntityManager();

        LocalDate date = LocalDate.of(2003,02,24);

        ModelEmployee employee = new ModelEmployee(1L,date,"Julia","Mercedez", new ModelDirection(10L,"Mahuida 123", "Comodoro","Argentina"));
        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();
        List<ModelEmployee> employees = (List<ModelEmployee>) manager.createQuery("FROM ModelEmployee ").getResultList();
        manager.close();
        System.out.println("In this DB are:  " + employees.size() + " employees");
        for (ModelEmployee modelEmployee : employees) {
            System.out.println(modelEmployee);
        }
    }
}
