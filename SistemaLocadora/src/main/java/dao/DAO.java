package dao;

import jakarta.persistence.*;
import java.util.List;

public class DAO<T> {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("locadoraPU");

    protected EntityManager em = emf.createEntityManager();
    private Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void inserir(T obj) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(obj);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    public List<T> listar() {
        String jpql = "select e from " + classe.getSimpleName() + " e";
        return em.createQuery(jpql, classe).getResultList();
    }

    public T buscarPorId(Object id) {
        return em.find(classe, id);
    }
}