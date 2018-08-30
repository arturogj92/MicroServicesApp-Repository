package com.savethislittle.userinfo.repository.repository.impl;

import java.sql.Date;
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
public class ExpenseCustomRepositoryImpl implements ExpenseCustomRepository {

	@Autowired
	EntityManager em;

	// TODO => Creo que puedo hacerla con jpa normal
	public List<Expenses> searchExpenseByEmail(String email) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Expenses> criteriaQuery = criteriaBuilder.createQuery(Expenses.class);
		Root<Expenses> root = criteriaQuery.from(Expenses.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
		List<Expenses> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		return expensesList;

	}
	
	
	
	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Expenses> criteriaQuery = criteriaBuilder.createQuery(Expenses.class);
		Root<Expenses> root = criteriaQuery.from(Expenses.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("category"), category),
							criteriaBuilder.equal(root.get("email"), email));
		List<Expenses> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		return expensesList;

	}
	
	public List<Expenses> searchExpenseByDateAndMail(String date, String email) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Expenses> criteriaQuery = criteriaBuilder.createQuery(Expenses.class);
		Root<Expenses> root = criteriaQuery.from(Expenses.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("date"), date),
							criteriaBuilder.equal(root.get("email"), email));
		List<Expenses> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		return expensesList;

	}

}
