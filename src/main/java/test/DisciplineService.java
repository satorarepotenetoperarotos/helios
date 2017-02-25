package test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DisciplineService {
    @PersistenceContext
    EntityManager em;

    public void delete(Long id) {
        em.createNamedQuery("Discipline.delete").setParameter("id", id).executeUpdate();
    }

    public Discipline update(Discipline discipline) {
        return em.merge(discipline);
    }

    public Discipline add(Discipline discipline) {
    //    discipline.setId(1L);
        em.persist(discipline);
        return discipline;
    }

    public List<Discipline> findAll() {
        return em.createNamedQuery("Discipline.findAll", Discipline.class).getResultList();
    }

    public Discipline findById(Long id) {
        return em.createNamedQuery("Discipline.findById", Discipline.class).setParameter("id", id).getSingleResult();
    }
}