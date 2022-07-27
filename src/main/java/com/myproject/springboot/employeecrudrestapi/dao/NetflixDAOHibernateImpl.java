package com.myproject.springboot.employeecrudrestapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.springboot.employeecrudrestapi.entity.Data;


@Repository
public class NetflixDAOHibernateImpl implements NetflixDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public NetflixDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Data> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Data> theQuery = currentSession.createQuery("from netflix", Data.class);

		// execute query and get result list
		List<Data> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public List<Data> find(int n) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Data> theQuery = currentSession.createQuery("from netflix LIMIT " + n + " ", Data.class);

		// execute query and get result list
		List<Data> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public List<Data> findBymovieType(String movieType) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Data> theQuery = currentSession
				.createQuery("from employee_db.netflix where listed_in like '%" + movieType + "%' ", Data.class);

		// execute query and get result list
		List<Data> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public List<Data> findBycountry(String country) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Data> theQuery = currentSession.createQuery("from netflix where country ='" + country + "' ", Data.class);

		// execute query and get result list
		List<Data> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public List<Data> findByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Data> theQuery = currentSession.createQuery(
				"from netflix where date_added >'" + startDate + "'" + " and date_added < '" + endDate + "' ",
				Data.class);

		// execute query and get result list
		List<Data> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public void save(Data data) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.saveOrUpdate(data);
	}

}
