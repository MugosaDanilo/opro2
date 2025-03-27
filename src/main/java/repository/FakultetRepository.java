package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Fakultet;
import model.Profesor;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class FakultetRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public Fakultet createFakultet(Fakultet f) {
        return em.merge(f);
    }

    @Transactional
    public List<Fakultet> getAllFakultet() {
        List<Fakultet> fakultetList = em.createNamedQuery(Fakultet.GET_ALL_PROFESOR, Fakultet.class).getResultList();

        for (Fakultet fakultet : fakultetList) {
            List<Profesor> profesorList = em.createNamedQuery(Profesor.GET_FAKULTET_FOR_PROFESOR, Profesor.class).setParameter("id", fakultet.getId()).getResultList();

            fakultet.setProfesor(new ArrayList<>(profesorList));
        }

        return fakultetList;
    }
}

