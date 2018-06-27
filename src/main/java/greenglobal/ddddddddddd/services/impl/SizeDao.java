package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import greenglobal.ddddddddddd.entity.Size;

@Repository
public class SizeDao {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	public List<Size> findAll(){
		return em.createQuery("FROM Size",Size.class).getResultList();
	}
}
