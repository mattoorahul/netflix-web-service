package com.myproject.springboot.employeecrudrestapi.dao;

import java.util.List;

import com.myproject.springboot.employeecrudrestapi.entity.Data;

public interface NetflixDAO {

	public List<Data> findAll();

	public List<Data> find(int n);

	public List<Data> findBymovieType(String movieType);

	public List<Data> findBycountry(String country);

	public List<Data> findByDate(String startDate, String endDate);

	public void save(Data data);

}