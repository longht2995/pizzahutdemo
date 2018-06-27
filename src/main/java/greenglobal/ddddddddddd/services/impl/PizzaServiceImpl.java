package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.ddddddddddd.entity.Pizza;
import greenglobal.ddddddddddd.services.PizzaService;

@Service("pizzaService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PizzaServiceImpl implements PizzaService{
	@Autowired
	private PizzaDao pizzaDao;

	public List<Pizza> getAll() {
		// TODO Auto-generated method stub
		return pizzaDao.findAll();
	}

	public Pizza getOne(Integer id) {
		// TODO Auto-generated method stub
		return pizzaDao.findOne(id);
	}
	
}
