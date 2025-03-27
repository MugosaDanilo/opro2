package model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = Profesor.GET_FAKULTET_FOR_PROFESOR, query = "Select p from Profesor p where p.id = :id")
public class Profesor {

    public static final String GET_FAKULTET_FOR_PROFESOR = "getFakultetForProfesor";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    private Long id;
    private String naziv;

    @ManyToOne
    private Fakultet fakultet;

    public Profesor() {
    }
}
