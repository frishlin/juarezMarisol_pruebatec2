
package com.hab.persistencia;

import com.hab.logica.TipoTramite;
import com.hab.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class TipoTramiteJpaController implements Serializable {

    public TipoTramiteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TipoTramiteJpaController() {
        emf = Persistence.createEntityManagerFactory("turneroPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoTramite tipoTramite) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoTramite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoTramite tipoTramite) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoTramite = em.merge(tipoTramite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipoTramite.getId();
                if (findTipoTramite(id) == null) {
                    throw new NonexistentEntityException("The tipoTramite with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoTramite tipoTramite;
            try {
                tipoTramite = em.getReference(TipoTramite.class, id);
                tipoTramite.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoTramite with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoTramite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoTramite> findTipoTramiteEntities() {
        return findTipoTramiteEntities(true, -1, -1);
    }

    public List<TipoTramite> findTipoTramiteEntities(int maxResults, int firstResult) {
        return findTipoTramiteEntities(false, maxResults, firstResult);
    }

    private List<TipoTramite> findTipoTramiteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoTramite.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoTramite findTipoTramite(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoTramite.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoTramiteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoTramite> rt = cq.from(TipoTramite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
