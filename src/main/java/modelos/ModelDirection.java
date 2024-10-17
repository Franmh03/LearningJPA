package modelos;

import javax.persistence.*;

@Entity
@Table (name = "direction")
public class ModelDirection {
    @Id
    @Column (name = "id_direction")
    private long id;
    @Column (name = "direction")
    private String direcction;
    @Column (name = "city")
    private String city;
    @Column (name = "country")
    private String country;

    @OneToOne (mappedBy = "direction", fetch = FetchType.LAZY)
    private ModelEmployee employee;

    public ModelDirection(long id, String direcction, String city, String country) {
        this.id = id;
        this.direcction = direcction;
        this.city = city;
        this.country = country;
    }

    public ModelDirection() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirecction() {
        return direcction;
    }

    public void setDirecction(String direcction) {
        this.direcction = direcction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ModelEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(ModelEmployee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", direcction='" + direcction + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", empleado: " + employee.getCode() +
                '}';
    }
}
