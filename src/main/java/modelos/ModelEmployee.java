package modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")
public class ModelEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "code")
    private Long code;
    @Column(name = "apellidos")
    private String lastName;
    @Column(name = "nombre")
    private String firstName;
    @Column(name = "birthdate")
    private java.time.LocalDate birthdate;

    @OneToOne (cascade = {CascadeType.ALL})
    @JoinColumn (name = "id_direction")
    private ModelDirection direction;

    public ModelEmployee() {
    }

    public ModelEmployee(Long code, LocalDate birthdate, String firstName, String lastName, ModelDirection direction) {
        this.code = code;
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.direction = direction;
        this.direction.setEmployee(this);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String apellidos) {
        this.lastName = apellidos;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String nombre) {
        this.firstName = nombre;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public ModelDirection getDirection() {
        return direction;
    }

    public void setBirthdate(LocalDate fechaNacimiento) {
        this.birthdate = fechaNacimiento;
    }




    @Override
    public String toString() {
        return "ModelEmployee{" +
                "code=" + code +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate=" + birthdate +
                ", direction=" + direction +
                '}';
    }
}
