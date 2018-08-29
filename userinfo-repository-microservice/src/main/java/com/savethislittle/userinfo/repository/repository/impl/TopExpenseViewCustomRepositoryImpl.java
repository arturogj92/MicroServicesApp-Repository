package com.savethislittle.userinfo.repository.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.TopExpensesView;
import com.savethislittle.userinfo.repository.repository.TopExpensesViewCustomRepository;

public class TopExpenseViewCustomRepositoryImpl implements TopExpensesViewCustomRepository {

	
	@Autowired
	EntityManager em;
	
	@Override
	public List<TopExpensesView> searchTopExpenseViewByEmail(String email) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<TopExpensesView> criteriaQuery = criteriaBuilder.createQuery(TopExpensesView.class);
		Root<TopExpensesView> root = criteriaQuery.from(TopExpensesView.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
		List<TopExpensesView> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		return expensesList;
	}
	

}
