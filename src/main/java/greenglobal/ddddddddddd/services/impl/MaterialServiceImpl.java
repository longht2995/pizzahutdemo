package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.ddddddddddd.entity.Material;
import greenglobal.ddddddddddd.services.MaterialService;

@Service("materialService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MaterialServiceImpl implements MaterialService{
	@Autowired
	private MaterialDao materialDao;
	public List<Material> findAll() {
		// TODO Auto-generated method stub
		return materialDao.findAll();
	}
	public List<Material> findByCategory(Integer id) {
		// TODO Auto-generated method stub
		return materialDao.findByCategory(id);
	}
	
}
