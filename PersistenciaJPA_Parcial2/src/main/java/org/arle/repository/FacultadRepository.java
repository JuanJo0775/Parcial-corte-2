package org.arle.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.arle.entity.Facultad;

import java.util.List;

public class FacultadRepository {

    private final EntityManagerFactory emf;

    public FacultadRepository() {
        emf = Persistence.createEntityManagerFactory("facultadPU");
    }

    public void crear(Facultad facultad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(facultad);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Facultad leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Facultad.class, id);
        } finally {
            em.close();
        }
    }

    public List<Facultad> leerTodas() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT f FROM Facultad f", Facultad.class)
                    .getResultList();
        }
    }

    public void actualizar(Facultad facultad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(facultad);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Facultad facultad = em.find(Facultad.class, id);
            if (facultad != null) {
                em.remove(facultad);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
