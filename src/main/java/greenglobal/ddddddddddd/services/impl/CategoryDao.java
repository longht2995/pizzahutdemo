package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import greenglobal.ddddddddddd.entity.Category;

@Repository
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryDao {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	public List<Category> findAll(){
		return em.createQuery("FROM Category",Category.class).getResultList();
	}
	public Category findOne(Integer id) {
		return em.createQuery("FROM Category WHERE id = "+id,Category.class).getSingleResult();
	}
	@Transactional
	public void add(Category category) {
		em.persist(category);
	}
}
