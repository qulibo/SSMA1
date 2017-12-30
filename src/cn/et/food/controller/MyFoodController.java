package cn.et.food.controller;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.entity.Food;
import cn.et.food.service.FoodService;

@Controller
public class MyFoodController {
	@Autowired
	FoodService service;
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method={RequestMethod.GET})
	public List<Food> queryFood(@RequestParam(required=false)String foodname){
		return service.queryFood(foodname);
	}
	
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.DELETE})
	public String deleteFood(@PathVariable Integer foodId,OutputStream os) throws Exception{
		try {
			service.deleteFood(foodId);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * �޸�food
	 * @param foodId ��Ʒid
	 * @param foodName ��Ʒ��
	 * @param price ��Ʒ�۸�
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.PUT})
	public String udpateFood(@PathVariable Integer foodId,String foodName,Double price,OutputStream os) throws Exception{
		try {
			service.updateFood(foodId, foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * ���ڲ�Ʒ
	 * @param foodName ��Ʒ����
	 * @param price �۸�
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,Double price,OutputStream os) throws Exception{
		try {
			service.saveFood(foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	
}
