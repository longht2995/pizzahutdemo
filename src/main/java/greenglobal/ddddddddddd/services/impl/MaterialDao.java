package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import greenglobal.ddddddddddd.entity.Material;

@Repository
public class MaterialDao {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	public List<Material> findAll(){
		return em.createQuery("FROM Material",Material.class).getResultList();
	}
	public List<Material> findByCategory(Integer id){
		return em.createQuery("FROM Material WHERE category_id = "+id,Material.class).getResultList();
	}

}
