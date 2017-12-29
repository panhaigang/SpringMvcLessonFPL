package cn.et.lesson05.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson05.dao.MoneyDaoImpl;

@Service
public class MoneyServicesImpl {

	@Autowired
	private MoneyDaoImpl dao;
	
	public void transfer(Integer money){
		dao.transfer(money);
	}
	
	public Integer queryMoney(){
		return dao.queryMoney();
	}
}
