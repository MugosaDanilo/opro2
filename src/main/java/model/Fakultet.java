package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Fakultet.GET_ALL_PROFESOR, query = "Select f from Fakultet f")
public class Fakultet {
    public static final String GET_ALL_PROFESOR = "Fakultet.getAllProfesor";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fakultet_seq")
    private Long id;
    private String naziv;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private List<Profesor> profesor;

    public Fakultet() {
    }

    public Fakultet(Long id, String naziv, List<Profesor> profesor) {
        this.id = id;
        this.naziv = naziv;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fakultet fakultet = (Fakultet) o;
        return Objects.equals(id, fakultet.id) && Objects.equals(naziv, fakultet.naziv) && Objects.equals(profesor, fakultet.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, profesor);
    }

    @Override
    public String toString() {
        return "Fakultet{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
