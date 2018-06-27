package greenglobal.ddddddddddd.services;

import java.util.List;

import greenglobal.ddddddddddd.entity.Material;

public interface MaterialService {
	public List<Material> findAll();
	public List<Material> findByCategory(Integer id);
}
