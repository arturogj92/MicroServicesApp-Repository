package com.savethislittle.userinfo.repository.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.repository.ExpenseCustomRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ExpenseCustomRepositoryImpl implements ExpenseCustomRepository{

	@Autowired
	EntityManager em;

	public List<Expenses> searchExpenseById(Long id) {
		System.out.println("AGJ -> ESTOY AQUI");
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Expenses> criteriaQuery = criteriaBuilder.createQuery(Expenses.class);
		Root<Expenses> root = criteriaQuery.from(Expenses.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userid"), id));
		List<Expenses> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		
	
		if (!expensesList.isEmpty())
			return expensesList;
		else
			return null;

	}

	// @Override
	// public List<Employee> simpleSearch(String data) {
	// log.info("simpleSearch dataIn => " + data);
	// CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	// CriteriaQuery<Employee> criteriaQuery =
	// criteriaBuilder.createQuery(Employee.class);
	// Root<Employee> root = criteriaQuery.from(Employee.class);
	// root.fetch(Employee_.contract);
	//
	//
	// Predicate orPredicate = criteriaBuilder.or(
	// criteriaBuilder.like(criteriaBuilder.upper(root.get(Employee_.fullName)),
	// "%"+data.toUpperCase()+"%"),
	// criteriaBuilder.like(criteriaBuilder.upper(root.get(Employee_.dni)),
	// "%"+data.toUpperCase()+"%")
	// );
	// criteriaQuery.where(orPredicate);
	//
	// List<Employee> result = em.createQuery(criteriaQuery).getResultList();
	//
	// log.info("simpleSearch dataOut => result.size(): {}" + result.size());
	// return result;
	// }

}
