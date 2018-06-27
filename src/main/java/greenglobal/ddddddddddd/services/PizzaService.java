package greenglobal.ddddddddddd.services;

import java.util.List;

import greenglobal.ddddddddddd.entity.Pizza;

public interface PizzaService {
	public List<Pizza> getAll();
	public Pizza getOne(Integer id);
}
