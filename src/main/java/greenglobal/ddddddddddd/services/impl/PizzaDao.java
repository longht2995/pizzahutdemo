package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import greenglobal.ddddddddddd.entity.Pizza;

@Repository
public class PizzaDao {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	public List<Pizza> findAll(){
		return em.createQuery("FROM Pizza",Pizza.class).getResultList();
	}
	public Pizza findOne(Integer id) {
		return em.createQuery("FROM Pizza WHERE id = "+id,Pizza.class).getSingleResult();
	}
}
