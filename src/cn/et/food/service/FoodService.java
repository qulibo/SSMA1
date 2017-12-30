package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Food;

public interface FoodService {
	
	public abstract List<Food> queryFood(String foodname);
	
	public abstract void deleteFood(Integer foodId);

	/* (non-Javadoc)
	 * @see cn.et.food.dao.impl.MyFoodDao#saveFood(s, java.lang.String)
	 */
	public abstract void saveFood(String foodName, Double price);

	/* (non-Javadoc)
	 * @see cn.et.food.dao.impl.MyFoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public abstract void updateFood(Integer foodId, String foodName, Double price);
	
}