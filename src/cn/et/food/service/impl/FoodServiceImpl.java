package cn.et.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.FoodMapper;
import cn.et.food.entity.Food;
import cn.et.food.entity.FoodExample;
import cn.et.food.entity.FoodExample.Criteria;
import cn.et.food.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodMapper fm;
	public List<Food> queryFood(String foodname) {
		FoodExample fe = new FoodExample();
		Criteria c = fe.createCriteria();
		c.andFoodnameLike("%"+foodname+"%");
		//修改Criteria中的addCriterion方法的权限为public可以自己调用这个方法添加条件
		//c.addCriterion("foodname like ", foodname, "foodname");
		return fm.selectByExample(fe);
	}
	

	public  void saveFood(String foodName, Double price) {
		Food food = new Food();
		food.setFoodname(foodName);
		food.setPrice(price);
		fm.insert(food);
	}
	

	public void deleteFood(Integer foodId) {
		fm.deleteByPrimaryKey(foodId);
	}

	public void updateFood(Integer foodId, String foodName, Double price) {
		Food food = new Food();
		food.setFoodid(foodId);
		food.setFoodname(foodName);
		food.setPrice(price);
		fm.updateByPrimaryKey(food);
	}
}
