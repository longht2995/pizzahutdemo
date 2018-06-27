package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.ddddddddddd.entity.Size;
import greenglobal.ddddddddddd.services.SizeService;
@Service("sizeService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeServiceImpl implements SizeService{
	@Autowired
	private SizeDao sizeDao;
	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return sizeDao.findAll();
	}
	
}
